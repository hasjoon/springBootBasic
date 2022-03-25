package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
    excludeFilters =  @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
    //위의 것처럼 해줌으로서 AppConfig에 있는 @Bean 클래스들의 자동 등록을 빼줄 수 있음 = 컴포넌트 스캔은 자동으로 빈을 등록해주기때문에 충돌나면 안되니까
    //4:51
)

public class
AutoAppConfig {


}
