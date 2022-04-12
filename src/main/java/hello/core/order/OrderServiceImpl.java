package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor //파이널이 붙은 (필수값들) 것들을 가지고 constructor (생성자)를 만들어줌
public class OrderServiceImpl implements OrderService {



    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy; //파이널 있으면 기본할당 or 생성자 할당 필요

    @Autowired //1. 생성자 하나시 코드생략가능
    public OrderServiceImpl(MemberRepository memberRepository,@MainDiscountPolicy DiscountPolicy rateDiscountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = rateDiscountPolicy;
    } //-> 롬복의 @RequiredArgsConstructor가 만들어줄것임


    @Override
    public Order creatOrder(Long memberId, String itemName, int itemPrice) {
        Member member =  memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }


    //테스트용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
