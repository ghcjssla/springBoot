package com.example;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//이 클래스가 웹 애플리케이션에서 요청을 받아들이는 컨트롤러 클래스임을 나타냄
@RestController
//스프링 애플리케이션에 필요했던 다양한 설정등이 자동으로 수행
@EnableAutoConfiguration
//JavaConfig를 읽어들이기 위해 @Import로 @Configuration 애너테이션이 붙은 클래스를 지정
@Import(AppConfig.class)
public class App {
	@RequestMapping("/")
	String home(){
		return "Hello world";
	}
}