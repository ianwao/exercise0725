package cn.com.taiji.spring_boot.controller;

import cn.com.taiji.spring_boot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/validator")
public class ValidateController {
    @GetMapping("/registry")
    public String index(@ModelAttribute("user")User user){
        return "registry";
    }

    @GetMapping("/join")
    public String join(@Validated User user, BindingResult result, Model model){
        System.out.println(user);
        if ((user.getMobile().length()>11) || (user.getMobile().length()<=0)){
            FieldError error = new FieldError("user","mobile","手机号必须为1-11位");
            result.addError(error);
        }
        if (!user.getEmail().contains(user.getName())){
            FieldError error = new FieldError("user","email","邮箱未包含姓名");
            result.addError(error);
        }
        if (result.hasErrors()){
            System.out.println(model);
            return "registry";
        }
        return "success";
    }
}
