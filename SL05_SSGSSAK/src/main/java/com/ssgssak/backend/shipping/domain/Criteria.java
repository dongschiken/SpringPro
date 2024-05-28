package com.ssgssak.backend.shipping.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// 페이징 기준, 검색 기준
@Getter
@Setter
@ToString
public class Criteria {

	private int pageNum; // 현재 페이지 번호 받는 변수
	private int amount; // 한페이지에 출력할 게시글 갯수
	
	public Criteria(int pageNum, int amout) {
		super();
		this.pageNum = pageNum;
		this.amount = amout;
	}
	
	public Criteria() {
		this(1, 10);
	}
	
	// pageNum=2&amount=10&type=T&keyword=홍길동
	// 쿼리스트링 만들어주는 기능
	// UriComponenetsBuilder
	public String getListLink() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
				.queryParam("pageNum", this.pageNum)
				.queryParam("amount", this.amount);
		
		return builder.toUriString();
	}
}
