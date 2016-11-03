package com.xfboy.javamodel.t1.impl;

import com.xfboy.javamodel.t1.HelloService;

public class HelloServiceImpl implements HelloService {

	@Override
	public String sayHello(String name) {
		// TODO Auto-generated method stub
		return "hello,"+name;
	}

}
