package com.cms.common.util;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 */
public abstract class Base {
    private ThreadLocal<HttpServletRequest> request = new ThreadLocal();
    private ThreadLocal<HttpServletResponse> response = new ThreadLocal();
    private ThreadLocal<String> referer = new ThreadLocal();

    public Base() {
    }

    public void init(HttpServletRequest request, HttpServletResponse response) {
        this.request.set(request);
        this.response.set(response);
        String referer = request.getHeader("Referer");
        this.referer.set(referer);
    }

    protected HttpServletRequest getRequest() {
        return this.request == null?null:(HttpServletRequest)this.request.get();
    }

    protected HttpServletResponse getResponse() {
        return this.response == null?null:(HttpServletResponse)this.response.get();
    }

    protected String getReferer() {
        return this.referer == null?null:(String)this.referer.get();
    }

    public void sendErrMsg(String eMsg) {
        this.getRequest().setAttribute("eMsg", eMsg);
    }

}

