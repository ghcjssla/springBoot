package com.example.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//모든 필드를 인자로 받는 생성자를 만든다.
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	private Integer id;
	private String firstName;
	private String lastName;
}
