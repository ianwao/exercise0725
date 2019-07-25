package cn.com.taiji.controller;

import cn.com.taiji.pojo.LoginUser;


import org.apache.catalina.Session;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller

public class LoginController {
    //登录
    @GetMapping("/login")
    public String prelogin(){
        return "login";
    }

//将登录的用户存放到session，便于拦截器测试
    @PostMapping("/user/login")
    public String login(@Validated LoginUser loginUser,HttpServletRequest request){

        HttpSession session=request.getSession();
        session.setAttribute("username",loginUser);

            return "success";

    }

}
