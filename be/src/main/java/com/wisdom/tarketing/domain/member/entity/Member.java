package com.wisdom.tarketing.domain.member.entity;

import com.wisdom.tarketing.domain.member.dto.MemberUpdateRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nickname;
    private String email;
    private String address;
    private LocalDate birth;
    private Timestamp createdAt;
    private String profileImg;

    @Builder
    private Member(String name, String nickname, String email, String address, LocalDate birth, Timestamp createdAt,
                   String profileImg) {
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.address = address;
        this.birth = birth;
        this.createdAt = createdAt == null ? Timestamp.valueOf(LocalDateTime.now(ZoneOffset.UTC)) : createdAt;
        this.profileImg = profileImg == null ? "https://cdn-icons-png.flaticon.com/128/2815/2815428.png" : profileImg;
    }

    public void updateProfile(MemberUpdateRequest memberUpdateRequest) {
        this.nickname = memberUpdateRequest.getNickname();
        this.address = memberUpdateRequest.getAddress();
    }
}
