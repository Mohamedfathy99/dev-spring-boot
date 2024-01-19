package com.luv2code.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
// Primary make priority for this implementation
// but if used @Qualifiers ("another Implementation") then priority for @Qualifiers [Qualifiers have higher priority]
// @Primary
public class CricketCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
}
