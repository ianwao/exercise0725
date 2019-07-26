package cn.com.taiji.spring_boot.controller;

import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/world",method=RequestMethod.GET)
public class WorldController {
	@CrossOrigin(origins = "http://127.0.0.1:8082")
	@RequestMapping(value="/cross")
	public String worldCross() {

		return "worldcross";
	}

}
