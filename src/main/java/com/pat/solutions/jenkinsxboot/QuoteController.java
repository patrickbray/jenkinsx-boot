package com.pat.solutions.jenkinsxboot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/quote")
public class QuoteController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping
    public ResponseEntity<String> getQuote() {
        final String response = restTemplate.getForObject("https://quotes.rest/qod", String.class);
        return ResponseEntity.ok(response);
    }
}
