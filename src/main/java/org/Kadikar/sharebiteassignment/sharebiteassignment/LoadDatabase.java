package org.Kadikar.sharebiteassignment.sharebiteassignment;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {
	@Bean
	CommandLineRunner initDatabase(MenuSectionRepository repository) {
		return args -> {
			log.info("Preloading " + repository.save(new MenuSection("Breakfast Specials")));
			log.info("Preloading " + repository.save(new MenuSection("Lunch Specials")));
			log.info("Preloading " + repository.save(new MenuSection("Dinner Specials")));
			log.info("Preloading " + repository.save(new MenuSection("Daily Specials")));
		};	
	}
}
