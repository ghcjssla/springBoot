package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.app.AddCalculator;
import com.example.app.ArgumentResolver;
import com.example.app.Calculator;
import com.example.app.ScannerArgumentResolver;

//이 클래스가 JavaConfig용 클래스임을 컴파일러에게 알림
@Configuration
public class AppConfig {
	//DI 컨테이너가 관리할 Bean을 생성하는 메서드
	//기본값으로 메서드 이름이 Bean이름이 됨
	//싱글톤으로 DI컨테이너 별로 한개가 생성됨
    @Bean
    Calculator calculator() {
        return new AddCalculator();
    }
    
    @Bean
    ArgumentResolver argumentResolver(){
    	return new ScannerArgumentResolver();
    }
}
