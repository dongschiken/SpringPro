package org.doit.ik.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class BoardVO {

	private long bno; // 저장
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updatedate;

}
