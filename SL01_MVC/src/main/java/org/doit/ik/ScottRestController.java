package org.doit.ik;

import org.doit.ik.domain.DeptDTO;
import org.doit.ik.mapper.scott.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

// ajax 처리 컨트롤러
@RestController
@Log4j
@RequestMapping("/scott/dept/*")
public class ScottRestController {
	
	@Autowired
	private DeptMapper deptMapper;
	
	 //@RequestMapping(value = "/scott/dept", method = RequestMethod.POST)
	@PostMapping("/new")
	public ResponseEntity<String> insertDept(@RequestBody DeptDTO dto){
		log.info("> scottRestController insertDept()...");
		int insertResult = this.deptMapper.insertDept(dto);
										
		return insertResult == 1 ? 		// 성공했을 경우 SUCCESS								// 실패했을 경우 500번 ( 상태값 ) 리턴
				new ResponseEntity<>("SUCCESS", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR) ;
		
	}
	
	@DeleteMapping(value = "/{deptno}")				// deptno라는 변수를 받아서 int deptno에 담는다.
	public ResponseEntity<String> deleteDept(@PathVariable("deptno") int deptno){
		log.info("> scottRestController deleteDept()...");
		int deleteResult = this.deptMapper.deleteDept(deptno);
										
		return deleteResult == 1 ? 		// 성공했을 경우 SUCCESS								// 실패했을 경우 500번 ( 상태값 ) 리턴
				new ResponseEntity<>("SUCCESS", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR) ;
		
	}
	
}
