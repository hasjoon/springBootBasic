package lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLiftCycleTest {

    @Test
    public void lifeCycleTest(){
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext( //ApplicationContext에는 ac.close 가 없음,
            // ConfigurableApplicationContext>AnnotationConfigApplicationContext>ApplicationContext 그래서 부모(configurable)가 자식(Annotation...context)을 받을 수 있음
            LifeCycleConfig.class); //()안에 넣는게 빈으로 등록하는 방법
        NetworkClient client = ac.getBean(NetworkClient.class); //빈 조회
        ac.close();
    }

    @Configuration
    static class LifeCycleConfig {

        @Bean
        public NetworkClient networkClient(){
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }
    }

}
