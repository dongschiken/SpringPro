package org.doit.ik.domain;

import java.util.List;

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
	private String loc;
	
	private List<EmpDTO> empList;

}
