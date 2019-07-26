package cn.com.taiji.spring_boot.controller;

import cn.com.taiji.spring_boot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class GetParamController {
    //获取多个值@GetMapping("/path/{id}/{name}/..")
    @GetMapping("/path/{id}")
    public String way2(@PathVariable("id") int id){
        System.out.println(id);
        return "hello";
    }

    @GetMapping("/single")
    public String single(String id, Model model){
        return "hello";
    }

    @GetMapping("/mapParam")
    public String mapParam(@RequestParam Map map){
        return "hello";
    }

    @PostMapping("/object")
    @ResponseBody
    public String object(User user){

        return "hello";
    }

    @GetMapping("/httpRequest")
    public String httpRequest(HttpServletRequest request){
        System.out.println(request.getAttribute("name"));
        return "hello";
    }
}
