package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Customer;
import com.example.service.CustomerService;
//스프링 애플리케이션에 필요했던 다양한 설정등이 자동으로 수행
@EnableAutoConfiguration
//이 클래스 패키지 내부에 있는 모든 클래스를 검색 대상 패키지를 변경하려면 basePackages 속성에 패키지를 지정
@ComponentScan
public class App implements CommandLineRunner{
	@Autowired
	CustomerService customerService;
	
	
	@RequestMapping("/")
	String home(){
		return "Hello world";
	}

	@Override
	public void run(String... strings) throws Exception {
		//데이터 추가
		customerService.save(new Customer(1,"AAA", "AAA1"));
		customerService.save(new Customer(2,"BBB", "BBB2"));
		customerService.save(new Customer(3,"CCC", "CCC3"));
		
		//데이터 표시
		customerService.findAll().forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}