package org.doit.ik.domain;

import java.util.Date;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoticeVO {
	private String seq;
	private String title;
	private String writer;
	private Date regdate;
	private String filesrc;	// 수정
	
	private int hit;		// 조회수
	private String content;	// 내용
	
	// 445P 참조 커맨드 객체를 사용해서 파일 업로드
	// <input type="file" id="txtFile" name="file" />
	private CommonsMultipartFile file;
	
}
