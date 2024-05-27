package org.doit.ik.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DeptEmpSalgradeDTO {
	
	private int deptno;
	private String dname;
	private int empno;
	private String ename;
	private String job;
	private Date hiredate;
	private double sal;
	private int grade;

}
