package com.cms.face;

import com.cms.AbstractTestCase;
import com.cms.common.entity.face.FaceRectangle;
import com.cms.common.enums.face.FaceEnums;
import com.cms.service.face.FaceRectangleService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wanliLuo
 * Date: 2017-04-02
 * Time: 20:27
 */
public class faceRectangleTest extends AbstractTestCase {
    @Autowired
     private FaceRectangleService faceRectangleService;

    @Test
    public void faceTest() throws Exception {
        String address ="{ \"url\": \"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491544680585&di=bfee37bd89ec85c5b4f0bd3fc1d9f181&imgtype=0&src=http%3A%2F%2Fimage.99ys.com%2F2015%2F0213%2F20150213020216974.jpg\"}";
        FaceRectangle faceRectangle=faceRectangleService.face(address);
        System.out.println("anger="+faceRectangle.getAnger()
                +","+"contempt="+faceRectangle.getContempt()
                +","+"contempt="+faceRectangle.getDisgust()
                +","+"contempt="+faceRectangle.getFear()
                +","+"contempt="+faceRectangle.getHappiness()
                +","+"contempt="+faceRectangle.getNeutral()
                +","+"contempt="+faceRectangle.getSadness()
                +","+"contempt="+faceRectangle.getSurprise());

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
           System.out.println(FaceEnums.valueOf(buf1));}
            else{ System.out.println(FaceEnums.valueOf(buf1)+"; "+FaceEnums.valueOf(buf2)+"; "+FaceEnums.valueOf(buf3));}
       System.out.println("1="+buf1+"; 2="+buf2+"; 3="+buf3);

        }




    @Test
    public void queryByIdTest(){
        FaceRectangle faceRectangle = new FaceRectangle();
        if(faceRectangle!=null){
            try {
               faceRectangle= faceRectangleService.queryById(1);
               System.out.println(faceRectangle.getId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("faceRectangle不能为空！！！");
        }
    }

    @Test
    public void addFaceRectangleTest() {
        FaceRectangle faceRectangle = new FaceRectangle();
        faceRectangle.setAnger(0.5);
        faceRectangle.setContempt(0.09);
        faceRectangle.setId(1);
        if(faceRectangle!=null){
            try {
               faceRectangleService.addFaceRectangle(faceRectangle);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("faceRectangle不能为空！！！");
        }
    }


}
