package com.example.basic.hello.core.order;

import com.example.basic.hello.core.discount.DiscountPolicy;
import com.example.basic.member.Member;
import com.example.basic.member.MemberRepository;
import com.example.basic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discoutPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discoutPrice);

    }
}
