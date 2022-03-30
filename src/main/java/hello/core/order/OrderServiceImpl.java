package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {



    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy; //파이널 있으면 기본할당 or 생성자 할당 필요

    public OrderServiceImpl(MemberRepository memberRepository,
        DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


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
