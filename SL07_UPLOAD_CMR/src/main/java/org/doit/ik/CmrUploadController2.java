package org.doit.ik;

import java.io.File;
import java.util.List;

import org.doit.ik.domain.Message2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */
@Controller
@Log4j
@RequestMapping("/cmr/*")
public class CmrUploadController2 {
	
	// context path
	//    webapp     + /cmr/upload
	
	@GetMapping("/upload2")
	public void upload() {
		log.info("> CmrUploadController upload()...GET");
		
			// prefix					 // sufix
		// /WEB-INF/views/+"/cmr/upload"+.jsp
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
//		
//		File saveFile = new File(uploadFolder, attach.getOriginalFilename());
//		try {
//			attach.transferTo(saveFile);
//		} catch (Exception e) {
//			log.error(e.getMessage());
//		}
//	}
	
	// 2번
//	@PostMapping("/upload")
//	public void upload(Message message) {
//		log.info("> CmrUploadController upload()...POST");
//		
//			// prefix					 // sufix
//		// /WEB-INF/views/+"/cmr/upload"+.jsp
//		log.info("-".repeat(30));
//		log.info("1. output :" + message.getOutput());
//		
//		String uploadFolder = "C:\\upload";
//		MultipartFile attach = message.getAttach();
//		if(!attach.isEmpty()) {
//			log.info("-".repeat(30));
//			log.info("2. originalFileName : " + attach.getOriginalFilename());
//			log.info("3. size : "+ attach.getSize());
//		}
//		
//		
//		File saveFile = new File(uploadFolder, attach.getOriginalFilename());
//		try {
//			attach.transferTo(saveFile);
//		} catch (Exception e) {
//			log.error(e.getMessage());
//		}
//	}
	
//	@PostMapping("/upload2")
//	public void upload(@RequestParam("output") String output, @RequestParam("attach") List<MultipartFile> attachList) {
//		log.info("> CmrUploadController upload()...POST");
//		
//			// prefix					 // sufix
//		// /WEB-INF/views/+"/cmr/upload"+.jsp
//		log.info("-".repeat(30));
//		log.info("1. output :" + output);
//		
//		String uploadFolder = "C:\\upload";
//		
//		for (MultipartFile attach : attachList) {
//			if(!attach.isEmpty()) {
//				log.info("-".repeat(30));
//				log.info("2. originalFileName : " + attach.getOriginalFilename());
//				log.info("3. size : "+ attach.getSize());
//			}
//			
//			
//			File saveFile = new File(uploadFolder, attach.getOriginalFilename());
//			try {
//				attach.transferTo(saveFile);
//			} catch (Exception e) {
//				log.error(e.getMessage());
//			}
//		}
//	}
	
	
	@PostMapping("/upload2")
	public void upload(Message2 message2) {
		log.info("> CmrUploadController upload()...POST");
		
			// prefix					 // sufix
		// /WEB-INF/views/+"/cmr/upload"+.jsp
		log.info("-".repeat(30));
		log.info("1. output :" + message2.getOutput());
		
		String uploadFolder = "C:\\upload";
		List<CommonsMultipartFile> attachList = message2.getAttachList();
		
		for (CommonsMultipartFile attach : attachList) {
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
		
	}
} // class
