package org.doit.ik.mapper;

import java.util.List;

import org.doit.ik.domain.DeptEmpSalgradeDTO;
import org.doit.ik.domain.EmpDTO;

public interface DeptEmpSalgradeMapper {
	
	// 부서정보만 select
	List<DeptEmpSalgradeDTO> getDeptEmpInfo();
	
	// 해당 부서의 사원정보를 select 함수
	List<EmpDTO> getEmpOfDept(int deptno);
	
}
