package org.doit.ik.di3;

import java.util.Scanner;

import javax.inject.Inject;

import lombok.Data;

@Data
public class RecordViewImpl3 implements RecordView3 {

	//@Autowired //(required = false) 만약 Bean객체가 없으면 주입하지마라 ( 이건 꼭 필요하지 않은 객체에서 사용 )
	@Inject // record / record2
	private RecordImpl3 record2 = null;
	
	public RecordViewImpl3() {}
	
	// 1. 생성자를 통해서 외부에서 주입받는다.
//	public record2ViewImpl3(record2Impl3 record2) {
//		this.record2 = record2;
//	}
	


	@Override
	public void input() {
		try (Scanner sc = new Scanner(System.in)){
			System.out.println("record2 input kor eng mat.....");
			//this.record2 = new record2Impl();
			int kor = sc.nextInt();
			int eng = sc.nextInt();
			int mat = sc.nextInt();
			
			this.record2.setKor(kor);
			this.record2.setEng(eng);
			this.record2.setMat(mat);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void output() {
		System.out.printf("> kor=%d, eng=%d, mat=%d, tot=%d, avg=%.2f\n"
				, this.record2.getKor()
				, this.record2.getEng()
				, this.record2.getMat()
				, this.record2.total()
				, this.record2.avg() 
				);
	}

}
