package com.wisdom.tarketing.domain.member.util;

import static com.wisdom.tarketing.domain.member.util.TimeUtils.KST;
import static org.assertj.core.api.Assertions.assertThat;

import com.wisdom.tarketing.test_support.UnitTest;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TimeUtilsTest extends UnitTest {

    @DisplayName("utc 타임존의 시간을 kst 타임존으로 변환한다.")
    @Test
    void convertTimeZone_kst() {
        // given
        Timestamp utc = Timestamp.valueOf(LocalDateTime.now(ZoneOffset.UTC));
        LocalDateTime kst = utc.toLocalDateTime().plusHours(9);

        // when
        LocalDateTime convertTimeZone = TimeUtils.convertTimeZone(utc, KST);

        // then
        assertThat(convertTimeZone).isEqualTo(kst);
    }

    @DisplayName("utc 타임존의 시간을 pst 타임존으로 변환한다.")
    @Test
    void convertTimeZone_sgt() {
        // given
        Timestamp utc = Timestamp.valueOf(LocalDateTime.now(ZoneOffset.UTC));
        LocalDateTime kst = utc.toLocalDateTime().plusHours(8);

        // when
        LocalDateTime convertTimeZone = TimeUtils.convertTimeZone(utc, "Asia/Singapore");

        // then
        assertThat(convertTimeZone).isEqualTo(kst);
    }
}