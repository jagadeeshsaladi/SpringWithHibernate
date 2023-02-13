package com.Slokam.springWithHibernate;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info =@Info(title="BOOK API",
              version = "1.0",
          	description = "Provides All BOOKS related API"))

@EnableAspectJAutoProxy
public class SpringWithHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWithHibernateApplication.class, args);
	} 

}
