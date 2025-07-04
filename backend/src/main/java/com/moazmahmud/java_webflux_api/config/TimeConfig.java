package com.moazmahmud.java_webflux_api.config;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class TimeConfig {
    public static LocalDateTime now() {
        return LocalDateTime.now(ZoneId.of("Asia/Dhaka"));
    }
}
