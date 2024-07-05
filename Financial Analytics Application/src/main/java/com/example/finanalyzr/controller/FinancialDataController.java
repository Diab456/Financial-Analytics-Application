package com.example.finanalyzr.controller;

import com.example.finanalyzr.model.FinancialData;
import com.example.finanalyzr.service.FinancialDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/financial-data")
public class FinancialDataController {

    @Autowired
    private FinancialDataService service;

    @GetMapping
    public List<FinancialData> getAllData() {
        return service.getAllData();
    }

    @PostMapping
    public void saveData(@RequestBody FinancialData data) {
        service.saveData(data);
    }

    @GetMapping("/analyze")
    public Map<String, Object> analyzeAllData() {
        return service.analyzeAllData();
    }

    @GetMapping("/")
    public String home() {
        return "Welcome to my Spring Boot application";
    }
}
