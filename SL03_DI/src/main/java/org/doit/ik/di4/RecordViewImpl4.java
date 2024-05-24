package org.doit.ik.di4;

import java.util.Scanner;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component // 만약 Component 로 Bean객체 등록하면 등록된 클래스의 앞글자를 소문자로 바꾼것이 이름으로 등록된다.
// @Component("record1") 이런식으로 이름을 등록할 수도 있다.
public class RecordViewImpl4 implements RecordView4 {

	
	@Inject
	@Named(value = "record1") 
	private RecordImpl4 record = null;
	
	public RecordViewImpl4() {}
	
	// 1. 생성자를 통해서 외부에서 주입받는다.
	public RecordViewImpl4(RecordImpl4 record) {
		this.record = record;
	}
	


	@Override
	public void input() {
		try (Scanner sc = new Scanner(System.in)){
			System.out.println("record input kor eng mat.....");
			//this.record = new RecordImpl();
			int kor = sc.nextInt();
			int eng = sc.nextInt();
			int mat = sc.nextInt();
			
			this.record.setKor(kor);
			this.record.setEng(eng);
			this.record.setMat(mat);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void output() {
		System.out.printf("> kor=%d, eng=%d, mat=%d, tot=%d, avg=%.2f\n"
				, this.record.getKor()
				, this.record.getEng()
				, this.record.getMat()
				, this.record.total()
				, this.record.avg() 
				);
	}

}
