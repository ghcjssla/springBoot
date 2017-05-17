package com.example;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.app.Calculator;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		//SpringApplication.run으로 스프링 부트 애플리케이션을 실행
		//첫번째 인자는 @EnableAutoConfiguration이 붙인 클래스를 지정
		try(ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args)){;
		

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter 2 numbers like 'a b' : ");
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            Calculator calculator = context.getBean(Calculator.class);
            int result = calculator.calc(a, b);

            System.out.println("result = " + result);
		}
	}
}
