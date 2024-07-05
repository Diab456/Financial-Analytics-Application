package com.example.finanalyzr;

import com.example.finanalyzr.model.FinancialData;
import com.example.finanalyzr.service.FinancialDataService;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FinanalyzrApplicationTests {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private FinancialDataService service;

    @Test
    void analyzeAllDataReturnsCorrectAnalysis() {
        FinancialData data = new FinancialData();
        data.setSymbol("AAPL");
        data.setDate("2023-01-01");
        data.setOpen(150.0);
        data.setClose(155.0);
        data.setHigh(157.0);
        data.setLow(148.0);
        data.setVolume(1000000);

        service.saveData(data);

        ResponseEntity<Map> response = restTemplate.getForEntity("http://localhost:" + port + "/api/financial-data/analyze", Map.class);
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).containsKeys("average_open", "average_close", "average_high", "average_low", "total_volume", "moving_average", "RSI");
    }

}
