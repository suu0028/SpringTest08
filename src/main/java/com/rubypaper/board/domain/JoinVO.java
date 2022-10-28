package com.rubypaper.board.domain;

import java.util.Date;

import lombok.Data;

@Data
public class JoinVO {
	
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date createDate;
	private int cnt;

	private String id;
	private String password;
	private String name;
	private Role role;        //Role형은 Role Enum 파일을 만들어서 사용
	private String enabled;
	
	private String searchCondition;
	private String searchKeyword;
}
