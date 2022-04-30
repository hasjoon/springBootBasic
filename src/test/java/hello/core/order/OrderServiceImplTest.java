package hello.core.order;

import static org.junit.jupiter.api.Assertions.*;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;

class OrderServiceImplTest {

    @Test
    void creatOrder() { //순수한 자바코드 조립
        MemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(new MemoryMemberRepository(),
            new FixDiscountPolicy());
        Order order = orderService.creatOrder(1L, "iteamA", 100000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}