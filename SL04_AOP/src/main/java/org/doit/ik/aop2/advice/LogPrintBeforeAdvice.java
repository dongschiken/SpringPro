package org.doit.ik.aop2.advice;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.MethodBeforeAdvice;

public class LogPrintBeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(
			Method method,  // add()
			Object[] args,  // 3 , 5 매개변수
			Object target   // 핵심 기능을 하는 실제 객체
			) throws Throwable {
		
		String methodName = method.getName();
		Log log = LogFactory.getLog(this.getClass());
		// 인증처리체크
		log.info(">> " + methodName + "() : LogPrintBeforeAdvice 호출됨...");
		
		
	}
	
	
	

}
