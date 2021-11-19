package guru.springframework.spring5webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring5webappApplication {

	public static void main(String[] args) {
		System.out.println("About to run the Spring5WebApplication.......");
		SpringApplication.run(Spring5webappApplication.class, args);
		System.out.println("Completed running Spring5WebApplication.......");
	}
}
