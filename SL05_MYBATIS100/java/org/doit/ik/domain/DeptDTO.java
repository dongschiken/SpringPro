package org.doit.ik.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeptDTO {
	
	private int deptno;
	private String dname;
	private String loc;

}
