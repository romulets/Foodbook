package com.foodbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/* Controller for test purposes */

@Controller
public class TestController {

	@RequestMapping(value="testrole")
	public String test(){
		return "/to_delete/test_for_role";
	}
	
}
