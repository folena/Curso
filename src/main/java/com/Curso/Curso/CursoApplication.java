package com.Curso.Curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class CursoApplication {
	public static void main(String[] args) {
		SpringApplication.run(CursoApplication.class, args);
		
	}


		@RequestMapping ("/")
		@ResponseBody
		String home()
		{
			return "Hello World";
	}
		
}
