package cn.com.taiji.controller;

import cn.com.taiji.pojo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;

@Controller

public class ParamController {
	@Autowired
    ApplicationContext applicationContext;

	@GetMapping("/path/{id}")
	public String path(@PathVariable("id") String id, Model model) {
		System.out.println(id);
		return "param";	
	}
	@GetMapping("/single")
	public String single(String id, Model model) {
		System.out.println(id);
		return "param";	
	}
	@GetMapping("mapParam")
	public String mapParam( Map<String,Object> map) {
		map.put("name", Arrays.asList("tom","Jerry","Mike"));

		System.out.println(map);
		return "param";	
	}
	@GetMapping("objectParam")
	public String objectParam( User user) {

		System.out.println(user.toString());
		return "param";	
	}
	@GetMapping("nativeParam")
	public String nativeParam(HttpServletRequest request) {
		System.out.println(request.getAttribute("name"));
		return "param";	
	}




}
