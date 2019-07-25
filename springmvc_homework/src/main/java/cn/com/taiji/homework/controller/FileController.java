package cn.com.taiji.homework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

@Controller
public class FileController {
    @RequestMapping("/hello")
    public String hello(){
        System.out.println("hello");
        return "file";
    }

    //文件上传
    @PostMapping("/fileupload")
    public String fileupload(@RequestPart("file") MultipartFile file) {
        File basePath=new File("E:/springMvc");
        if(!basePath.exists()) {
            basePath.mkdirs();
        }
        File fullFileName=new File(basePath,file.getOriginalFilename());
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(file.getInputStream());
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fullFileName))) {
            byte[] buffer = new byte[1024 * 10];
            int len = 0;
            while ((len = bufferedInputStream.read(buffer)) > 0) {
                bufferedOutputStream.write(buffer, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }
}
