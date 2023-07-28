package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.ContentDTO;
import com.example.demo.ContentValidator;

@Controller
public class MyController {
	@GetMapping("/")
	public @ResponseBody String root() throws Exception {
		return "ValidationUtils (2)";
	}
	
	@GetMapping("/insertForm")
	public String insert1() {
		return "createPage";
	}
	
	@GetMapping("/create")
	public String insert2(@ModelAttribute("dto") ContentDTO dto, BindingResult result) {
		String page = "createDonePage";
		System.out.println(dto);
		
		ContentValidator validator = new ContentValidator();
		validator.validate(dto, result);
		if(result.hasErrors()) {
			System.out.println("getAllErrors : " + result.getAllErrors());
			
			if(result.getFieldError("writer") != null) {
				System.out.println("1:"+result.getFieldError("writer").getCode());
			}
			if(result.getFieldError("content") != null) {
				System.out.println("2:"+result.getFieldError("content").getCode());
			}
			page = "createPage";
		}
		
		return page;
	}

	
}
