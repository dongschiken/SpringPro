package org.doit.ik.domain;

import org.springframework.security.access.annotation.Secured;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class DeptDTO {
	
	private int deptno;
	private String dname;
	private String loc;
	
	private int numberOfEmps; // 해당 부서의 사원수
	

}
