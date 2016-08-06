package com.nexters.tagit.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.nexters.tagit.model.User;
import com.nexters.tagit.mapper.UserMapper;




@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@Autowired
	UserMapper userDAO;
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		String msg = "환영합니다 여기는 Tagit";
		model.addAttribute("message",msg);
		
		return "home";
	}
	
	
	@RequestMapping(value = "/manki",method = RequestMethod.GET)
	public String myinfo(Model model) {
        model.addAttribute("user", userDAO.selectAll());
        return "test";
    }
	@RequestMapping(value = "/userTest",method = RequestMethod.GET)
	public String userTest(){
		return "user";
	}
	@RequestMapping(value = "/userTest2",method = RequestMethod.GET)
	public String userTest2(){
		return "tiles/body";
	}
	
	
}
