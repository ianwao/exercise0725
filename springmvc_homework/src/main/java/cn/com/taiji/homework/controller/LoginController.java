package cn.com.taiji.homework.controller;

import cn.com.taiji.homework.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @RequestMapping("/index")
    public String showindex(){
        return "success";
    }
    @RequestMapping("/login")
    public String showlogin(){
        return "login";
    }
    @RequestMapping("/yanzheng")
    //也可以添加标注@ResponseBody 返回数据给页面（js跳转）
    public String yanzheng(User user , HttpServletRequest request){
        //只是密码的简单判断
        if("1234".equals(user.getPassword())){
            request.getSession().setAttribute("users", user.getUsername());
            //先添加到session,在跳转
            System.out.println("成功");
            return "success";
        }else {
            return "login";
        }
    }
}
