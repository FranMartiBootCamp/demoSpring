package com.example.demo;

//import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ejercicio1Application {
	
//	@Value("${course.message: Hellow World por defecto}")
//	private static String value; 

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio1Application.class, args);
		
//		try {
//			System.out.println(value);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
