package com.wisdom.tarketing.domain.member.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class TimeUtils {

    public static final String KST = "Asia/Seoul";

    public static LocalDateTime convertTimeZone(Timestamp timestamp, String timeZone) {
        LocalDateTime localDateTime = timestamp.toLocalDateTime();
        ZonedDateTime utcDateTime = ZonedDateTime.of(localDateTime, ZoneOffset.UTC);
        return utcDateTime.withZoneSameInstant(ZoneId.of(timeZone)).toLocalDateTime();
    }
}
