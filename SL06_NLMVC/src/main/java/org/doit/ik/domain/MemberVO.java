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
public class MemberVO {
	private String id;			    // uid => id 수정
	private String pwd;
	private String name;
	private String gender;
	private String birth;
	private String is_lunar;		// 수정
	private String cphone;			// 수정
	private String email;
	private String habit;
	private Date   regdate;			// 수정

}
