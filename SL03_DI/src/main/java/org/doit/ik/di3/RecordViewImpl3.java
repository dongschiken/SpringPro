package org.doit.ik.di3;

import java.util.Scanner;

import javax.inject.Inject;
import javax.inject.Named;

import lombok.Data;

@Data
public class RecordViewImpl3 implements RecordView3 {

	//@Autowired //(required = false) 만약 Bean객체가 없으면 주입하지마라 ( 이건 꼭 필요하지 않은 객체에서 사용 )
	@Inject
	@Named(value = "record1") 
	private RecordImpl3 record = null;
	
	public RecordViewImpl3() {}
	
	// 1. 생성자를 통해서 외부에서 주입받는다.
	public RecordViewImpl3(RecordImpl3 record) {
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
