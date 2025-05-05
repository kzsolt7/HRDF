package com.example.hrdf;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.hrdf.Service.TimeFormatterService;

public class TimeFormatterServiceTest {
    private final TimeFormatterService timeFormatterService = new TimeFormatterService();

    @Test
    void testFormatTimeNow() {
        assertEquals("now", timeFormatterService.formatTime(0));
    }

}
