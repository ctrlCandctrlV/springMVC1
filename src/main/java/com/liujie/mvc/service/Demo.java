package com.liujie.mvc.service;

import org.springframework.stereotype.Service;


@Service
public class Demo implements IDemo{

	@Override
	public String sayHello(String name) {
		// TODO Auto-generated method stub
		return "hello" + name;
	}

}
