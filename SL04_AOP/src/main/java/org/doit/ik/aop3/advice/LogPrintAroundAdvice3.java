package org.doit.ik.aop3.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
public class LogPrintAroundAdvice3 implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation method) throws Throwable {
		StopWatch sw = new StopWatch();
		sw.start();
		String methodName = method.getMethod().getName();
		Log log = LogFactory.getLog(this.getClass());
		log.info("> " + methodName + "() start. ");
		Object result = method.proceed(); // 핵심 기능
		log.info("> " + methodName + "() end. ");
		sw.stop();
		log.info("> " + methodName + "() 처리시간 " + sw.getTotalTimeMillis());
		return result;
	}
}
