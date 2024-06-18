package org.doit.ik.controller;

import java.util.List;
import java.util.Map;

import org.doit.ik.domain.BookDTO;
import org.doit.ik.mapper.BookMapper;
import org.doit.ik.persistence.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/book/*")
public class BookController {


	private BookMapper bookMapper;
	
	private BookRepository bookRepository;
	
	@Autowired
	public BookController(BookMapper bookMapper, BookRepository bookRepository) {
		this.bookMapper = bookMapper;
		this.bookRepository = bookRepository;
	}
	
	// 목록보기 2
	   @GetMapping(value="/list")
	   public void list(Model model, String word) {

	      if (word == null || word.equals("")) {
	         List<BookDTO> list = this.bookMapper.list();
	         model.addAttribute("list", list);
	      } else {
	         // ES
	         List<Map<String,Object>> list = this.bookRepository.search(word);
	         model.addAttribute("list", list);
	         model.addAttribute("word", word);
	      }
	 
	   }

	//추가하기(폼)
	@GetMapping(value="/add")
	public void add() {

	}

	//추가하기(처리)
	@PostMapping(value="/add")
	public String add(Model model, BookDTO dto) {
		
		// Oracle 추가
		this.bookMapper.add(dto);
		
		// Es 추가
		this.bookRepository.add(dto);
		
		return "redirect:/book/list";
	}

	//상세보기
	@GetMapping(value="/view")
	public void view(Model model, String seq) {

		BookDTO dto = this.bookMapper.get(seq);      
		model.addAttribute("dto", dto);

	} 

}
