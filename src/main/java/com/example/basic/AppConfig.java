package com.example.basic;

import com.example.basic.hello.core.discount.FixDiscountPolicy;
import com.example.basic.hello.core.discount.RateDiscountPolicy;
import com.example.basic.hello.core.order.OrderService;
import com.example.basic.hello.core.order.OrderServiceImpl;
import com.example.basic.member.MemberService;
import com.example.basic.member.MemberServiceImpl;
import com.example.basic.member.MemoryMemberRepository;

public class AppConfig {
    public MemberService memberService () {
        // 생성자 주입
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new RateDiscountPolicy());
    }
}
