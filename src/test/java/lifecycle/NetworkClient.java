package lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient {


    private String url;

    public NetworkClient(){ //생성자
        System.out.println("생성자 호출, url = " + url);
        connect();
        call("초기화 연결 메세지");
    }

    public void setUrl(String url) { //외부에서 넣을 수 있음
        this.url = url;
    }

    //서비스 시작시 호출
    public void connect(){
        System.out.println("connect: " + url);
    }

    public void call(String message) {
        System.out.println("call: " + url + "Mmessage: " + message );
    }

    //서비스 종료시 호출
    public void disconnect(){
        System.out.println("close " + url);
    }

    @PostConstruct
    public void init() { //의존관계 주입이 끝나면 호출해줌
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메세지");
    }

    @PreDestroy
    public void close() throws Exception { //빈이 종료될때 호출
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
