package com.cms.web.controller.face;

import com.cms.common.entity.face.FaceRectangle;
import com.cms.common.entity.face.Person;
import com.cms.common.entity.face.PersonRecommend;
import com.cms.common.entity.face.Recommend;
import com.cms.common.enums.face.FaceEnums;
import com.cms.web.controller.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sun.misc.BASE64Decoder;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.List;

/**
 * Created by 1 on 2017/4/6.
 */

@Controller
@RequestMapping(value = "person")
public class PersonController extends AbstractController {

    //去首页(展示可推荐的材料)
    @RequestMapping(value="toindex", method =RequestMethod.GET)
    public String toIndex(Model model) {
        try {
            List<Recommend> videoList = recommendService.queryByCategory(1);
            List<Recommend> musicList = recommendService.queryByCategory(2);
            List<Recommend> bookList = recommendService.queryByCategory(3);
            List<Recommend> sportList = recommendService.queryByCategory(4);
            List<Recommend> photoList = recommendService.queryByCategory(5);  //首页轮播图片
            model.addAttribute("videoList", videoList);
            model.addAttribute("musicList", musicList);
            model.addAttribute("bookList", bookList);
            model.addAttribute("sportList", sportList);
            model.addAttribute("photoList", photoList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "face/index";
    }

    //去登录页
    @RequestMapping(value="/tologin", method =RequestMethod.GET)
    public String toLogin() {
       return "face/login";
    }

    //登录
    @RequestMapping(value="/login", method =RequestMethod.GET)
    public String login(@RequestParam("userName") String userName, @RequestParam("password") String password, Model model,  RedirectAttributes redirectAttributes) throws Exception {
        Person person = personService.queryByUserName(userName);
        Person person1 = new Person();
        person1.setPassword(password);
        person1.setUserName(userName);
        String newPassword = personService.encryptPassword(person1);
        if (person == null || !(person.getPassword().equals(newPassword))) {
            redirectAttributes.addFlashAttribute("msg", "用户名或密码错误");
            return "redirect:/";
        }
        if (person != null && (person.getPassword().equals(newPassword))) {
            String successUrl = "/"  + "person/" +"/topersonal/"+ person.getId();
            return "redirect:" + successUrl;
        }
        return "redirect:/";
        }

    //去注册页
    @RequestMapping(value="/toregister", method =RequestMethod.GET)
    public String toRegister() {
        return "face/register";
    }

    //注册
    @RequestMapping(value="/register", method =RequestMethod.POST)
    public String register(@RequestParam("person") Person person, RedirectAttributes redirectAttributes) {
        try {
            int  a= personService.isExistUserName(person.getUserName());
            if(a==0) {
                personService.addPerson(person);}
            else{
                redirectAttributes.addFlashAttribute("msg", "用户已存在！");
                return "redirect:/";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "face/login";
    }

    //去个人详情页
    @RequestMapping(value="/topersonal/{id}", method = RequestMethod.GET)
    public String toDetail(@PathVariable("id") Integer id, Model model) {
        try {
            Person person = personService.queryById(id);
            List<FaceRectangle>  faceRectangleList = faceRectangleService.queryByPersonId(person.getId());
//            List<PersonRecommend> personRecommendList =personRecommendService.queryByPersonId(person.getId());
            List<Recommend> recommendList = recommendService.queryAll();
            model.addAttribute("faceRectangleList", faceRectangleList);
//            model.addAttribute("personRecommendList", personRecommendList);
            model.addAttribute("person", person);
            model.addAttribute("recommendList", recommendList);
        } catch (Exception e) {
            e.printStackTrace();
        }
      return "face/personal";
    }

    //去推荐详情页
    @RequestMapping(value="/torecommend/{faceRectangleId}", method = RequestMethod.GET)
    public String toRecommend(@PathVariable("faceRectangleId") Integer faceRectangleId, Model model) {
        try {

           List<PersonRecommend> personRecommendList = personRecommendService.queryByFaceRectangleId(faceRectangleId);
            List<Recommend> recommendList = Collections.emptyList();
           for(int i=0; i<personRecommendList.size(); i++) {
              Recommend recommend=recommendService.queryById(personRecommendList.get(i).getRecommendId());recommendList.add(recommend);
           }
            model.addAttribute("recommendList", recommendList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "face/detail";
    }


    //去表情测试页
    @RequestMapping(value="/toface/{personId}", method =RequestMethod.GET)
    public String toFace(@PathVariable("personId") Integer personId, Model model) {
        model.addAttribute("personId", personId);
        return "face/face";
    }

    //表情测试
    @RequestMapping(value="ajax/face", method = RequestMethod.GET)
    @ResponseBody
    public String face(@RequestParam("personId") Integer personId, @RequestParam("address") String address, Model model) {
        BASE64Decoder decoder = new BASE64Decoder();
        try
        {
            //Base64解码
            byte[] b = decoder.decodeBuffer(address);
            for(int i=0;i<b.length;++i)
            {
                if(b[i]<0)
                {//调整异常数据
                    b[i]+=256;
                }
            }
            //生成jpeg图片
            String imgFilePath = "G://222.jpg";//新生成的图片
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();
        }
        catch (Exception e)
        {

        }

        try {
            FaceRectangle faceRectangle = faceRectangleService.face(address);
            faceRectangle.setPersonId(personId);
            faceRectangle.setAddress(address);
            faceRectangleService.addFaceRectangle(faceRectangle);
            Integer id = Collections.max(personRecommendService.query(personId));
            double Array[] =new double[9];
            Array[0]=faceRectangle.getAnger();
            Array[1]=faceRectangle.getContempt();
            Array[2]=faceRectangle.getDisgust();
            Array[3]=faceRectangle.getFear();
            Array[4]=faceRectangle.getHappiness();
            Array[5]=faceRectangle.getNeutral();
            Array[6]=faceRectangle.getSadness();
            Array[7]=faceRectangle.getSurprise();
            int buf1,buf2,buf3;
            buf1=buf2=buf3=0;
            for(int i=0;i<=7;i++)
            {
                if(Array[i]>=Array[buf1])
                {
                    buf3=buf2;
                    buf2=buf1;
                    buf1=i;
                }
                else if(Array[i]>=Array[buf2])
                {
                    buf3=buf2;
                    buf2=i;
                }
                else if(Array[i]>=Array[buf3])
                {
                    buf3 = i;
                }
            }
            if(Array[buf1]>=0.5){
                List<Recommend> videoList = recommendService.queryByGradeAndCategory(1,buf1);
                List<Recommend> musicList = recommendService.queryByGradeAndCategory(2,buf1);
                List<Recommend> bookList = recommendService.queryByGradeAndCategory(3,buf1);
                List<Recommend>  sportList = recommendService.queryByGradeAndCategory(4,buf1);
                model.addAttribute("videoList", videoList);
                model.addAttribute("musicList", musicList);
                model.addAttribute("bookList", bookList);
                model.addAttribute("sportList", sportList);
                model.addAttribute("buf1", FaceEnums.valueOf(buf1));
                model.addAttribute("buf2", "");
                model.addAttribute("buf3", "");
            }else{
                List<Recommend> videoList = recommendService.queryByGradeAndCategory(1,buf1);
                List<Recommend> musicList = recommendService.queryByGradeAndCategory(2,buf1);
                List<Recommend> bookList = recommendService.queryByGradeAndCategory(3,buf1);
                List<Recommend>  sportList = recommendService.queryByGradeAndCategory(4,buf1);
                model.addAttribute("videoList", videoList);
                model.addAttribute("musicList", musicList);
                model.addAttribute("bookList", bookList);
                model.addAttribute("sportList", sportList);
                model.addAttribute("buf1", FaceEnums.valueOf(buf1));
                model.addAttribute("buf2", FaceEnums.valueOf(buf2));
                model.addAttribute("buf3", FaceEnums.valueOf(buf3));
            }
            List<Recommend> recommendList = recommendService.queryByGrade(buf1);
            for(int i = 0; i < recommendList.size(); i++) {
                PersonRecommend personRecommend= new PersonRecommend();
                personRecommend.setPersonId(personId);
                personRecommend.setFaceRectangleId(id);
                personRecommend.setRecommendId(recommendList.get(i).getId());
                personRecommendService.addPersonRecommend(personRecommend);
            }

            model.addAttribute("faceRectangle", faceRectangle);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "face/result";
    }
}
