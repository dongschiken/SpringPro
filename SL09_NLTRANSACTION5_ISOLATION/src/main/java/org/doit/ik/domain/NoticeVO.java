package org.doit.ik.domain;

import java.util.Date;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoticeVO {
	private String seq;
	private String title;
	private String writer;
	private Date regdate;
	private String filesrc; // 수정
	private int hit;
	private String content;
	
	// p.445 참고
	// 스프링에서 지원하는 파일 업로드 기능을 (4)방법인
	// 커맨드 객체를 이용하는 방법
	// <input type="file" id="txtFile" name="file">
	private CommonsMultipartFile file;
}
