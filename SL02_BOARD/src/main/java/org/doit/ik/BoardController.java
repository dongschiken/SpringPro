package org.doit.ik;

import org.doit.ik.domain.BoardVO;
import org.doit.ik.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	@GetMapping("/list")
	public void list(Model model) {
		log.info("BoardController list()...");
		model.addAttribute("list", this.boardService.getList());
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
	
	@GetMapping(value = {"/get", "/modify"})
	public void get(@RequestParam("bno") long bno,  Model model ) {
		log.info("BoardController get() GET...");
		BoardVO boardVO = this.boardService.get(bno);
		model.addAttribute("boardVO", boardVO);
	}
	
	@PostMapping("/modify")
	public String update(BoardVO boardVO, RedirectAttributes rttr){
		log.info("BoardController modify() POST...");	
		if(this.boardService.modify(boardVO)) {
			rttr.addFlashAttribute("result", "success");
		}
		//return "redirect:/board/list";
		return String.format("redirect:/board/get?bno=%d", boardVO.getBno());
	}
	
	@GetMapping(value = {"/remove"})
	public String remove(@RequestParam("bno") long bno, RedirectAttributes rttr) {
		log.info("BoardController get() GET...");
		if(this.boardService.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
	
	
}
