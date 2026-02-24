package com.Metron.DetectionAPI.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ExternalLogService {

    private final WebClient webClient;
    public  static Logger log = LoggerFactory.getLogger(ExternalLogService.class);
    // Constructor Injection
    public ExternalLogService(WebClient webClient) {
        this.webClient = webClient;
    }
@Scheduled(cron = "* */1 * * * ?")
    public String fetchLogs() {
        log.info("Inside Service");
        return webClient.get()
                .uri("/printService/getLog")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}