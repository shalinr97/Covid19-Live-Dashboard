package com.example.covid19dashapi.service;

import com.example.covid19dashapi.helper.DashApiConstants;
import com.example.covid19dashapi.model.AlertStatus;
import com.example.covid19dashapi.model.CountryData;
import com.example.covid19dashapi.model.VaccineCoverageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

@Service
public class AlertService {

    @Autowired
    private Covid19DataProviderService covid19DataProviderService;

    public AlertStatus getAlertStatusAboutCountry(String country){

        AlertStatus alertStatus = new AlertStatus();

        CountryData countryData = covid19DataProviderService.getCov19TotalsForCountriesToday(country);
        // Vaccine Coverage Data since last 1 day
        VaccineCoverageData vaccineCoverageData = covid19DataProviderService.getCov19VaccineCoverageForCountriesToday("1",country);

        Map<String, Long> timeline = vaccineCoverageData.getTimeline();
        String[] keys = timeline.keySet().toArray(new String[1]);
        countryData.setTotalVaccinationCoverage(timeline.get(keys[0]));
        alertStatus.setCountryData(countryData);
        if (countryData.getActive() < 1000) {
            alertStatus.setAlertLevel(DashApiConstants.AlertLevels.GREEN.name());
            alertStatus.setMeasuresToBeTaken(Collections.singletonList("Everything is Normal !!"));
        } else if (countryData.getActive() > 1000 && countryData.getActive() < 10000) {
            alertStatus.setAlertLevel(DashApiConstants.AlertLevels.YELLOW.name());
            alertStatus.setMeasuresToBeTaken(Arrays.asList("Only Essential services are allowed", "List of services that come under essential service"));
        } else {
            alertStatus.setAlertLevel(DashApiConstants.AlertLevels.RED.name());
            alertStatus.setMeasuresToBeTaken(Arrays.asList("Absolute lock-down", "Only Medical and food services are allowed here"));
        }
        return alertStatus;
    }
}
