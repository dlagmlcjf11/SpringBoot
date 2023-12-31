package com.example.demo;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ContentValidator implements Validator{
	@Override
	public boolean supports(Class<?> arg0) {
		return ContentDTO.class.isAssignableFrom(arg0); //검증할 객체의 클래스 타입 정보
	}
	
	@Override
	public void validate(Object obj, Errors errors) {
		ContentDTO dto = (ContentDTO)obj;
		
		/*
		 * String sWriter = dto.getWriter(); if(sWriter == null ||
		 * sWriter.trim().isEmpty()) { System.err.println("Writer is null or empty");
		 * errors.rejectValue("writer", "trouble"); }
		 */
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "writer", "writer is empty");
		String sWriter = dto.getWriter();
		if(sWriter.length() < 3) {
			errors.rejectValue("writer", "writer is too short.");
		}
		
		/*
		 * String sContent = dto.getContent(); if(sContent == null ||
		 * sContent.trim().isEmpty()) { System.out.println("Content is null or empty");
		 * errors.rejectValue("content", "trouble"); }
		 */
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "content", "content is empty.");
	}
}
