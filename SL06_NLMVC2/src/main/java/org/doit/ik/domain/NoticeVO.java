package org.doit.ik.domain;

import java.util.Date;

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
}
