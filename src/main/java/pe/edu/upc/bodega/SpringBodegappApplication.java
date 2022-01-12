package pe.edu.upc.bodega;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"pe.edu.upc.bodega"})
public class SpringBodegappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBodegappApplication.class, args);
	}

}
