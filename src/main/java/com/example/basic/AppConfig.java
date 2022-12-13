package com.example.basic;

import com.example.basic.hello.core.discount.DiscountPolicy;
import com.example.basic.hello.core.discount.FixDiscountPolicy;
import com.example.basic.hello.core.discount.RateDiscountPolicy;
import com.example.basic.hello.core.order.OrderService;
import com.example.basic.hello.core.order.OrderServiceImpl;
import com.example.basic.member.MemberService;
import com.example.basic.member.MemberServiceImpl;
import com.example.basic.member.MemoryMemberRepository;

public class AppConfig {
    private MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

    public MemberService memberService () {
        // 생성자 주입
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
}
