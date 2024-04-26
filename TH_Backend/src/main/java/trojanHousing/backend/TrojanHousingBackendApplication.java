package trojanHousing.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@ComponentScan(basePackages={"trojanHousing.backend"})

public class TrojanHousingBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrojanHousingBackendApplication.class, args);
	}

}
