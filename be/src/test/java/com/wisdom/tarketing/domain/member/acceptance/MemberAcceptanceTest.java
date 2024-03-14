package com.wisdom.tarketing.domain.member.acceptance;

import static org.assertj.core.api.Assertions.assertThat;

import com.wisdom.tarketing.domain.member.entity.Member;
import com.wisdom.tarketing.fixture.FixtureFactory;
import com.wisdom.tarketing.test_support.AcceptanceTest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class MemberAcceptanceTest extends AcceptanceTest {

    @DisplayName("프로필 조회에 성공한다.")
    @Test
    void getProfile_success() {
        // given
        Member save = memberRepository.save(FixtureFactory.createMember());

        // when
        ExtractableResponse<Response> response = getProfile();

        // then
        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.jsonPath().getString("name")).isEqualTo(save.getName());
        assertThat(response.jsonPath().getString("email")).isEqualTo(save.getEmail());
    }

    private ExtractableResponse<Response> getProfile() {
        return RestAssured
                .given().log().all()
                .when()
                .get("/api/members")
                .then().log().all()
                .extract();
    }
}
