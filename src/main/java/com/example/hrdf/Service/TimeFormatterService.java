package com.example.hrdf.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

@Service
public class TimeFormatterService {

    static final int SECONDS_IN_MINUTES = 60;
    static final int SECONDS_IN_HOUR = 60 * SECONDS_IN_MINUTES;
    static final int SECONDS_IN_DAY = 24 * SECONDS_IN_HOUR;
    static final int SECONDS_IN_YEAR = 365 * SECONDS_IN_DAY;

    public String formatTime(int seconds) {
        if (seconds == 0)
            return "now";

        int years = seconds / SECONDS_IN_YEAR;
        seconds %= SECONDS_IN_YEAR;

        int days = seconds / SECONDS_IN_DAY;
        seconds %= SECONDS_IN_DAY;

        int hours = seconds / SECONDS_IN_HOUR;
        seconds %= SECONDS_IN_HOUR;

        int minutes = seconds / SECONDS_IN_MINUTES;
        seconds %= SECONDS_IN_MINUTES;

        List<String> components = Stream.of(
                years > 0 ? formatUnit(years, "year") : null,
                days > 0 ? formatUnit(days, "day") : null,
                hours > 0 ? formatUnit(hours, "hour") : null,
                minutes > 0 ? formatUnit(minutes, "minute") : null,
                seconds > 0 ? formatUnit(seconds, "second") : null)
                .filter(Objects::nonNull)
                .toList();

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
            List<String> mutableComponents = new ArrayList<>(components);
            String lastComponent = mutableComponents.remove(mutableComponents.size() - 1);
            return String.join(", ", mutableComponents) + " and " + lastComponent;
        }
    }

}
