package hello.core.order;

public interface OrderService { //퍼블릭 - 외부공개는 파일명이 맞아야함
    Order creatOrder(Long memberId, String itemName, int itemPrice);

}
