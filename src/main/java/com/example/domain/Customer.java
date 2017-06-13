package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//모든 필드를 인자로 받는 생성자를 만든다.
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {
	@Id
    @GeneratedValue
	private Integer id;
	private String firstName;
	private String lastName;
}
