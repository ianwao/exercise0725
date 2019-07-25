package com.ianw.bootdemo.controller;

import com.ianw.bootdemo.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/adduser")
    public String adduser(){
        return "login";
    }
    @RequestMapping("/add")
    public String addUser(@Validated User user, BindingResult result,Model model){
        model.addAttribute("user",user);
        if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                System.err.println(error.getDefaultMessage());
            }
            return "login";
        }
        return "success";
    }
}
