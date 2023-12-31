package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	@GetMapping("/")
	public @ResponseBody String root() throws Exception {
		return "Model & View";
	}
	
	@GetMapping("/test1")
	public String test1(Model model) {
		// Model 객체를 이요해서, view로 Data 전달
		// 데이터만 설정이 가능
		model.addAttribute("name", "홍길동");
		return "test1";
	}
	
	@GetMapping("/mv")
	public ModelAndView test2() {
		//데이터와 뷰를 동시에 설정이 가능
		ModelAndView mv = new ModelAndView();
		
		List<String> list = new ArrayList<>();
		
		list.add("test1");
		list.add("test2");
		list.add("test3");
		
		mv.addObject("lists", list); //jstl로 호출
		mv.addObject("ObjectTest", "테스트입니다."); //jstl로 호출
		mv.addObject("name", "홍길동"); //jstl로 호출
		mv.setViewName("view/myView");
		
		return mv;
	}
}
