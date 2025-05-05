package com.example.hrdf.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TimeFormatterService {

    static final int SECONDS_IN_MINUTES = 60;
    static final int SECONDS_IN_HOUR = 60 * SECONDS_IN_MINUTES;
    static final int SECONDS_IN_DAY = 24 * SECONDS_IN_HOUR;
    static final int SECONDS_IN_YEAR = 365 * SECONDS_IN_DAY;

    public String formatTime(int seconds) {
        List<String> components = new ArrayList<>();

        if (seconds == 0) return "now";

        int years = seconds / SECONDS_IN_YEAR;
        seconds %= SECONDS_IN_YEAR;

        int days = seconds / SECONDS_IN_DAY;
        seconds %= SECONDS_IN_DAY;

        int hours = seconds / SECONDS_IN_HOUR;
        seconds %= SECONDS_IN_HOUR;

        int minutes = seconds / SECONDS_IN_MINUTES;
        seconds %= SECONDS_IN_MINUTES;

        if (years > 0) components.add(formatUnit(years, "year"));
        if (days > 0) components.add(formatUnit(days, "day"));
        if (hours > 0) components.add(formatUnit(hours, "hour"));
        if (minutes > 0) components.add(formatUnit(minutes, "minute"));
        if (seconds > 0) components.add(formatUnit(seconds, "second"));


        return formatComponents(components);
    }

    private static String formatUnit(int value, String unit) {
        return value + " " + unit + (value > 1 ? "s" : "");
    }

    private static String formatComponents(List<String> components) {
        if (components.size() == 1) {
            return components.get(0);
        } else if (components.size() == 2) {
            return components.get(0) + " and " + components.get(1);
        } else {
            String lastComponent = components.remove(components.size() - 1);
            return String.join(", ", components) + " and " + lastComponent;
        }
    }

}
