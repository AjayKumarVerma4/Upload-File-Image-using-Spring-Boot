package com.ajay.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IntegerToBinaryController {
	
	@RequestMapping(value = "/integerToBinary", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> integerToBinaryConversion(
			@RequestParam(value = "intValue", required = false) Integer intValue,HttpServletRequest request, HttpServletResponse response
			) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("Binary value is", Integer.toBinaryString(intValue));
		map.put("status", "success");
		map.put("status_code", "200");
		
		return map;
	}

}
