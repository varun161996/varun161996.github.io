package com.scb.team_L;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.scb.team_L.*;
import com.scb.model.Customer;
import com.scb.repository.CustomerRepoImpl;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@SpringBootApplication(scanBasePackages = { "com.scb" })
public class TeamLApplication{
	
	public final static String ACC_SID = "AC94e9372726a9c514a69dac9701198152";
	public final static String ACC_KEY = "5d335847d77f7433be0ac2e734e5a909"; 
	
	private static final Logger logger = LoggerFactory.getLogger(TeamLApplication.class);
	
	//new
		protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
			return application.sources(TeamLApplication.class);
		}
		//end
		

	public static void main(String[] args) {
		SpringApplication.run(TeamLApplication.class, args);
	}
	
	

	@Bean
	@Autowired
	public CommandLineRunner setup(CustomerRepoImpl custRepository) {
		return (args) -> {

			logger.info("The sample data has been generated");
			
			// fetch all customers
			logger.info("Customer found with findAll():");
			logger.info("-------------------------------");

		};
	}
}
