package com.example.hrdf.RestController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/time")
public class TimeFormatterRestController {

    @PostMapping("/format")
    public String formatTime(@RequestParam int seconds) {
        return "Time formatted successfully";
    }

}
