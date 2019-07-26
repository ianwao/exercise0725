package cn.com.taiji.spring_boot.controller;

import cn.com.taiji.spring_boot.model.LoginUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    //向用户登陆页面跳转
//    @RequestMapping("/login")
//    public String toLogin(){
//        return "login";
//    }

    //用户登录
    @RequestMapping("/login")
    public String login(LoginUser loginUser, Model model, HttpSession session){
        //获取用户名和密码
        String username = loginUser.getUsername();
        String password = loginUser.getUpassword();
        //简单判断
        if (username!=null && password!=null){
            session.setAttribute("USER_SESSION",loginUser);
            return "redirect:main";
        }
        model.addAttribute("msg","用户名或密码不能为空,请重新登录");
        return "login";
    }

    @RequestMapping("/main")
    public String toMain(){
        return "main";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        //清除session
        session.invalidate();
        return "redirect:login";
    }
}
