package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        MemberService memberService = new MemberServiceImpl();

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); //@baen 붙은 애들을 얘가 다 관리해줌 마치 AppConfig
        MemberService memberService = applicationContext
            .getBean("memberService", MemberService.class);
        //메서드 이름으로 등록된 memberService를 꺼내와주는것임, 그리고 뒤에는 타입
        // applicationContext.getBean("memberService", MemberService.class) 한 후에 Crtl+alt+v 눌러서 꺼내와주기 만들어줌

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member); //메모리 객체에 넣어놓음

        Member fidnMember = memberService.findMember(1L);
        System.out.println("new member= " + member.getName());
        System.out.println("find member= " + fidnMember.getName());
    }

}
