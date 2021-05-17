package myfiterchain;

import java.util.HashMap;

public class HttpServletRequest {

    private String requestContent;//包含请求名字
    private HashMap<String,String> requestParams;//包含请求的参数

    //加载集合


    public String getParameter(String key){
        return requestParams.get(key);
    }
}
