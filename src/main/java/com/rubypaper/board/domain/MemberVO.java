package com.rubypaper.board.domain;

import lombok.Data;

@Data
public class MemberVO {
	
	private String id;
	private String password;
	private String name;
	private Role role;        //Role형은 Role Enum 파일을 만들어서 사용
	private String enabled;

}
