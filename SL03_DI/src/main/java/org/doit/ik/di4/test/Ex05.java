package org.doit.ik.di4.test;

import org.doit.ik.di4.RecordViewImpl4;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex05 {
	
	
	public static void main(String[] args) {

	String resourceLocations = "classpath:org/doit/ik/di4/application-context4.xml";
	AbstractApplicationContext gxac = new GenericXmlApplicationContext(resourceLocations);
	
	//RecordViewImpl4 rvi = gxac.getBean("recordView", RecordViewImpl4.class);
	RecordViewImpl4 rvi = (RecordViewImpl4)gxac.getBean("recordView");
		
	
	rvi.input();
	rvi.output();
	
	System.out.println("end");
	}
}