package com.wisdom.tarketing.domain.member.controller;

import static com.wisdom.tarketing.domain.member.util.TimeUtils.KST;

import com.wisdom.tarketing.domain.member.dto.MemberResponse;
import com.wisdom.tarketing.domain.member.dto.MemberUpdateRequest;
import com.wisdom.tarketing.domain.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/members")
@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    @GetMapping
    public ResponseEntity<MemberResponse> getProfile(
            @CookieValue(value = "timeZone", defaultValue = KST) String timeZone) {
        Long memberId = 1L;
        return ResponseEntity.ok(memberService.getProfile(memberId, timeZone));
    }

    @PatchMapping
    public ResponseEntity<Void> updateProfile(@Valid MemberUpdateRequest memberUpdateRequest) {
        Long memberId = 1L;
        memberService.updateProfile(memberId, memberUpdateRequest);

        return ResponseEntity.ok().build();
    }
}
