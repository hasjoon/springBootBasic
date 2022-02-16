package hello.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoreApplication {
	// 역할과 구현
	// 인터페이스와 구현체
	// 로미오[인터페이스] / 구현체[현빈, 원빈 ...]
	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
	}

}
