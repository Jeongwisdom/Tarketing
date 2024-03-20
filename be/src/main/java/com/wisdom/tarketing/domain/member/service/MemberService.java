package com.wisdom.tarketing.domain.member.service;

import com.wisdom.tarketing.domain.member.dto.MemberResponse;
import com.wisdom.tarketing.domain.member.dto.MemberUpdateRequest;
import com.wisdom.tarketing.domain.member.entity.Member;
import com.wisdom.tarketing.domain.member.repository.MemberRepository;
import com.wisdom.tarketing.exception.CustomException;
import com.wisdom.tarketing.exception.errorcode.MemberErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberResponse getProfile(Long memberId, String timeZone) {
        return MemberResponse.from(getMember(memberId), timeZone);
    }

    public Member getMember(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new CustomException(MemberErrorCode.MEMBER_NOT_FOUND));
    }

    @Transactional
    public void updateProfile(Long memberId, MemberUpdateRequest memberUpdateRequest) {
        Member member = getMember(memberId);
        member.updateProfile(memberUpdateRequest);
    }
}
