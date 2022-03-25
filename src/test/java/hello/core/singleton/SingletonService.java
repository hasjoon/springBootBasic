package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();
    //자기 자신을 내부에 static으로 가지고 잇음 = 클래스 레벨에 올라가기에 딱 하나만 존재할 수 있게됨

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService(){
        //이렇게 만들어놓으면 다른 클래스에서
        //SingletonService singletonService = new SingletonService(); 이렇게 호출 할 수 없음;
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
