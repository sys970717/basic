package com.example.basic.discount;

import com.example.basic.member.Grade;
import com.example.basic.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAcmount = 1000; // 1000원 할인

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) return discountFixAcmount;
        else return 0;
    }
}
