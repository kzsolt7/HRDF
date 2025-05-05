package com.example.hrdf.RestController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrdf.Service.TimeFormatterService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/time")
@RequiredArgsConstructor
public class TimeFormatterRestController {

    private final TimeFormatterService timeFormatterService;

    @PostMapping("/format")
    public String formatTime(@RequestParam int seconds) {
        return timeFormatterService.formatTime(seconds);
    }

}
