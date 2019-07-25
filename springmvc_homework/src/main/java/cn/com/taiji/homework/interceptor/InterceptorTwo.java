package cn.com.taiji.homework.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class InterceptorTwo implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle two!");
        //普通路径放行
        if ("/yanzheng".equals(request.getRequestURI()) || "/login".equals(request.getRequestURI())) {
            return true;}
        //权限路径拦截
        Object object = request.getSession().getAttribute("users");
        if (null == object) {
            response.sendRedirect("/login");
            return false;}
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
