package org.doit.ik.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.doit.ik.domain.NoticeVO;
import org.doit.ik.persistence.NoticeDao;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

// /customer/noticeDetail.htm?seq=2
// 공지사항 보기 컨트롤러
public class NoticeDetailController implements Controller{

	
	private NoticeDao noticeDao;
	
	public NoticeDetailController() {}
	
	public NoticeDetailController(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}

	// setter DI
	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}

	// /customer/notice.htm?page=2&field=??
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// ModelAndView 타입 spring p284참조
		// 1. Model
		// 2. View
		String viewName = "noticeDetail.jsp";
		String pseq = request.getParameter("seq");
		
		String seq = pseq;
		NoticeVO notice = this.noticeDao.getNotice(seq);
		
		ModelAndView mav = new ModelAndView(viewName);
		
		mav.addObject("notice", notice);
		mav.addObject("message", "hello world!");
		return mav;
	}
}
