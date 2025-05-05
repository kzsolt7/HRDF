package com.example.hrdf.Service;

import org.springframework.stereotype.Service;

@Service
public class TimeFormatterService {

    static final int SECONDS_IN_MINUTES = 60;
    static final int SECONDS_IN_HOUR = 60 * SECONDS_IN_MINUTES;
    static final int SECONDS_IN_DAY = 24 * SECONDS_IN_HOUR;
    static final int SECONDS_IN_YEAR = 365 * SECONDS_IN_DAY;

    public String formatTime(int seconds) {
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int secs = seconds % 60;

        return String.format("%02d:%02d:%02d", hours, minutes, secs);
    }

}
