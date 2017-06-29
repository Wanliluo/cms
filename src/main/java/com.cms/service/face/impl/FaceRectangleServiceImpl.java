package com.cms.service.face.impl;

import com.cms.common.entity.face.FaceRectangle;
import com.cms.common.util.WebConstants;
import com.cms.mapper.face.FaceRectangleMapper;
import com.cms.service.face.FaceRectangleService;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.framework.dao.CommonDao;
import net.sf.json.JSONArray;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.net.URI;
import java.util.Collections;
import java.util.List;


/**
* UserService实现
* user:zwl
* date:2014/9/13
* time:14:50
*/
@Service("faceRectangleService")
public class FaceRectangleServiceImpl implements FaceRectangleService {

    @Autowired
    CommonDao commonDao;
    @Autowired
    FaceRectangleMapper faceRectangleMapper;

    @Override
    public List<FaceRectangle> queryByPersonId(Integer personId) throws Exception {
        List<FaceRectangle> faceRectangleList = Collections.emptyList();
        if(personId != null && !(personId.equals(""))) {
            try {
                faceRectangleList = faceRectangleMapper.queryByPersonId(personId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
                System.out.println("personId不能为空！！！");
            }
        return faceRectangleList;
    }

    @Override
    public FaceRectangle queryById(Integer id) throws Exception {
        FaceRectangle faceRectangle = new FaceRectangle();
        if(id != null && !(id.equals(""))) {
            try {
                 faceRectangle = faceRectangleMapper.queryById(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("Id不能为空！！！");
        }
        return faceRectangle;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = { SSException.class, Exception.class, RuntimeException.class })
    public void addFaceRectangle(FaceRectangle faceRectangle) throws SSException {
        if(faceRectangle!=null){
            try {
                System.out.println("参数是："+faceRectangle.getAnger());
                commonDao.update(faceRectangle);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("faceRectangle不能为空！！！");
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = { SSException.class, Exception.class, RuntimeException.class })
    public void delFaceRectangle(Integer id) throws Exception {
        if(id != null && !(id.equals(""))) {
            try {
                faceRectangleMapper.delFaceRectangle(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("Id不能为空！！！");
        }
    }

    @Override
    public FaceRectangle face(String address) throws Exception {
        HttpClient httpclient = HttpClients.createDefault();
        FaceRectangle faceRectangle = new FaceRectangle();
        try {
            URIBuilder builder = new URIBuilder(WebConstants.urlBuilder);
            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);
            request.setHeader(WebConstants.typeName, WebConstants.typeValue);
            request.setHeader(WebConstants.keyName, WebConstants.personKey);
            // Request body
            StringEntity reqEntity = new StringEntity(address);
            request.setEntity(reqEntity);
            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                if (entity != null) {
                    String personstr = EntityUtils.toString(entity);  //将json字符串转换为java字符串
                    JSONArray ListArray = JSONArray.fromObject(personstr); //将java字符串转换为json对象数组
                    for (int i = 0; i < ListArray.size(); i++) {            //遍历json数组
                        faceRectangle.setAnger(ListArray.getJSONObject(0).getJSONObject("scores").getDouble("anger"));
                        faceRectangle.setContempt(ListArray.getJSONObject(0).getJSONObject("scores").getDouble("contempt"));
                        faceRectangle.setDisgust(ListArray.getJSONObject(0).getJSONObject("scores").getDouble("disgust"));
                        faceRectangle.setFear(ListArray.getJSONObject(0).getJSONObject("scores").getDouble("fear"));
                        faceRectangle.setHappiness(ListArray.getJSONObject(0).getJSONObject("scores").getDouble("happiness"));
                        faceRectangle.setNeutral(ListArray.getJSONObject(0).getJSONObject("scores").getDouble("neutral"));
                        faceRectangle.setSadness(ListArray.getJSONObject(0).getJSONObject("scores").getDouble("sadness"));
                        faceRectangle.setSurprise(ListArray.getJSONObject(0).getJSONObject("scores").getDouble("surprise"));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return faceRectangle;
    }

    @Override
    public FaceRectangle face1(String address) throws Exception {
        HttpClient httpclient = HttpClients.createDefault();
        FaceRectangle faceRectangle = new FaceRectangle();

        try
        {
            URIBuilder builder = new URIBuilder("https://api.cognitive.azure.cn/emotion/v1.0/recognize");
            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);
            request.setHeader("Content-Type", "application/octet-stream");
            request.setHeader("Ocp-Apim-Subscription-Key", "1828b089c1574772bdb9aa989036b97e");
            String pic_path = "address";//本地图片路径
            System.out.println(pic_path);
            FileInputStream is = new FileInputStream(pic_path);
            int i = is.available(); // 得到文件大小
            byte data[] = new byte[i];
            is.read(data); // 将数据读到data中
            is.close();
            ByteArrayEntity bae = new ByteArrayEntity(data);
            request.setEntity(bae);
            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();

//        try {
//            URIBuilder builder = new URIBuilder(WebConstants.urlBuilder);
//            URI uri = builder.build();
//            HttpPost request = new HttpPost(uri);
//            request.setHeader(WebConstants.typeName, WebConstants.typeValue);
//            request.setHeader(WebConstants.keyName, WebConstants.personKey);
//            // Request body
//            StringEntity reqEntity = new StringEntity(address);
//            request.setEntity(reqEntity);
//            HttpResponse response = httpclient.execute(request);
//            HttpEntity entity = response.getEntity();
            if (entity != null) {
                if (entity != null) {
                    String personstr = EntityUtils.toString(entity);  //将json字符串转换为java字符串
                    JSONArray ListArray = JSONArray.fromObject(personstr); //将java字符串转换为json对象数组
                    for (int j = 0; j < ListArray.size(); j++) {            //遍历json数组
                        faceRectangle.setAnger(ListArray.getJSONObject(0).getJSONObject("scores").getDouble("anger"));
                        faceRectangle.setContempt(ListArray.getJSONObject(0).getJSONObject("scores").getDouble("contempt"));
                        faceRectangle.setDisgust(ListArray.getJSONObject(0).getJSONObject("scores").getDouble("disgust"));
                        faceRectangle.setFear(ListArray.getJSONObject(0).getJSONObject("scores").getDouble("fear"));
                        faceRectangle.setHappiness(ListArray.getJSONObject(0).getJSONObject("scores").getDouble("happiness"));
                        faceRectangle.setNeutral(ListArray.getJSONObject(0).getJSONObject("scores").getDouble("neutral"));
                        faceRectangle.setSadness(ListArray.getJSONObject(0).getJSONObject("scores").getDouble("sadness"));
                        faceRectangle.setSurprise(ListArray.getJSONObject(0).getJSONObject("scores").getDouble("surprise"));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return faceRectangle;
    }
}
