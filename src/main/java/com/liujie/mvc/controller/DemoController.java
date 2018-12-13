package com.liujie.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/demo.do")
public class DemoController {
	
	Logger log = LoggerFactory.getLogger(DemoController.class);
	
	/*@RequestMapping(value="demo")
	public void demo5() {
		log.info("DemoController �ɹ���!!!!!!!!");
	}
	
	@RequestMapping(value="demo2")
	public String demo3() {
		log.info("DemoController �ɹ���!!!!!!!!");
		return "demo";
	}*/
	
	@RequestMapping(params="method=login")
	public String  login() {
		log.info("--------------------------------");
		return "demo";
	}
	
	@RequestMapping(params="method=hello")
	public String  hello(Model model) {
		log.info("--------------------------------");
		model.addAttribute("name", "yinshi");
		return "demo";
	}
}
