package org.doit.ik.controller;

import org.doit.ik.domain.MemberVO;
import org.doit.ik.persistence.MemberDao;
import org.doit.ik.persistence.NoticeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequestMapping("/joinus/*")
@AllArgsConstructor
@Component
@Controller
@Log4j
public class JoinController {

	@Autowired
	private NoticeDao noticeDao;
	// <a class="btn-edit button" href="noticeEdit.htm?seq=${ notice.seq }">수정</a>
	
	@Autowired
	private MemberDao memberDao;
	
	
	// /joinus/login.htm -> /joinus/login.jsp 응답
	@GetMapping("/login.htm")
	public String login() throws Exception {
		
		return "login.jsp";
	}
	// /joinus/join.htm  -> /joinus/join.jsp  응답
	@GetMapping("/join.htm")
	public String join() throws Exception {
		
		return "join.jsp";
	}
	
	@PostMapping("/join.htm")
	public String join(MemberVO member) throws Exception {
		this.memberDao.insert(member);
		return "redirect:../index.htm";
	}
}
