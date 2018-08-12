package server.PBAC;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import pbac.cases.CaseStudy;
import pbac.cases.JsonCaseStudy;
import server.services.PbacService;

@SpringBootApplication(scanBasePackages={"server"})
public class PbacApplication {

	@Autowired
	PbacService service;
	
	public static void main(String[] args) {
		SpringApplication.run(PbacApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init() {
		return (evt) -> this.service.setCases(new HashMap<String, CaseStudy>() {
			private static final long serialVersionUID = -7153515610567795748L;
			{
				try (Stream<Path> paths = Files.walk(Paths.get("./examples"))) {
				    paths
				    	.filter(p -> !p.toFile().isDirectory() && p.toFile().getName().endsWith("json"))
				    	.map(p -> new JsonCaseStudy(p))
					    .forEach(cse -> put(cse.getCaseName(), cse));
				        
				} 
	        }
		});
	}
}	
