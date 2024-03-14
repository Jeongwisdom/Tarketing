package com.wisdom.tarketing.domain.member.dto;

import com.wisdom.tarketing.domain.member.entity.Member;
import com.wisdom.tarketing.domain.member.util.TimeUtils;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberResponse {

    private final Long id;
    private final String name;
    private final String nickname;
    private final String email;
    private final String address;
    private final LocalDate birth;
    private final LocalDateTime createdAt;
    private final String profileImg;

    @Builder
    private MemberResponse(Long id, String name, String nickname, String email, String address, LocalDate birth,
                           LocalDateTime createdAt, String profileImg) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.address = address;
        this.birth = birth;
        this.createdAt = createdAt;
        this.profileImg = profileImg;
    }

    public static MemberResponse from(Member member, String timeZone) {
        return MemberResponse.builder()
                .id(member.getId())
                .name(member.getName())
                .nickname(member.getNickname())
                .email(member.getEmail())
                .address(member.getAddress())
                .birth(member.getBirth())
                .createdAt(TimeUtils.convertTimeZone(member.getCreatedAt(), timeZone))
                .profileImg(member.getProfileImg())
                .build();
    }
}
