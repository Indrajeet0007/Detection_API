package com.Metron.DetectionAPI.enities;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class Request {
    @Email
    public  String mail ;
    @NotBlank(message = "Mail id is required !!!")
    public String name ;
    public boolean flag;
}
