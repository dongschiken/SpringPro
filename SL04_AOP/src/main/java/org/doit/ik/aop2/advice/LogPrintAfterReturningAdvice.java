package org.doit.ik.aop2.advice;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.AfterReturningAdvice;

public class LogPrintAfterReturningAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(
			Object returnValue, // 결과값
			Method method, 		// 메서드
			Object[] args, 		// 매개변수
			Object target		// 실제 객체
			) throws Throwable {
		
		
		String methodName = method.getName();
		Log log = LogFactory.getLog(this.getClass());
		// 인증처리체크
		log.info(">> " + methodName + "() : LogPrintAfterReturningAdvice 호출됨...");
		
	}

	
}
