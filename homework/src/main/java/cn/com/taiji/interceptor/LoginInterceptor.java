package cn.com.taiji.interceptor;

import cn.com.taiji.pojo.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    //controller之前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("LoginInterceptor  prehandler");
        /*
        以下注释是为了便于测试的controller，下面注释掉的是模拟登录功能
         */
//        HttpSession session=request.getSession();
//        String user=(String) session.getAttribute("user");
//        if(user!=null){
//            return true;
//        }else{
//
//
//            response.sendRedirect("/login");
//            return false;
//
//        }
        return true;

    }

    //controller执行之后
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        System.out.println("LoginInterceptor posthandler");
    }

    //视图渲染之后，回收资源
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        System.out.println("LoginInterceptor afterhandler");
    }
}
