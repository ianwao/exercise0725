package com.ianw.bootdemo.inteceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class TestInteceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println("进入1号拦截器");
        System.out.println("访问当前接口的时间是"+new Date());

        /*验证登录*/
        /*if(request.getAttribute("pername")==null){
            return false;
        }*/

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        System.out.println("Inteceptor one postHandle");
    }

    /*在视图渲染完成后执行，用于资源回收*/
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.out.println("Inteceptor one afterCompletion");
    }
}
