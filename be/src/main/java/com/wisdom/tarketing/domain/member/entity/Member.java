package com.wisdom.tarketing.domain.member.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
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
    @Builder.Default
    private Timestamp createdAt = Timestamp.from(Instant.now());
    @Builder.Default
    private String profileImg = "https://cdn-icons-png.flaticon.com/128/2815/2815428.png";

    @Builder
    private Member(String name, String nickname, String email, String address, LocalDate birth, Timestamp createdAt,
                   String profileImg) {
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.address = address;
        this.birth = birth;
        this.createdAt = createdAt;
        this.profileImg = profileImg;
    }
}
