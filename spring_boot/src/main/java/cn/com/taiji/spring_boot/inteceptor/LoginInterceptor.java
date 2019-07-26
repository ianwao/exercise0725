package cn.com.taiji.spring_boot.inteceptor;

import cn.com.taiji.spring_boot.model.LoginUser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("登录--preHandle");
        String requestURI = request.getRequestURI();
        if (requestURI.indexOf("/login")>=0){
            System.out.println("直接跳出");
            return true;
        }
        HttpSession session = request.getSession();
        LoginUser loginUser =(LoginUser) session.getAttribute("USER_SESSION");
        if (loginUser.getUsername() != null){
            return true;
        }
        request.setAttribute("msg","您还没登录，请先登录");
        request.getRequestDispatcher("/resources/templates/login.html").forward(request,response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("登录--postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("登录--afterCompletion");
    }
}
