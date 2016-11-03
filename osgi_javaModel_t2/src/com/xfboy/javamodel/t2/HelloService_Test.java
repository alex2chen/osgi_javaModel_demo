package com.xfboy.javamodel.t2;

import java.util.Iterator;
import java.util.ServiceLoader;

import com.xfboy.javamodel.t1.HelloService;
import com.xfboy.javamodel.t1.impl.HelloServiceImpl;

public class HelloService_Test {

	public static void main(String[] args) {
//		orgInvoke_test();
		metaInf_test();
			
	}
	/**
	 * 传统的方式：
	 * 1.把osgi-javamodel-t1导出成jar,构建到当前的工程中
	 * 2.直接调用
	 * 
	 */
	private static void orgInvoke_test(){
		HelloService helloService=new HelloServiceImpl();
		System.out.println(helloService.sayHello("alex"));
	}
	/**
	 * 使用meta-inf
	 * META-INF
	 * 		services
	 * 
	 * java的模块化只能做到这样的
	 * 
	 */
	private static void metaInf_test(){
		HelloService helloService=get(HelloService.class);
		System.out.println(helloService.sayHello("word"));
	}
	/**
	 * 
	 * @param clazz
	 * @return
	 */
	private static <T> T get(Class<T> clazz){
		ServiceLoader<T> serviceLoader=ServiceLoader.load(clazz);
		return serviceLoader.iterator().next();
	}

}
