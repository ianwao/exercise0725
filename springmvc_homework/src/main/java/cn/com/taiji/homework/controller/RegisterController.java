package cn.com.taiji.homework.controller;

import cn.com.taiji.homework.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {
    @GetMapping("/")
    public String hi(@ModelAttribute("user") User user){
        return "register";
    }


    @PostMapping("register")
    public String register(@Validated  User user, BindingResult result, Model model){
        System.out.println("received:"+user);
        if (!user.getEmail().contains(user.getUsername())){
            FieldError error=new FieldError("user","email","邮箱未包含名字");
            result.addError(error);
        }
        if(result.hasErrors()){
            System.out.println(model);
            return "register";
        };
        return "success";
    }
}
