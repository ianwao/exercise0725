package cn.com.taiji.spring_boot.controller;

import cn.com.taiji.spring_boot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
//后台向前台传数据  两种方法
public class UserController {
    //1.model.addAttribute
    @GetMapping("/getUser")
    public String getUser(Model model){
        User user = new User();
        user.setName("LiLi");
        user.setAge(18);
        user.setSex("女");
        user.setMobile("123");
        user.setEmail("LiLi@qq.com");
        model.addAttribute("user",user);
        return "user";
    }

    //2.request.setAttribute
    /*public String getUser1(HttpServletRequest request){
        User user = new User();
        user.setName("LiLi");
        user.setAge(18);
        user.setSex("女");
        user.setMobile("123");
        user.setEmail("LiLi@qq.com");
        request.setAttribute("user",user);
        return "user";
    }*/
}
