package com.example.hrdf.Service;

import org.springframework.stereotype.Service;

@Service
public class TimeFormatterService {

    public String formatTime(int seconds) {
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int secs = seconds % 60;

        return String.format("%02d:%02d:%02d", hours, minutes, secs);
    }

}
