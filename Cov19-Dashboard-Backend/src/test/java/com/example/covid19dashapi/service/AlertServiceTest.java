package com.example.covid19dashapi.service;

import com.example.covid19dashapi.model.AlertStatus;
import com.example.covid19dashapi.model.CountryData;
import com.example.covid19dashapi.model.StateData;
import com.example.covid19dashapi.model.VaccineCoverageData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static java.util.Map.entry;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AlertServiceTest {

    @InjectMocks
    private AlertService alertService;

    @Mock
    private Covid19DataProviderService covid19DataProviderService;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    //@DisplayName("When the total number of confirmed cases are less that 1000, set alert to green.")
    void getAlertAboutCountryTest_ShouldReturnCoverageDataWithGreenAlertLevel(){
        CountryData countryData = new CountryData();
        VaccineCoverageData vaccineCoverageData = new VaccineCoverageData();
        Map<String, Long> cov = Map.ofEntries(
                entry("11/15/22", 123445L)
        );
        countryData.setActive(999L);
        vaccineCoverageData.setTimeline(cov);

        when(covid19DataProviderService.getCov19TotalsForCountriesToday(ArgumentMatchers.anyString())).thenReturn(countryData);
        when(covid19DataProviderService.getCov19VaccineCoverageForCountriesToday(ArgumentMatchers.anyString(), ArgumentMatchers.anyString())).thenReturn(vaccineCoverageData);

        AlertStatus status = alertService.getAlertStatusAboutCountry("India");

        assertEquals("GREEN", status.getAlertLevel());
        assertEquals(Arrays.asList("Everything is Normal !!"), status.getMeasuresToBeTaken());

        //verify(covid19DataProvider, Mockito.times(1)).getStateData("Arunachal Pradesh");
    }

    @Test
    //@DisplayName("When the total number of confirmed cases are greater than 1000 and less than 10000, set alert to yellow.")
    void getAlertAboutCountryTest_ShouldReturnCoverageDataWithYellowAlertLevel(){
        CountryData countryData = new CountryData();
        VaccineCoverageData vaccineCoverageData = new VaccineCoverageData();
        Map<String, Long> cov = Map.ofEntries(
                entry("11/15/22", 123445L)
        );
        countryData.setActive(9999L);
        vaccineCoverageData.setTimeline(cov);

        when(covid19DataProviderService.getCov19TotalsForCountriesToday(ArgumentMatchers.anyString())).thenReturn(countryData);
        when(covid19DataProviderService.getCov19VaccineCoverageForCountriesToday(ArgumentMatchers.anyString(), ArgumentMatchers.anyString())).thenReturn(vaccineCoverageData);

        AlertStatus status = alertService.getAlertStatusAboutCountry("India");

        assertEquals("YELLOW", status.getAlertLevel());
    }

    @Test
    //@DisplayName("When the total number of confirmed cases are less that 1000, set alert to red.")
    void getAlertAboutCountryTest_ShouldReturnCoverageDataWithRedAlertLevel(){
        CountryData countryData = new CountryData();
        VaccineCoverageData vaccineCoverageData = new VaccineCoverageData();
        Map<String, Long> cov = Map.ofEntries(
                entry("11/15/22", 123445L)
        );
        countryData.setActive(10001L);
        vaccineCoverageData.setTimeline(cov);

        when(covid19DataProviderService.getCov19TotalsForCountriesToday(ArgumentMatchers.anyString())).thenReturn(countryData);
        when(covid19DataProviderService.getCov19VaccineCoverageForCountriesToday(ArgumentMatchers.anyString(), ArgumentMatchers.anyString())).thenReturn(vaccineCoverageData);

        AlertStatus status = alertService.getAlertStatusAboutCountry("India");

        assertEquals("RED", status.getAlertLevel());
    }
}
