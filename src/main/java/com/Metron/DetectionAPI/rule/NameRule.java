package com.Metron.DetectionAPI.rule;

import org.springframework.stereotype.Service;

@Service
public class NameRule implements DetectionRule {
    @Override
    public boolean Detect(String name) {
        return name.matches("[a-z]+");
    }
}
