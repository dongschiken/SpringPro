package org.doit.ik.controller;

import java.sql.SQLException;
import java.util.List;

import org.doit.ik.domain.NoticeVO;
import org.doit.ik.persistence.NoticeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequestMapping("/customer/*")
@AllArgsConstructor
@Component
@Controller
@Log4j
public class NoticeBoardController {

	@Autowired
	private NoticeDao noticeDao;
	
	@GetMapping("/noticeDel.htm")
	public String noticeDel(@RequestParam("seq") String seq) {
		try {
			int rowCount = this.noticeDao.delete(seq);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:notice.htm";
	}
	
	@PostMapping("/noticeEdit.htm")
	public String noticeEdit(NoticeVO notice, Model model)throws Exception {
		int rowCount = this.noticeDao.update(notice);
		if( rowCount == 1) {
			System.out.println("글쓰기 성공!");
			return "redirect:noticeDetail.htm?seq="+notice.getSeq();
			// 스프링 [ 리다이렉트 ] redirect: <- 접두사 사용
		}else {
			System.out.println("글쓰기 실패!");
			return "redirect:notice.htm";
		}
	}
	
	@GetMapping("/noticeEdit.htm")
	public String noticeEdit(@RequestParam("seq") String seq, Model model)throws Exception {
		NoticeVO noticeVO = this.noticeDao.getNotice(seq);
		model.addAttribute("notice", noticeVO);
		return "noticeEdit.jsp";
	}
	
	// 글쓰기 작업
	@GetMapping("/noticeReg.htm")
	public String noticeReg() throws Exception{
		return "noticeReg.jsp";
	}


	@PostMapping("/noticeReg.htm")
	public String noticeReg( NoticeVO notice) throws Exception{
		int rowCount = this.noticeDao.insert(notice);
		if( rowCount == 1) {
			System.out.println("글쓰기 성공!");
			return "redirect:notice.htm";
			// 스프링 [ 리다이렉트 ] redirect: <- 접두사 사용
		}else {
			System.out.println("글쓰기 실패!");
			return "noticeReg.jsp?error";
		}
	}

	// 2번
	@GetMapping("/notice.htm")
	public String noticeList(Model model, @RequestParam(value = "page", defaultValue = "1") int page, 
			@RequestParam(value = "field", defaultValue = "title") String field,
			@RequestParam(value = "query", defaultValue = "") String query) throws Exception {

		List<NoticeVO> list = this.noticeDao.getNotices(page, field, query);

		model.addAttribute("list" , list);
		model.addAttribute("messag", "hello world!");
		return "notice.jsp";
	}

	@GetMapping("/noticeDetail")
	public String noticeDetail(@RequestParam("seq") String pseq, Model model) throws Exception {
		String seq = pseq;
		NoticeVO notice = this.noticeDao.getNotice(seq);

		model.addAttribute("notice", notice);

		return"noticeDetail.jsp";
	}

	//	@GetMapping("/noticeDetail")
	//	public ModelAndView noticeDetail(@RequestParam("seq") String pseq) throws Exception {
	//		// ModelAndView 타입 spring p284참조
	//		// 1. Model
	//		// 2. View
	//		String viewName = "noticeDetail.jsp";
	//
	//		String seq = pseq;
	//		NoticeVO notice = this.noticeDao.getNotice(seq);
	//
	//		ModelAndView mav = new ModelAndView(viewName);
	//
	//		mav.addObject("notice", notice);
	//		mav.addObject("message", "hello world!");
	//		return mav;
	//	}

	// 1번
	/*
	 * @GetMapping("/notice.htm") public ModelAndView
	 * handleRequest(HttpServletRequest request, HttpServletResponse response)
	 * throws Exception {
	 * 
	 * request.setCharacterEncoding("UTF-8");
	 * response.setCharacterEncoding("UTF-8"); // ModelAndView 타입 spring p284참조 //
	 * 1. Model // 2. View String ppage = request.getParameter("page"); String
	 * pfield = request.getParameter("field"); String pquery =
	 * request.getParameter("query");
	 * 
	 * int page = 1; String field = "title"; String query = "";
	 * 
	 * if( ppage != null && !ppage.equals("")) { page = Integer.parseInt(ppage); }
	 * if( pfield != null && !pfield.equals("")) { field = pfield; } if( pquery !=
	 * null && !pquery.equals("")) { query = pquery; }
	 * 
	 * List<NoticeVO> list = this.noticeDao.getNotices(page, field, query);
	 * 
	 * ModelAndView mav = new ModelAndView();
	 * 
	 * mav.addObject("list", list); mav.addObject("message", "hello world!");
	 * mav.setViewName("notice.jsp"); return mav; }
	 */

	// 글쓰기 저장버튼을 누를때
	//	@PostMapping("/noticeReg.htm")
	//	public String noticeReg(@RequestParam("title") String title,
	//			@RequestParam("content") String content, Model model) throws Exception{
	//		
	//		return "noticeReg.jsp";
	//	}
}
