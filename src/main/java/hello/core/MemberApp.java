package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
//        MemberService memberService = new MemberServiceImpl();
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member); //메모리 객체에 넣어놓음

        Member fidnMember = memberService.findMember(1L);
        System.out.println("new member= " + member.getName());
        System.out.println("find member= " + fidnMember.getName());
    }

}
