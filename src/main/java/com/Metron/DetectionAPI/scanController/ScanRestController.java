package com.Metron.DetectionAPI.scanController;

import com.Metron.DetectionAPI.enities.Request;
import com.Metron.DetectionAPI.service.ExternalLogService;
import com.Metron.DetectionAPI.service.ScanService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/scan")
public class ScanRestController {

    private final   ExternalLogService externalLogService;
    private final  ScanService scanService;

    public static Logger log = LoggerFactory.getLogger(ScanRestController.class);

    public ScanRestController(ExternalLogService externalLogService, ScanService scanService) {
        this.externalLogService = externalLogService;
        this.scanService = scanService;
    }

    @PostMapping ("/postEmail")
    public  ResponseEntity<Request> postEmail (@Valid @RequestBody Request request){
        return ResponseEntity.ok(scanService.validateEmail( request));
    }

    @GetMapping("/getLog")
    public   String getLog(){
    log.info("GetLOG   inside restController");
        return externalLogService.fetchLogs();
    }

    @GetMapping("/getCheck")
    public   String getCheck(){
        log.info("getCheck   inside restController");
        return "Hello GUYS TOKEN WORKED!!!!!";
    }
}
