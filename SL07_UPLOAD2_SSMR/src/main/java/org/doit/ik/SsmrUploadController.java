package org.doit.ik;

import java.io.File;

import org.doit.ik.domain.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */
@Controller
@Log4j
@RequestMapping("/ssmr/*")
public class SsmrUploadController {
	
	// context path
	//    webapp     + /ssmr/upload
	
	@GetMapping("/upload")
	public void upload() {
		log.info("> SsmrUploadController upload()...GET");
		
			// prefix					 // sufix
		// /WEB-INF/views/+"/ssmr/upload"+.jsp
	}
	
//	@PostMapping("/upload")
//	public void upload(@RequestParam("output") String output, @RequestParam("attach") MultipartFile attach) {
//		log.info("> CmrUploadController upload()...POST");
//		
//			// prefix					 // sufix
//		// /WEB-INF/views/+"/cmr/upload"+.jsp
//		log.info("-".repeat(30));
//		log.info("1. output :" + output);
//		
//		String uploadFolder = "C:\\upload";
//		
//		if(!attach.isEmpty()) {
//			log.info("-".repeat(30));
//			log.info("2. originalFileName : " + attach.getOriginalFilename());
//			log.info("3. size : "+ attach.getSize());
//		}
//		
//		File saveFile = new File(uploadFolder, attach.getOriginalFilename());
//		try {
//			attach.transferTo(saveFile);
//		} catch (Exception e) {
//			log.error(e.getMessage());
//		}
//	}
	
	// 2번
	@PostMapping("/upload")
	public void upload(Message message) {
		log.info("> SsmrUploadController upload()...POST");
		
			// prefix					 // sufix
		// /WEB-INF/views/+"/cmr/upload"+.jsp
		log.info("-".repeat(30));
		log.info("1. output :" + message.getOutput());
		
		String uploadFolder = "C:\\upload";
		MultipartFile attach = message.getAttach();
		if(!attach.isEmpty()) {
			log.info("-".repeat(30));
			log.info("2. originalFileName : " + attach.getOriginalFilename());
			log.info("3. size : "+ attach.getSize());
		}
		
		
		File saveFile = new File(uploadFolder, attach.getOriginalFilename());
		try {
			attach.transferTo(saveFile);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
} // class
