package com.test.orm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class OrmTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrmTestApplication.class, args);
	}

}
