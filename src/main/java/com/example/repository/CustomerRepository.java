package com.example.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.domain.Customer;

/**
 * JpaRepository에는 CRUD조작용 기본 메서드가 정의되어있음
 * findOne, save, findAll, delete
 * 인터페이스만 있으면 실행시에 실행클래스가 생성됨
 * @author hogi_ghcjssla
 *
 */

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	//JPQL 기술시 @Query 어노테이션 사용
	@Query("SELECT x FROM Customer x ORDER BY x.firstName, x.lastName")
	List<Customer> findAllOrderByName();
	
	@Query(value="SELECT id, first_name, last_name FROM customers WHERE id=5", nativeQuery = true)
	List<Customer> findId1();
}