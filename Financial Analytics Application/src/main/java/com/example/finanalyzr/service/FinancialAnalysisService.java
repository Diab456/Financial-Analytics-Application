package com.example.finanalyzr.service;

import com.example.finanalyzr.model.FinancialData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

@Service
public class FinancialAnalysisService {
    private static final Logger logger = LoggerFactory.getLogger(FinancialAnalysisService.class);

    @Autowired
    private RestTemplate restTemplate;

    public Map<String, Object> analyzeFinancialData(List<FinancialData> data) {
        String flaskServiceUrl = "http://127.0.0.1:5000/analyze";
        try {
            logger.info("Sending data to Flask service for analysis: {}", flaskServiceUrl);
            Map<String, Object> response = restTemplate.postForObject(flaskServiceUrl, data, Map.class);
            logger.info("Received response from Flask service");
            return response;
        } catch (Exception e) {
            logger.error("Error communicating with Flask service", e);
            throw new RuntimeException("Error communicating with Flask service", e);
        }
    }
}
