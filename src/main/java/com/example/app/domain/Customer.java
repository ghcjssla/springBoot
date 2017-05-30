package com.example.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*@Data
//모든 필드를 인자로 받는 생성자를 만든다.
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	private Integer id;
	private String firstName;
	private String lastName;
}*/
//JPA에 맞게 수정

@Entity //JPA 엔티티임을 표시
@Table(name = "customers") //엔티티에 대응하는 테이블 이름을 지정
@Data
//JPA명세에 따르면 엔티티 클래스에는 인자를 받지 않는 기본생성자를 만들어야 함
//롬복으로 기본생성자를 만들려면 @NoArgsConstructor 어너테이션을 사용
@NoArgsConstructor 
//롬복이 기본생성자 외에 전체 필드를 인자로 받는 생성자를 만들도록 설정 
@AllArgsConstructor
public class Customer {
	@Id //엔티티의 기본키인 필드
	@GeneratedValue //디비가 기본 키 번호를 자동으로 매기도록 설정
	private Integer id;
	
	@Column(nullable = false) //제약조건 설정
	private String firstName;
	
	@Column(nullable = false)
	private String lastName;
}