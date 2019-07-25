package com.ianw.bootdemo.controller;

import com.ianw.bootdemo.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Map;


@Controller
@CrossOrigin
public class HelloController {

    @Value("${web.upload-path}")
    private String uploadpath;

    private final static Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    /*后台给前台返回JSON串*/
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello world";
    }

    /*前台传参绑定到对象*/
    @RequestMapping("/adduser")
    @ResponseBody
    public void addUser(User user){
        System.out.println(user.toString());
    }

    /*thymeleaf静态页面访问*/
    @RequestMapping("/world")
    public String hello2(){
        return "world";
    }

    /*文件上传*/
    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam(value="file",required=false)MultipartFile file) {
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }

        String fileName = file.getOriginalFilename();
        String filePath = uploadpath+fileName;
        File file1 = new File(filePath);
        try {
        if(!file1.exists()){
            file1.mkdirs();
        }
        File dest = file1;
            file.transferTo(dest);
            LOGGER.info("上传成功");
            return "上传成功";
        } catch (IOException e) {
            LOGGER.error(e.toString(), e);
        }
        return "上传失败！";
    }

    /**
     * 前台传参到后台的方式
     */
    @GetMapping("/way1/{id}")
    @ResponseBody
    public String way1(int id){
        System.out.println(id);
        return "way1: id="+id;
    }

    @GetMapping("/way2")
    @ResponseBody
    public String way2(int id){
        System.out.println(id);
        return "way2: id="+id;
    }

    @GetMapping("/way3")
    @ResponseBody
    public String way3(Map map){
        System.out.println(map.isEmpty());
        return "way03";
    }

    @GetMapping("/way4")
    @ResponseBody
    public String way4(User user){
        System.out.println(user.toString());
        return user.toString();
    }

    @GetMapping("/way5")
    @ResponseBody
    public String way5(HttpServletRequest request){
        System.out.println(request.getParameter("name"));
        return "way05";
    }
    /**
     * 后台将参数绑定到前台的方式
     */
    /*向前段传参*/
    @GetMapping("/way6")
    public String way6(Model model){
        model.addAttribute("name","小明");
        return "way06";
    }

    /*向前段传参*/
    @GetMapping("/way7")
    public String way7(HttpServletRequest request){
        request.setAttribute("name","小华");
        return "way07";
    }

    /*实现国际化语言切换*/
    @GetMapping("/way8")
    public String way8(){
        return "language";
    }
}
