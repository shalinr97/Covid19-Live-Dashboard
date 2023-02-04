package com.example.covid19dashapi.controller;

import com.example.covid19dashapi.model.AlertStatus;
import com.example.covid19dashapi.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/dash/cov19/alerts")
public class AlertController {

    @Autowired
    private AlertService alertService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/countries/{country}")
    AlertStatus getCov19TotalsForCountriesToday(@PathVariable String country) {
        return alertService.getAlertStatusAboutCountry(country);
    }
}
