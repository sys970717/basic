package com.example.basic;

import com.example.basic.hello.core.discount.DiscountPolicy;
import com.example.basic.hello.core.discount.FixDiscountPolicy;
import com.example.basic.hello.core.discount.RateDiscountPolicy;
import com.example.basic.hello.core.order.OrderService;
import com.example.basic.hello.core.order.OrderServiceImpl;
import com.example.basic.member.MemberService;
import com.example.basic.member.MemberServiceImpl;
import com.example.basic.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

    @Bean
    public MemberService memberService () {
        // 생성자 주입
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
}
