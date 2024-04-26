package trojanHousing.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
@SpringBootApplication
@EntityScan("trojanHousing.backend.entity")

public class TrojanHousingBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrojanHousingBackendApplication.class, args);
	}

}
