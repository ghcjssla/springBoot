package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@EnableAutoConfiguration
@ComponentScan
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}





















/*




@EnableAutoConfiguration
//스캔범위가 있다. 자기와같거나 하위만 검색하는걸로 보임
@ComponentScan
public class App implements CommandLineRunner{
	//@Autowired
	//CustomerRepository customerRepository;
	
	@Override
	public void run(String... strings) throws Exception {
		Customer created = customerRepository.save(new Customer(null,"김","호성"));
		System.out.println(created + " 생성됨!");
		
		*//**
		 * 자바 8부터 java.lang.Iterable 인터페이스에 추가된 forEach()
		 * 리스트의 각 데이터마다 forEach() 메서드에 인자로 전달한 람다 표현식을 적용
		 *  System.out::println은 메서드레퍼런스(method reference)라고함 (x)->{System.out.println(x);} 의 줄임형태
		 *//*
		//customerRepository.findAll().forEach(System.out::println);
		//customerRepository.findAllOrderByName().forEach(System.out::println);
		//System.out.println("=======>"+customerRepository.findId1());
		
		//페이징 처리
		Pageable pageable = new PageRequest(0, 3);
		Page<Customer> page = customerRepository.findAll(pageable);
		System.out.println("한페이지당 데이터 수  >>>> "+page.getSize());
		System.out.println("현제 페이지 >>>> "+page.getNumber());
		System.out.println("전체 페이지 수 >>>> "+page.getTotalPages());
		System.out.println("전체 데이터 수 >>>> "+page.getTotalElements());
		page.getContent().forEach(System.out::println);
		
		
		
	}
		
		String sql ="SELECT id, first_name, last_name FROM customers WHERE id = :id";
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("id", 1);
		//람다 사용전 코드

		  Customer result = jdbcTemplate.queryForObject(sql, param, 
				new RowMapper<Customer>() {
					@Override
					public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
						return new Customer(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"));
					}
				});

		// 람다 전환코드
		Customer result = jdbcTemplate.queryForObject(sql, param,
					(rs, rowNum) -> new Customer(
						rs.getInt("id"), 
						rs.getString("first_name"),
						rs.getString("last_name")
					)
				);
		
		
		System.out.println("result : "+result);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}*/