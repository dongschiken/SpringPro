package org.doit.ik;

import java.util.List;

import org.doit.ik.domain.EmpDTO;
import org.doit.ik.domain.Ticket;
import org.doit.ik.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/scott/*")
@RestController
public class RESTController {
	
	
	@Autowired
	private EmpMapper empMapper;
	
	@GetMapping("/getText")
	public String getText() {
		log.info(">>> MIME TYPE : " + MediaType.TEXT_PLAIN_VALUE);
		
		return "헬로우 월드!";
	}
	
	@GetMapping(value = "/getText2", produces = "text/plan; charset=UTF-8")
	public String getText2() {
		log.info(">>> MIME TYPE : " + MediaType.TEXT_PLAIN_VALUE);
		
		return "헬로우 월드!";
	}
	
	// XML 데이터로 알아서 변환해준다.
	@GetMapping(value = "/employees")
	public List<EmpDTO> selectAll() {
		
		return this.empMapper.selectAll();
	}
	
	// JSON형태의 UTF-8로 변환해서 리턴해준다.
	@GetMapping(value = "/employees2", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public List<EmpDTO> selectAll2() {
		
		return this.empMapper.selectAll();
	}
	
	// JSON + XML ( 기본이 XML -> .json 붙이면 json으로 변환)
	@GetMapping(value = "/employees3", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE , MediaType.APPLICATION_XML_VALUE})
	public List<EmpDTO> selectAll3() {
		
		return this.empMapper.selectAll();
	}
	
	@GetMapping(value = "/employee/{empno}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE , MediaType.APPLICATION_XML_VALUE})
	public EmpDTO selectByEmpno(@PathVariable("empno") int empno) {
		
		return this.empMapper.selectByEmpno(empno);
	}
	
	@PostMapping(value = "/ticket", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	   public Ticket convert(@RequestBody Ticket ticket) {      
	      ticket.setOwner( ticket.getOwner() + "님" );
	      log.info(">> "+ ticket);
	      return ticket;
	}
	
	@PostMapping(value = "/idCheck", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	   public int idCheck(String empno) {      
		  return this.empMapper.idCheck(empno);  
	      	
	}
	
}
