package scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class PrototypeTest {

    @Test
    void prototypeBeanFine(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
            prototypeBean.class);

        System.out.println("find prototypeBean1"); //프로토타입을 조회하기 직전에 생성됨
        prototypeBean prototypeBean1 = ac.getBean(prototypeBean.class);
        System.out.println("find prototypeBean2");
        prototypeBean prototypeBean2 = ac.getBean(prototypeBean.class);
        System.out.println("prototypeBean1 = " + prototypeBean1);
        System.out.println("prototypeBean2 = " + prototypeBean2);

        Assertions.assertThat(prototypeBean1).isNotSameAs(prototypeBean2);

    }

    @Scope("prototype")
    static class prototypeBean {
        @PostConstruct
        public void init(){
            System.out.println("prototypeBean.init");
        }

        @PreDestroy
        public void destroy(){
            System.out.println("prototypeBean.destroy");
        }
    }
}
