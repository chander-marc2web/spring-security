package com.marc2web.springsecurity.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Controller
public class SpringMVCConfiguration implements WebMvcConfigurer{

	@Bean
	public BCryptPasswordEncoder getBCyptPasswordEncode(){
		return new BCryptPasswordEncoder();
	}
	
	
	
}
