package scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class SingletonTest {
    @Test
    void singletonBeanFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
            SingletonBean.class);
        SingletonBean SingletonBean1 = ac.getBean(SingletonBean.class);
        SingletonBean SingletonBean2 = ac.getBean(SingletonBean.class);
        System.out.println("SingletonBean1 = " + SingletonBean1);
        System.out.println("SingletonBean2 = " + SingletonBean2);

        Assertions.assertThat(SingletonBean1).isSameAs(SingletonBean2);

        ac.close();
    }

    @Scope("singleton") //디폴트 라서 안해도됨
    static class SingletonBean {

        @PostConstruct
        public void init(){
            System.out.println("SingletonBean.init");
        }

        @PreDestroy
        public void destroy(){
            System.out.println("SingletonBean.destroy");
        }


    }
}
