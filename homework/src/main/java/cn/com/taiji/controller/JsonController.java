package cn.com.taiji.controller;

import cn.com.taiji.pojo.LoginUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class JsonController {

    //后台返回json字符串
    @GetMapping("/getjson")
    @ResponseBody
    public LoginUser getjson(){
    return new LoginUser("小花","123456");
}

    //前台传入json字符串，返回pojo
    @GetMapping("sendjson")
    @ResponseBody
    public String  changeResult(LoginUser loginUser){
        System.out.println(loginUser.toString());
        return "change successfully";

    }
}
