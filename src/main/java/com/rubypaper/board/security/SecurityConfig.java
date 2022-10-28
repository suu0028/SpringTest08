package com.rubypaper.board.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	SecurityConfig(){
		System.out.println("===> SecurityConfig 생성자");
	}
	
	@Autowired
	private BoardUserDetailsService baordUserDetails;
	
	@Override
	protected void configure(HttpSecurity security) throws Exception {
		System.out.println("===> void configure 실행");
		
		security.authorizeRequests().antMatchers("/", "/system/**").permitAll();
		security.authorizeRequests().antMatchers("/board/**").authenticated();    //로그인 인증을 받으면 글쓰기 가능
		security.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");   //관리자 권한
		
		security.csrf().disable();
		security.formLogin().loginPage("/system/login.do").defaultSuccessUrl("/board/getBoardList.do", true);  //(1)번
		security.exceptionHandling().accessDeniedPage("/system/accessDenied.do");
		security.logout().logoutUrl("/system/logout.do").invalidateHttpSession(true).logoutSuccessUrl("/");    //로그아웃 기능
		security.userDetailsService(baordUserDetails); //(2)번
		
		//(1)번은 username, password를 받아온다.
		//(2)번은 테이블의 값을 받아온다.
		//(1)번과 (2)번이 매핑되어 인증을 체크한다. 인증에 성공하면 /loginSuccess로 넘어감
		
	}
	

	@Bean
	public  PasswordEncoder passwordEncoder() {    //비밀번호 암호화
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

}


