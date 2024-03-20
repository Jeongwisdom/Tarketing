package com.wisdom.tarketing.domain.member.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberUpdateRequest {

    @NotBlank(message = "닉네임은 비어있을 수 없습니다.")
    @Size(max = 10, message = "닉네임은 10자를 넘을 수 없습니다.")
    private final String nickname;
    @NotBlank(message = "이메일은 비어있을 수 없습니다.")
    private final String address;

    @Builder
    private MemberUpdateRequest(String nickname, String address) {
        this.nickname = nickname;
        this.address = address;
    }
}
