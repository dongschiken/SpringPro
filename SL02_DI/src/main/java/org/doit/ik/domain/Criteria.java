package org.doit.ik.domain;

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
	
	private String type;	// 검색조건
	private String keyword; // 검색어
	
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
				.queryParam("amount", this.amount)
				.queryParam("keyword", this.keyword)
				.queryParam("type", this.type);
		return builder.toUriString();
	}
	// rjator whrjs "TWC" => new String[] { "T", "W", "C" }
	public String[] getTypeArr() {
		return this.type == null ? new String[] {} : this.type.split(""); // 아무 것도 안주면 문자열 한개씩 잘린다.
	}
}
