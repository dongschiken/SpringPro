package org.doit.ik.aop;

public class Ex01 {
	
	public static void main(String[] args) {

		// 1. Calculator 인터페이스 + - * /
		// 2. CalculatorImpl 클래스 구현
		// 3. Ex01.java에서 테스트
		Calculator cal = new CalculatorImpl();
		
		System.out.println(cal.add(4, 2));
		System.out.println(cal.sub(4, 2));
		System.out.println(cal.mult(4, 2));
		System.out.println(cal.div(4, 2));
		
		System.out.println("end");
	} // main
}
