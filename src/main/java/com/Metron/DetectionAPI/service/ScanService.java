package com.Metron.DetectionAPI.service;

import com.Metron.DetectionAPI.customException.InvalidParameter;
import com.Metron.DetectionAPI.enities.Request;
import com.Metron.DetectionAPI.rule.EmailRule;
import com.Metron.DetectionAPI.rule.NameRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class ScanService {
    public static Logger log = LoggerFactory.getLogger(ScanService.class);
    @Autowired
    private EmailRule emailRule;
    @Autowired
    private NameRule nameRule;

   @Retryable(value = {RuntimeException.class},
   maxAttempts = 10,
   backoff = @Backoff(delay = 1000 , multiplier = 2) )
    public  void check(){
       log.info("presnet in check method!!!"+"INDRAJEET".matches("[a-z]+"));
        if(!"INDRAJEET".matches("[a-z]+")){
            log.info("NOT  in check method!!!");

            throw new InvalidParameter("please enter correct name : ");
        }
    }
    @Recover
    public String recover(RuntimeException ex) {
        log.error("External API failed after retries", ex);
        return "FAILED";
    }
    public  Request validateEmail(Request request){
        request.flag= emailRule.Detect(request.mail) && nameRule.Detect(request.name) ;
        log.info("email"+emailRule.Detect(request.mail)+nameRule.Detect(request.name) );
        log.warn("FLAG :"+ request.flag);
        if(request.name.matches("[a-z]+")){
                throw new InvalidParameter("please enter correct name : "+request.name);
        }
        return request;
    }
}
