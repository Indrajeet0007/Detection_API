package com.Metron.DetectionAPI.service;

import com.Metron.DetectionAPI.customException.InvalidParameter;
import com.Metron.DetectionAPI.enities.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ScanService {
    public static Logger log = LoggerFactory.getLogger(ScanService.class);
    public  Request validateEmail(Request request){
        request.flag= request.mail.matches("@+");
        log.warn("FLAG :", request.flag);
        if(request.name.matches("[a-z]+")){
                throw new InvalidParameter("please enter correct name : "+request.name);
        }
        return request;
    }
}
