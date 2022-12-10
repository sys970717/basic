package com.example.basic;

import com.example.basic.hello.core.order.Order;
import com.example.basic.hello.core.order.OrderService;
import com.example.basic.hello.core.order.OrderServiceImpl;
import com.example.basic.member.Grade;
import com.example.basic.member.Member;
import com.example.basic.member.MemberService;
import com.example.basic.member.MemberServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();
        Long memberId = 1L;
        Member member = new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order =" + order);
        System.out.println("order.calculate= " + order.calculatePrice());
    }
}
