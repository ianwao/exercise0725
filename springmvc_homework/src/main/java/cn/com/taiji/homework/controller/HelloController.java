package cn.com.taiji.homework.controller;

import cn.com.taiji.homework.pojo.User;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {
    //方法一：通过形参来传递参数
    @RequestMapping("hello01")
    public String hello01(String username, Model model){
        System.out.println("received:"+username);
        model.addAttribute("message",username);
        return "hello";
    }

    //方法二：RequestParam注解绑定传参
    @GetMapping("hello02")
    public String hello02(@RequestParam("password") String password, Model model) {
        System.out.println("received:"+password);
        model.addAttribute("message",password);
        return "hello";
    }

    //方式三：pojo接收参数
    @GetMapping("hello03")
    public String hello03(User user, Model model) {
        System.out.println("received:"+user);
        model.addAttribute("message",user);
        return "hello";
    }

    //方式四：url接收参数
    @GetMapping("/hello04/{username}")
    public String hello04(@PathVariable String username , Model model) {
        System.out.println("received:"+username);
        model.addAttribute("message", username);
        return "hello";
    }

    //方式五：原生request方式接收参数
    @GetMapping("hello05")
    public String hello05(ServletRequest request, Model model) {
        String name=request.getParameter("username");
        System.out.println("received:"+name);
        model.addAttribute("message",name);
        return "hello";
    }

}
