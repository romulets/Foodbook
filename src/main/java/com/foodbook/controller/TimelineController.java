package com.foodbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TimelineController {

	@RequestMapping(value="/timeline", method=RequestMethod.GET)
	public String index() {
		return "timeline";
	}
	
}
