package com.marc2web.springsecurity.configurations;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class SpringMVCConfiguration implements WebMvcConfigurer {

	 @Autowired
	    private MessageSource messageSource;
	
	@Bean
	public BCryptPasswordEncoder getBCyptPasswordEncode() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public Validator getValidator() {
		LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
		factory.setValidationMessageSource(messageSource);
		return factory;
	}

}
