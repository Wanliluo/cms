package com.cms.common.util;


import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * Author:luowanli
 * Date:2017/4/4
 * Time:17:40
 */
public final class WebConstants {

    public static Map<String, Integer> modelTypeMap = new HashMap<String, Integer>();

    static {

        modelTypeMap.put("/user/toUserList", 3);

        modelTypeMap.put("/student/info/new", 5);
        modelTypeMap.put("/student/info/update", 6);
        modelTypeMap.put("/student/info/detail", 7);
    }


    // 错误码
    public final static String sysErrorCode = "500";

    public final static String accessErrorCode = "admin/403";

    public final static String notFoundErrorCode = "admin/404";

    //下载目录
    public final static String downloadFolder = "/download/";

    //本地开发配置
    public final static String website = "http://jysj.dsjyw.local.net/";    //网站地址
    public final static String staticWebsite = "http://jysj.dsjyw.local.net/resources/";    //静态资源站点
    public final static String puiWebsite = "http://jysj.dsjyw.local.net/resources/pui/";    //前端组件库地址
    public static final String uploadWebsite = "http://jysj.dsjyw.local.net/upload";    //上传图片网址

    //服务器开发配置
//    public final static String website = "http://jysj.dev.net/";
//    public final static String staticWebsite = "http://jysj.dev.net/resources/";
//    public final static String puiWebsite = "http://jysj.dev.net/resources/pui/";
//    public static final String uploadWebsite = "http://jysj.dev.net/upload/";

    //正式服务器配置
//    public final static String website = "http://jysjtest.dsjyw.net/";
//    public final static String staticWebsite = "http://jysjtest.dsjyw.net/resources/";
//    public final static String puiWebsite = "http://jysjtest.dsjyw.net/resources/pui/";
//    public static final String uploadWebsite = "http://jysjtest.dsjyw.net/upload/";


    public final static String webFullName = "TheFriendOfHeart";
    public final static String webName = "TheFriendOfHeart";

    public final static int schoolCode = 10200;
    public final static String school = "TheFriendOfHeart";

    //表情测试参数
    public final static String urlBuilder = "https://api.cognitive.azure.cn/emotion/v1.0/recognize";
    public final static String typeName = "Content-Type";
    public final static String typeValue = "application/json";
    public final static String keyName = "Ocp-Apim-Subscription-Key";
    public final static String personKey = "1828b089c1574772bdb9aa989036b97e";
}
