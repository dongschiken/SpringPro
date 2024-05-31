package org.doit.ik.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.doit.ik.domain.NoticeVO;
import org.doit.ik.mapper.NoticeMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/customer/*")
@Log4j
@AllArgsConstructor
public class CustomerController {

	private NoticeMapper noticeDao;

	//<a class="btn-del button" href="noticeDel.htm?seq=${notice.seq }&filesrc=${notice.filesrc}">삭제</a>
	@GetMapping("/noticeDel.htm")	
	public String noticeDel(
			@RequestParam("seq") String seq
			, @RequestParam("filesrc") String filesrc
			, HttpServletRequest request
			) throws Exception{

		// 1. 첨부파일이 있는 공지사항일 경우 첨부파일도 삭제
		String uploadRealPath = request.getServletContext().getRealPath("/customer/upload");
		File delFile = new File(uploadRealPath, filesrc);
		
		if (delFile.exists()) {
			delFile.delete();
		}

		// 2. 공지사항 글도 삭제
		int rowCount = this.noticeDao.delete(seq);
		
		if (rowCount == 1) {
			return "redirect:notice.htm";
		} else {
			return "noticeDetail.jsp?error";
		}
	}

	//<button class="btn-save-button" type="submit">수정</button>
	//<input type="text" name="o_filesrc" value="${notice.filesrc }"/>
	@PostMapping("/noticeEdit.htm")
	public String noticeEdit(NoticeVO notice, @RequestParam("o_filesrc") String o_filesrc, HttpServletRequest request) throws Exception{

		// 1. 원래 첨부파일이 있는 경우 새로운 첨부파일 선택되면
		//    이전 첨부파일은 삭제 코딩 추가
		CommonsMultipartFile multipartFile = notice.getFile();
		String uploadRealPath = null;
		System.out.println(multipartFile);
		if(!multipartFile.isEmpty()) {
			uploadRealPath = request.getServletContext().getRealPath("/customer/upload");
			System.out.println("> uploadRealPath : " + uploadRealPath);
			
			// 이전 첨부파일이 있다면 이전 첨부파일 삭제 코딩 추가
			File o_File = new File(uploadRealPath, o_filesrc);
			if (o_File.exists()) {
				o_File.delete();
			}

			// 1-2. 새로 전
			String originalFilename = multipartFile.getOriginalFilename();
			String filesystemName = getFileNameCheck(uploadRealPath, originalFilename);

			File dest = new File(uploadRealPath, filesystemName);
			multipartFile.transferTo(dest);    // 실제 파일 저장
			notice.setFilesrc(filesystemName);
		} else {
			notice.setFilesrc(o_filesrc);
		}
		// 2.
		int rowCount = this.noticeDao.update(notice);
		
		if (rowCount == 1) { // 글 수정 성공
			return "redirect:noticeDetail.htm?seq=" + notice.getSeq(); // 리다이렉트 ("redirect: " 접두사 사용)
		} else { // 글 수정 실패
			return "noticeEdit.jsp?error";
		}
	}

	//<a class="btn-edit button" href="noticeEdit.htm?seq=${notice.seq }">수정</a>
	@GetMapping("/noticeEdit.htm")
	public String noticeEdit(
			@RequestParam("seq") String seq
			, Model model
			) throws Exception{
		NoticeVO notice = this.noticeDao.getNotice(seq);
		model.addAttribute("notice", notice);
		return "customer.noticeEdit";
	}

	// 2번 NoticeVo notice 커맨드 객체(command object)
	//<input class="btn-save button" type="submit" value="저장" />
	private String getFileNameCheck(String uploadRealPath, String originalFilename) {
		int index = 1;      
		while( true ) {         
			File f = new File(uploadRealPath, originalFilename);         
			if( !f.exists() ) return originalFilename;         
			// upload 폴더에 originalFilename 파일이 존재한다는 의미         a-2  .txt (4자리)
			String fileName = originalFilename.substring(0, originalFilename.length() - 4 );  //   a
			String ext =  originalFilename.substring(originalFilename.length() - 4 );  // .txt
			// asdfasf-3.txt
			originalFilename = fileName+"-"+(index)+ext;

			index++;
		} // while 
	}

	@PostMapping(value = "/noticeReg.htm")
	public String noticeReg(NoticeVO notice
			, HttpServletRequest request) throws Exception{

		CommonsMultipartFile multipartFile = notice.getFile();
		String uploadRealPath = null;
		System.out.println(multipartFile);
		if(!multipartFile.isEmpty()) {
			uploadRealPath = request.getServletContext().getRealPath("/customer/upload");
			System.out.println("> uploadRealPath : " + uploadRealPath);

			String originalFilename = multipartFile.getOriginalFilename();
			String filesystemName = getFileNameCheck(uploadRealPath, originalFilename);

			File dest = new File(uploadRealPath, filesystemName);
			multipartFile.transferTo(dest);    // 실제 파일 저장
			notice.setFilesrc(filesystemName);
		}

		notice.setWriter("daetu01");

		//int rowCount = this.noticeDao.insert(notice);
		this.noticeDao.insertAndPointUpOfMember(notice, "daetu01");
		int rowCount = 1;
		if(rowCount == 1) { // 글쓰기 성공
			return "redirect:notice.htm"; // 스프링[리다이렉트] / 포워딩
		} else { // 글쓰기 실패
			return "noticeReg.jsp?error";
		}
	}

	/* 1번
	//<input class="btn-save button" type="submit" value="저장" />
	@PostMapping("/noticeReg.htm")
	public String noticeReg(
			@RequestParam("title") String title
			, @RequestParam("content") String content
			) throws Exception{

		return "notice.jsp";
	}
	 */

	//<a class="btn-write button" href="noticeReg.htm">글쓰기</a>
	@GetMapping("/noticeReg.htm")
	public String noticeReg(HttpSession session) throws Exception{

		return "customer.noticeReg";
	}

	//NoticeDetailController.java => 컨트롤러 메서드로 구현
	@GetMapping("/noticeDetail.htm")
	public String noticeDetail(
			@RequestParam("seq") String seq
			, Model model
			) throws Exception {

		NoticeVO notice = this.noticeDao.getNotice(seq);

		model.addAttribute("notice", notice);

		return "customer.noticeDetail";
	}

	
	//NoticeController.java => 컨트롤러 메서드로 구현
	@GetMapping("/notice.htm")
	public String notices(
			Model model
			, @RequestParam(value = "page", defaultValue = "1") int page
			, @RequestParam(value = "field", defaultValue = "title") String field
			, @RequestParam(value = "query", defaultValue = "") String query
			) throws Exception {

		ModelAndView mav = new ModelAndView();

		List<NoticeVO> list = this.noticeDao.getNotices(page, field, query);

		model.addAttribute("list", list);
		model.addAttribute("message", "Hello World !");
		return "customer.notice";
	}
	/* 1번
	@GetMapping("/notice.htm")
	public ModelAndView notices(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ModelAndView mav = new ModelAndView();

		String ppage = request.getParameter("page");
		String pfield = request.getParameter("field");
		String pquery = request.getParameter("query");

		int page = 1;
		String field = "title";
		String query = "";

		if (ppage != null && ppage.equals("")) page = Integer.parseInt(ppage);
		if (pfield != null && pfield.equals("")) field = pfield;
		if (pquery != null && pquery.equals("")) query = pquery;

		List<NoticeVO> list = this.noticeDao.getNotices(page, field, query);

		mav.addObject("list", list);
		mav.addObject("message", "Hello World !");
		mav.setViewName("notice.jsp");
		return mav;
	}
	 */
}
