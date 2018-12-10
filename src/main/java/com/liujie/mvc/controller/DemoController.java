package com.liujie.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo.do")
public class DemoController {
	
	Logger log = LoggerFactory.getLogger(DemoController.class);
	
	/*@RequestMapping(value="demo")
	public void demo5() {
		log.info("DemoController 成功了!!!!!!!!");
	}
	
	@RequestMapping(value="demo2")
	public String demo3() {
		log.info("DemoController 成功了!!!!!!!!");
		return "demo";
	}*/
	
	@RequestMapping(params="method=login")
	public String  login() {
		log.info("--------------------------------");
		return "demo";
	}
}
