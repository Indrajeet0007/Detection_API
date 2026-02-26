package com.Metron.DetectionAPI.rule;

import org.springframework.stereotype.Service;

@Service
public class EmailRule implements  DetectionRule{

    @Override
    public  boolean Detect(String email) {
        return email.matches("[a-zA-Z]+");
    }
}
