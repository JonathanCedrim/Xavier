package br.com.amora.xavier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class XavierApplication extends SpringBootServletInitializer{

	//configuração para gerar .war
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(XavierApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(XavierApplication.class, args);
	}
}
