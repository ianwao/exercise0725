package cn.com.taiji.interceptor;

import cn.com.taiji.controller.LoginController;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class TimeInterceptor implements HandlerInterceptor {

    //controller之前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("当前访问时间"+new Date());
        System.out.println("TimeInterceptor prehandle");
        return true;
    }

    //controller执行之后
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("TimeInterceptor posthandle");
    }

    //视图渲染之后，回收资源
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("TimeInterceptor afterhandle");
    }
}
