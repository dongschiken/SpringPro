package org.doit.ik.di.test;

import org.doit.ik.di3.RecordImpl3;
import org.doit.ik.di3.RecordView3;
import org.doit.ik.di3.RecordViewImpl3;

public class Ex01 {
	
	public static void main(String[] args) {
		
		//System.out.println("hello world");
		RecordImpl3 record = new RecordImpl3();
		
		//RecordViewImpl rvi = new RecordViewImpl(record);
		RecordViewImpl3 rvi = new RecordViewImpl3(); 
		rvi.setRecord(record); // 스프링에서는 프로퍼티 방식
		rvi.input();
		rvi.output();
		
		
		System.out.println("end");
		
		
	}

}
