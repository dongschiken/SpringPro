package org.doit.ik.aop5;

import org.aspectj.lang.annotation.Aspect;
import org.doit.ik.aop.Calculator;
import org.springframework.context.support.GenericXmlApplicationContext;


public class Ex05 {
	
	public static void main(String[] args) {
 
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:org/doit/ik/aop5/application-context5.xml");
		Calculator calc = ctx.getBean("calc5", Calculator.class);
		System.out.println(calc.div(3, 5));
		System.out.println("end");
		
		
	}
}
