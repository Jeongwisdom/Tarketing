package com.wisdom.tarketing.domain.member.service;

import static com.wisdom.tarketing.domain.member.util.TimeUtils.KST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import com.wisdom.tarketing.domain.member.dto.MemberResponse;
import com.wisdom.tarketing.domain.member.entity.Member;
import com.wisdom.tarketing.domain.member.repository.MemberRepository;
import com.wisdom.tarketing.exception.CustomException;
import com.wisdom.tarketing.exception.errorcode.MemberErrorCode;
import com.wisdom.tarketing.fixture.FixtureFactory;
import com.wisdom.tarketing.test_support.UnitTest;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

class MemberServiceTest extends UnitTest {

    @InjectMocks
    private MemberService memberService;
    @Mock
    private MemberRepository memberRepository;

    @DisplayName("회원 프로필을 조회한다.")
    @Test
    void getProfile() {
        // given
        Long existId = 1L;
        Member member = FixtureFactory.createMember();
        given(memberRepository.findById(any())).willReturn(Optional.ofNullable(member));

        // when
        MemberResponse profile = memberService.getProfile(existId, KST);

        // then
        assertThat(member).isNotNull();
        assertThat(profile.getName()).isEqualTo(member.getName());
        assertThat(profile.getCreatedAt()).isAfter(member.getCreatedAt().toLocalDateTime());
    }

    @DisplayName("회원 정보를 조회한다.")
    @Test
    void getMember() {
        // given
        Long existId = 1L;
        Member save = FixtureFactory.createMember();
        given(memberRepository.findById(any())).willReturn(Optional.ofNullable(save));

        // when
        Member find = memberService.getMember(existId);

        // then
        assertThat(save).isNotNull();
        assertThat(find.getName()).isEqualTo(save.getName());
        assertThat(find.getCreatedAt()).isEqualTo(save.getCreatedAt());
    }

    @DisplayName("회원 아이디가 존재하지 않아 회원 정보 조회에 실패한다.")
    @Test
    void getMember_fail() {
        // given
        Long notExistId = 0L;
        given(memberRepository.findById(any())).willReturn(Optional.empty());

        // when & then
        assertThatThrownBy(() -> memberService.getMember(notExistId))
                .isInstanceOf(CustomException.class)
                .hasMessageContaining(MemberErrorCode.MEMBER_NOT_FOUND.getErrorMessage());
    }
}