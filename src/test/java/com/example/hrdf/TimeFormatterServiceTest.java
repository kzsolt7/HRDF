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

    @Test
    void testFormatTimeSeconds() {
        assertEquals("1 second", timeFormatterService.formatTime(1));
    }

    @Test
    void testFormatTimeMinutesAndSeconds() {
        assertEquals("1 minute and 2 seconds", timeFormatterService.formatTime(62));
    }

    @Test
    void testFormatTimeHoursMinutesAndSeconds() {
        assertEquals("1 hour, 1 minute and 2 seconds", timeFormatterService.formatTime(3662));
    }

    @Test
    void testFormatTimeYears() {
        assertEquals("1 year", timeFormatterService.formatTime(31536000));
    }

}
