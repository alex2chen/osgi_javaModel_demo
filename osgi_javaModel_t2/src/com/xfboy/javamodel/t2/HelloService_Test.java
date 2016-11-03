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
	 * ��ͳ�ķ�ʽ��
	 * 1.��osgi-javamodel-t1������jar,��������ǰ�Ĺ�����
	 * 2.ֱ�ӵ���
	 * 
	 */
	private static void orgInvoke_test(){
		HelloService helloService=new HelloServiceImpl();
		System.out.println(helloService.sayHello("alex"));
	}
	/**
	 * ʹ��meta-inf
	 * META-INF
	 * 		services
	 * 
	 * java��ģ�黯ֻ������������
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
