package gb.hw.springboot01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Springboot01Application {

	public static void main(String[] args) {
		SpringApplication springApp = new SpringApplication(Springboot01Application.class);
		springApp.setLogStartupInfo(false);
		springApp.run(args);
	}

}
