package org.doit.ik;

import org.doit.ik.domain.BoardVO;
import org.doit.ik.domain.Criteria;
import org.doit.ik.domain.PageDTO;
import org.doit.ik.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {


	private BoardService boardService;

	// http://localhost/board/list 게시글 목록 요청 URL
	// 페이징 처리 안된 list메서드
//	@GetMapping("/list")
//	public void list(Model model) {
//		log.info("BoardController list()...");
//		model.addAttribute("list", this.boardService.getList());
//	}	
	
	// 페이징 처리 된 list메서드
	// /board/list?pageNum=1&amount=5
	// /board/list?pageNum=3&amount=10
	@GetMapping("/list")
	public void list(Model model, Criteria criteria) {
		log.info("BoardController list()...");
		model.addAttribute("list" , this.boardService.getListWithPaging(criteria));
		int total = this.boardService.getTotal(criteria);
		model.addAttribute("pageMaker", new PageDTO(criteria, total));
	}

	// http://localhost/board/list 게시글 목록 요청 URL
	@GetMapping("/register")
	public void register(Model model) {
		log.info("BoardController register() GET...");
	}

	@PostMapping("/register")					// redirect할때 가져갈 속성값
	public String register( BoardVO boardVO, RedirectAttributes rttr ) {
		log.info("BoardController insert() POST...");
		this.boardService.register(boardVO);
		// redirect할때 한번만 사용할 속성값 
		rttr.addFlashAttribute("result", boardVO.getBno());
		return "redirect:/board/list";
	}

	//	///board/get?bno=2
	//	@GetMapping(value = {"/get/{bno}", "/modify/{bno}"})
	//	//public String get(@RequestParam("bno") long bno,  Model model ) {
	//	public String get(@PathVariable("bno") long bno,  Model model ) {
	//		log.info("BoardController get() GET...");
	//		BoardVO boardVO = this.boardService.get(bno);
	//		model.addAttribute("boardVO", boardVO);
	//		return "/board/get";
	//	}
	/*
	@GetMapping(value = {"/get", "/modify"})
	public void get(@RequestParam("bno") long bno, Criteria criteria,  Model model ) {
		log.info("BoardController get() GET...");
		BoardVO boardVO = this.boardService.get(bno);
		model.addAttribute("boardVO", boardVO);
		model.addAttribute("criteria", criteria);
	}
	*/
	
	@GetMapping(value = {"/get", "/modify"})  // 파라미터로 넘어오는 criteria를 model.addAttribute 하는것
	public void get(@RequestParam("bno") long bno, @ModelAttribute("criteria") Criteria criteria,  Model model ) {
		log.info("BoardController get() GET...");
		BoardVO boardVO = this.boardService.get(bno);
		model.addAttribute("boardVO", boardVO);
		
	}
	
	@PostMapping("/modify")
	public String update(BoardVO boardVO, @ModelAttribute("criteria") Criteria criteria, RedirectAttributes rttr){
		log.info("BoardController modify() POST...");	
		if(this.boardService.modify(boardVO)) {
			rttr.addFlashAttribute("result", "success");
		}
		rttr.addFlashAttribute("pageNum", criteria.getPageNum());
		rttr.addFlashAttribute("amount", criteria.getAmount());
		return "redirect:/board/list"+criteria.getListLink();
		//return String.format("redirect:/board/get?bno=%d", boardVO.getBno());
	}
	
	@GetMapping(value = {"/remove"})
	public String remove(@RequestParam("bno") long bno, @ModelAttribute("criteria") Criteria criteria, RedirectAttributes rttr) {
		log.info("BoardController get() GET...");
		if(this.boardService.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list"+criteria.getListLink();
	}
	
}
