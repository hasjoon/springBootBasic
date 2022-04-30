package hello.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoreApplication {
	// 역할과 구현
	// 인터페이스와 구현체
	// 로미오[인터페이스] / 구현체[현빈, 원빈 ...]
	// 스프링 부트는 빈 이름이 중복되면 (자동 수동 중복) 안돌아간다 [but 기본 스프링은 돌아간다]
	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
	}

}
