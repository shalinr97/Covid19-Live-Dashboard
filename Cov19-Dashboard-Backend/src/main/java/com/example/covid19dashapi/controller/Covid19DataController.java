package com.example.covid19dashapi.controller;

import com.example.covid19dashapi.model.*;
import com.example.covid19dashapi.service.Covid19DataProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/v1/dash/cov19/")
public class Covid19DataController {

    @Autowired
    private Covid19DataProviderService covid19DataProviderService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/all")
    CovidApiData getGlobalCov19TotalsToday() {
        return covid19DataProviderService.getGlobalCov19TotalsToday();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/states")
    StateData[] getCov19TotalsForAllUSStatesToday() {
        return covid19DataProviderService.getCov19TotalsForAllUSStatesToday();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/countries")
    CountryData[] getCov19TotalsForAllCountriesToday() {
        return covid19DataProviderService.getCov19TotalsForAllCountriesToday();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/continents")
    ContinentData[] getCov19TotalsForAllContinentsToday() {
        return covid19DataProviderService.getCov19TotalsForAllContinentsToday();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/countries/{country}")
    CountryData getCov19TotalsForCountriesToday(@PathVariable String country) {
        return covid19DataProviderService.getCov19TotalsForCountriesToday(country);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/vaccine/coverage/countries/{lastDays}")
    VaccineCoverageData[] getCov19VaccineCoverageForAllCountriesToday(@PathVariable String lastDays) {
        return covid19DataProviderService.getCov19VaccineCoverageForAllCountriesToday(lastDays);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/vaccine/coverage/countries/{country}/{lastDays}")
    VaccineCoverageData getCov19VaccineCoverageForCountriesToday(@PathVariable String country,@PathVariable String lastDays) {
        return covid19DataProviderService.getCov19VaccineCoverageForCountriesToday(lastDays, country);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/vaccine/coverage/countries/all/{lastDays}")
    Map<String, Long> getCov19VaccineCoverageForAll(@PathVariable String lastDays) {
        return covid19DataProviderService.getCov19VaccineCoverageForAllToday(lastDays);
    }
}
