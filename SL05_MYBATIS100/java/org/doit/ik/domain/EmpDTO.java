package org.doit.ik.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmpDTO {
	
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	@DateTimeFormat(pattern = "yyyy/MM/dd") // 이런식으로 애노테이션을 사용해서 날짜 포맷 설정가능
	private Date hiredate;
	private double sal;
	private double comm;
	private int deptno;
	
	// emp - salgrad 1 : 1 관계
	private SalgradeDTO salgradeDTO;
	
}
