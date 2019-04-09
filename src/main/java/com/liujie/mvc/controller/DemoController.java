package com.liujie.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.liujie.mvc.service.IDemo;

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
	@Autowired
	public IDemo demo;
	
	@RequestMapping(params="method=login")
	public String  login() {
		log.info("--------------------------------");
		return "demo";
	}
	
	@RequestMapping(params="method=hello")
	public String  hello(String name, Model model) {
		log.info("----------- hello ---------------------");
		String result = demo.sayHello(name);
		model.addAttribute("result", result);
		return "showResult";
	}
	
	@RequestMapping(params="method=jsp")
	public String  jsp(Model model) {
		log.info("----------- jsp ---------------------");
		model.addAttribute("result", "result for jsp");
		return "showResult";
	}
	
	@RequestMapping(params="method=vm")
	public String  vm(Model model) {
		log.info("----------- vm ---------------------");
		model.addAttribute("result", "result for vm");
		return "demo";
	}
}
