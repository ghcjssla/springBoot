package com.example.app.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.domain.Customer;

/**
 * 
 * @author hogi_ghcjssla
 *
 * 트랜잭션을 클래스 수준에 넣었음
 * 메서드가 제대로 실행되면 트랜잭션 커밋
 * 실행도중 오류나면 롤백
 */
@Repository
@Transactional
public class CustomerRepository {
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	
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
			jdbcTemplate.update("INSERT INTO customers(first_name, last_name) " 
								+ "values(:firstName, :lastName)", param);
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
}
