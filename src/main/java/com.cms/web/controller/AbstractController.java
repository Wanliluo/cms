package com.cms.web.controller;

import com.cms.service.face.FaceRectangleService;
import com.cms.service.face.PersonRecommendService;
import com.cms.service.face.PersonService;
import com.cms.service.face.RecommendService;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.framework.bean.StaticAutoWire;
import com.pandawork.core.framework.web.spring.controller.Base;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AbstractController extends Base {

    //每页的数据条数
    public static final int pageSize = 15;
    // ajax默认成功代码
    protected final static int AJAX_SUCCESS_CODE = 0;
    // ajax默认失败代码
    protected final static int AJAX_FAILURE_CODE = 1;

    // 添加成功
    protected final static String NEW_SUCCESS_MSG = "提交成功!";

    // 修改成功
    protected final static String UPDATE_SUCCESS_MSG = "修改成功!";


    public void init(HttpServletRequest request, HttpServletResponse response) {
        super.init(request, response); // 执行父类的初始化
    }

    /**
     * 发送json对象
     *
     * @param json
     * @return
     */
    public JSONObject sendJsonObject(JSONObject json) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 0);
        if (json != null) {
            jsonObject.put("data", json);
        }
        return jsonObject;
    }

    /**
     * 发送无数据与的json对象
     *
     * @param code
     * @return
     */
    protected JSONObject sendJsonObject(int code) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", code);
        return jsonObject;
    }

    /**
     * 发送json对象
     *
     * @param json
     * @return
     */
    protected JSONObject sendJsonObject(JSONObject json, int code) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", code);
        if (json != null) {
            jsonObject.put("data", json);
        }
        return jsonObject;
    }

    /**
     * 发送json数组对象
     *
     * @param jsonArray
     * @return
     */
    public
    @ResponseBody
    JSONObject sendJsonArray(JSONArray jsonArray) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 0);
        jsonObject.put("data", jsonArray);
        return jsonObject;
    }

    /**
     * 发送json数组对象
     *
     * @param jsonArray
     * @return
     */
    public JSONObject sendJsonArray(JSONArray jsonArray, int dataCount) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 0);
        jsonObject.put("data", jsonArray);
        jsonObject.put("dataCount", dataCount);
        return jsonObject;
    }

    // 发送ajax错误信息
    public JSONObject sendErrMsgAndErrCode(SSException e) {
        JSONObject json = new JSONObject();
        json.put("errMsg", e.getMessage());
        json.put("code", e.getCode());
        return json;
    }

    // 发送ajax错误信息(字符串)
    public JSONObject sendErrMsgAndErrCode(String e) {
        JSONObject json = new JSONObject();
        json.put("errMsg", e);
        json.put("code", 1);
        return json;
    }


    //表情测试service
    @StaticAutoWire
    protected static FaceRectangleService faceRectangleService;

    @StaticAutoWire
    protected static PersonRecommendService personRecommendService;

    @StaticAutoWire
    protected static PersonService personService;

    @StaticAutoWire
    protected static RecommendService recommendService;
}
