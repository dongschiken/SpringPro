package org.doit.ik;

import java.io.File;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */
@RestController
@Log4j
@RequestMapping("/ajax/*")
public class AjaxUploadController {
	
	@GetMapping("/upload")
	public void upload() {
		log.info("> AjaxUploadController upload()...GET");
		
			// prefix					 // sufix
		// /WEB-INF/views/+"/ajax/upload"+.jsp
	}
	
	@PostMapping("/uploadAjax")
	public void uploadAjax(@RequestParam("attatchList") List<MultipartFile> attachList) {
		log.info("> AjaxUploadController uploadAjax()...POST");
		
		String uploadFolder = "C:\\upload";
		
		for (MultipartFile attach : attachList) {
			if(!attach.isEmpty()) {
				log.info("-".repeat(30));
				log.info(">. originalFileName : " + attach.getOriginalFilename());
				log.info(">. size : "+ attach.getSize());
			}
			File saveFile = new File(uploadFolder, attach.getOriginalFilename());
			try {
				attach.transferTo(saveFile);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}
	}
} // class
