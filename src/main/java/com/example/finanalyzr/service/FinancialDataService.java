package com.example.finanalyzr.service;

import com.example.finanalyzr.model.FinancialData;
import com.example.finanalyzr.repository.FinancialDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

@Service
public class FinancialDataService {
    private static final Logger logger = LoggerFactory.getLogger(FinancialDataService.class);

    @Autowired
    private FinancialDataRepository repository;

    @Autowired
    private FinancialAnalysisService analysisService;

    public List<FinancialData> getAllData() {
        return repository.findAll();
    }

    public void saveData(FinancialData data) {
        repository.save(data);
    }

    public Map<String, Object> analyzeAllData() {
        List<FinancialData> data = getAllData();
        logger.info("Starting analysis of financial data");
        try {
            Map<String, Object> analysisResult = analysisService.analyzeFinancialData(data);
            logger.info("Analysis completed successfully");
            return analysisResult;
        } catch (Exception e) {
            logger.error("Error analyzing financial data", e);
            throw new RuntimeException("Error analyzing financial data", e);
        }
    }
}
