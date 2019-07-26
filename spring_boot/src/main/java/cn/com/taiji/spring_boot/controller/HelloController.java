package cn.com.taiji.spring_boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	@GetMapping("/helloworld")
	@ResponseBody
	public String Hello() {
		System.out.println("直接显示");
		return "helloworld";
	}

}
