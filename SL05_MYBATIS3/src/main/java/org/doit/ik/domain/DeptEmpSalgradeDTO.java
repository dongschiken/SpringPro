package org.doit.ik.domain;

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
	
	// 1:1 관계
	private DeptDTO deptDTO;
	
	// 1:N 관계
	private EmpDTO empDTO;
//	private SalgradeDTO salgradeDTO;
	

}
