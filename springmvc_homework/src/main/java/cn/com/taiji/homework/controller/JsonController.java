package cn.com.taiji.homework.controller;

import cn.com.taiji.homework.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonController {
    @RequestMapping("json01")
    @ResponseBody
    public User json01(){
        return new User("张三","254");
    }

    @RequestMapping("json02")
    @ResponseBody
    public String json02(User user){
        System.out.println(user.toString());
        return "success";
    }
}
