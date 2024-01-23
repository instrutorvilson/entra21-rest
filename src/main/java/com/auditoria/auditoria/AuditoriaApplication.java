package com.auditoria.auditoria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.auditoria.auditoria.auditores.AuditingService;

@SpringBootApplication
//@EnableJpaAuditing(auditorAwareRef = "auditingService")
public class AuditoriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuditoriaApplication.class, args);
	}
	
	/*@Bean
	AuditorAware<String> auditorProvider(){
		return new AuditingService();
	}*/

}

//https://medium.com/@rodrigoventuri123/auditoria-com-spring-data-jpa-fbb54c4b443e
