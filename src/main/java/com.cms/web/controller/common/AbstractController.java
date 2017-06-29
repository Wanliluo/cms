package com.cms.web.controller.common;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cms.common.util.Base;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AbstractController extends Base{
    public static final int pageSize=10;

    public void init(HttpServletRequest request, HttpServletResponse response) {
        super.init(request, response); // 执行父类的初始化
    }
    /**
     * 发送json对象
     * @param json
     * @return
     */
    public JSONObject sendJsonObject(JSONObject json){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("code",0);
        if(json != null){
            jsonObject.put("data",json);

        }
        return jsonObject;
    }



    /**
     * 发送json数组对象
     * @param jsonArray
     * @return
     */
    public @ResponseBody
    JSONObject sendJsonArray(JSONArray jsonArray){
        JSONObject jsonObject=new JSONObject();
//        jsonObject.put("code",0);
        jsonObject.put("data",jsonArray);
        jsonObject.getJSONArray("data");
        return jsonObject;
    }

    /**
     * 发送json数组对象
     * @param jsonArray
     * @return
     */
    public JSONObject sendJsonArray(JSONArray jsonArray,int dataCount){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("data",jsonArray);
        jsonObject.put("dataCount",dataCount);
        return jsonObject;
    }

    // 发送ajax错误信息
    public JSONObject sendErrMsgAndErrCode(Exception e){
        JSONObject json=new JSONObject();
        json.put("errMsg", e.getMessage());
        json.put("code", 0);
        return json;
    }


}
