package org.doit.ik.di2.test;


import org.doit.ik.di2.Config;
import org.doit.ik.di3.RecordViewImpl3;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex03 {
	
	public static void main(String[] args) {

	AnnotationConfigApplicationContext acalc = new AnnotationConfigApplicationContext(Config.class);
	RecordViewImpl3 rvi = acalc.getBean("rvi", RecordViewImpl3.class);
	
	rvi.input();
	rvi.output();
	
	System.out.println("end");
	
	acalc.close();
	
	}	
}
