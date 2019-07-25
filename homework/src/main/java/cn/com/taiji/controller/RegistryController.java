package cn.com.taiji.controller;

import cn.com.taiji.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import java.io.File;

@Controller

public class RegistryController {
    @GetMapping("/registry")
    public String regisrty(@ModelAttribute("user") User user){
        return "registry";
    }
    @PostMapping("/join")
    public  String join(@Validated User user, BindingResult bindingResult, Model model){
        System.out.println(user);
        if(!user.getEmail().contains(user.getName())){
            FieldError error=new FieldError("user","email","邮箱包含用户名");
            bindingResult.addError(error);
        }
        if(user.getPassword().length()<6||user.getPassword().length()>20){
            FieldError error=new FieldError("user","password","邮箱包含用户名");
            bindingResult.addError(error);
        }

        if(bindingResult.hasErrors()){
            System.out.println(model);
            return "registry";
        }
        return "registrysuccess";
    }
}
