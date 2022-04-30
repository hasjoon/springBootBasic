package hello.core.common;

import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;


@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
//스프링 컨테이너 요청시점에 생성됨, HTTP요청당 하나씩 생성되고, HTTP요청이 끝나느 시점에 소멸된다.
//생성되는 시점에@PoseConstructer에서 초기화메서드를 사용해 uuid생성후 저장해둠
public class MyLogger {

    private String uuid;
    private String requestURL;

    public void setRequestURL (String requestURL){
        this.requestURL = requestURL;
    }

    public void log(String message){
        System.out.println("[" + uuid + "]" + "[" + requestURL + "]" + message);
    }

    @PostConstruct
    public void init(){
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid + "] request scope bean creat:" + this); //this = 주소까지 이쁘게나옴`

    }

    @PreDestroy
    public void close(){
        System.out.println("[" + uuid + "] request scope bean close:" + this); //this = 주소까지 이쁘게나옴`
    }
}
