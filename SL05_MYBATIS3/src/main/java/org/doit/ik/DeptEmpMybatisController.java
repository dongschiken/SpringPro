package org.doit.ik;

import org.doit.ik.mapper.DeptEmpSalgradeMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor  // 이거에 의해서 자동으로 주입된다. ( 이건 모르겠다. )
public class DeptEmpMybatisController {
	
	//@Autowired
	private DeptEmpSalgradeMapper deptEmpSalgradeMapper;
	
	
	@GetMapping("/dept/emp")
	public void getDeptEmpSalgrade(Model model) {
		log.info(">>> DeptEmpSalgradeMapper.getDeptEmpSalgrade().... 호출");
		model.addAttribute("list", this.deptEmpSalgradeMapper.getDeptEmpInfo());
		
	}
	
	
}
