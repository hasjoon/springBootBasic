package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
//    basePackages = "hello.core.member",
    //이렇게하면 탐색 위치를 지정할 수 있음
    //지정하지 않으면 @ComponentScan이 붙은 설정정보 클래스의 패키지가 시작 위치가 된다. 위에 "package hello.core"안의 모든 클래스들
    basePackageClasses = AutoAppConfig.class,
    excludeFilters =  @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
    //위의 것처럼 해줌으로서 AppConfig에 있는 @Bean 클래스들의 자동 등록을 빼줄 수 있음 = 컴포넌트 스캔은 자동으로 빈을 등록해주기때문에 충돌나면 안되니까
)

public class AutoAppConfig {

//    @Bean(name = "memoryMemberRepository")
//    MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
}
