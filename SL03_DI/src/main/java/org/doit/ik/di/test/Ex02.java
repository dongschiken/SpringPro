package org.doit.ik.di.test;

import org.doit.ik.di3.RecordImpl3;
import org.doit.ik.di3.RecordViewImpl3;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex02 {
	
	public static void main(String[] args) {
		// 1. 스프링 DI
	// 스프링 컨테이너(공장)	== ApplicationContext
	// RecordImpl record	스프링 빈 객체
	// RecordViewImpl rvi   스프링 빈 객체
	
	//System.out.println("hello world");
	
	//String resourceLocations = "classpath:org/doit/ik/di/application-context.xml";
	String resourceLocations = "application-context.xml";
	GenericXmlApplicationContext gxac = new GenericXmlApplicationContext(resourceLocations);
	
	
//	RecordViewImpl rvi = (RecordViewImpl) gxac.getBean("record")
	RecordViewImpl3 rvi = gxac.getBean("rvi", RecordViewImpl3.class);
	
	rvi.input();
	rvi.output();
	
	
	System.out.println("end");
	}
	
	
}
