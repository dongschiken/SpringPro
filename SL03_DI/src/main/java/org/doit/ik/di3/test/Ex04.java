package org.doit.ik.di3.test;

import org.doit.ik.di3.RecordViewImpl3;
import org.springframework.context.support.GenericXmlApplicationContext;


public class Ex04 {
	
	public static void main(String[] args) {

	String resourceLocations = "classpath:org/doit/ik/di3/application-context3.xml";
	GenericXmlApplicationContext gxac = new GenericXmlApplicationContext(resourceLocations);
	
	RecordViewImpl3 rvi = gxac.getBean("rvi", RecordViewImpl3.class);
	
	rvi.input();
	rvi.output();
	
	System.out.println("end");
	System.out.println("내가 왔다감");
	}
}
