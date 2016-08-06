package com.nexters.tagit.controller;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.nexters.tagit.model.User;
import com.nexters.tagit.mapper.*;
@Controller
public class AjaxController {
	
	
	@Autowired
	UserMapper userMapper;
	
	//ajax 요청시 객체를 만들고 데이터 삽입 후 json 형식으로 다시 반환해줌
	@RequestMapping(value="/ajaxUserInfo",method = RequestMethod.POST)
	public void user(HttpSession session,HttpServletRequest request, HttpServletResponse response,@RequestBody User userInfo) throws IOException{
		System.out.println("들어옴");
		System.out.println(userInfo);
		System.out.println(userInfo.getId());
		System.out.println(userInfo.getName());
		
		if(userMapper.selectById(userInfo) == null)	// 디비에 저장되 있는 회원인지 검색 기존에 있는 회원이 아니면
		{
			userMapper.insertUser(userInfo);		// 디비에 저장
		}
		else{
			System.out.println("이미 있는 회원 정보");	// 있는 회원이면 저장하지 않음
		}
		
		session.setAttribute("userLoginInfo", userInfo);	// user 정보를 세션에 저장

		
		
	
		
		
		
	}
	
}
