package com.example.app.repository;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.domain.Customer;

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

/* 스프링 데이터JPA를 사용하기위해 주석 처리
*//**
 * 
 * @author hogi_ghcjssla
 *
 * 트랜잭션을 클래스 수준에 넣었음
 * 메서드가 제대로 실행되면 트랜잭션 커밋
 * 실행도중 오류나면 롤백
 *//*
@Repository
@Transactional
public class CustomerRepository {
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	SimpleJdbcInsert insert;
	
	@PostConstruct
	public void init(){
		insert = new SimpleJdbcInsert((JdbcTemplate) jdbcTemplate.getJdbcOperations())
				.withTableName("customers")
				.usingGeneratedKeyColumns("id");
	}
	
	private static final RowMapper<Customer> customerRowMapper = (rs, i) ->{
		Integer id = rs.getInt("id");
		String firstName = rs.getString("first_name");
		String lastName = rs.getString("last_name");
		return new Customer(id, firstName, lastName);
	};
	
	public List<Customer> findAll(){
		List<Customer> customers = jdbcTemplate.query(
				"SELECT id, first_name, last_name FROM customers order by id", customerRowMapper);
		return customers;
	}
	
	public Customer findOne(Integer customerId){
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", customerId);
		return jdbcTemplate.queryForObject(
				"SELECT id, first_name, last_name from customers where id=:id", param, customerRowMapper);
	}
	
	public Customer save(Customer customer){
		SqlParameterSource param = new BeanPropertySqlParameterSource(customer);
		if(customer.getId() == null){
			Number key = insert.executeAndReturnKey(param);
            customer.setId(key.intValue());
		}else{
			jdbcTemplate.update("UPDATE customers SET first_name:firstName, "
					+ "last_name=:lastName WHERE id=:id", param);
		}
		return customer;
	}
	
	public void delete(Integer customerId){
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", customerId);
		jdbcTemplate.update("DELETE FROM customers WHERE id=:id", param);
	}
}*/
