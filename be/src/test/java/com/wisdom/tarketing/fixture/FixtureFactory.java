package com.wisdom.tarketing.fixture;

import com.wisdom.tarketing.domain.member.entity.Member;
import java.time.LocalDate;

public class FixtureFactory {

    public static Member createMember() {
        return Member.builder()
                .name("정지혜")
                .nickname("wiz")
                .email("wiz@naver.com")
                .address("경기도 수원시 영통구")
                .birth(LocalDate.of(1996, 7, 30))
                .build();
    }
}
