package lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy; //javax는 자바에서 공식으로 지원하는것, 즉 스프링에 종속적인 기술이 아니다 = 스프링이 아닌 다른 컨테이너 에서도 잘 동작함


public class NetworkClient {


    private String url;

    public NetworkClient(){ //생성자
        System.out.println("생성자 호출, url = " + url);

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
