package org.doit.ik.di2;

import org.doit.ik.di3.RecordImpl3;
import org.doit.ik.di3.RecordViewImpl3;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// application-context.xml == 자바클래스 설정파일
@Configuration // 자바 설정파일 선언 애노테이션
public class Config {
	
	// RecordImpl record = new RecordImpl();
	// <bean id="record" class="org.doit.ik.di.RecordImpl" ></bean> 같은 코딩
	@Bean
	public RecordImpl3 record() {
		return new RecordImpl3();
	}
	
	
	// <bean id="rvi" class="org.doit.ik.di.RecordViewImpl" >
	@Bean(name = "rvi")
	public RecordViewImpl3 getRecordViewImpl() {
		RecordViewImpl3 rvi = new RecordViewImpl3();
		rvi.setRecord( record() );
		return rvi;
	}
}
