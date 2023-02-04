package com.example.covid19dashapi.service;

import com.example.covid19dashapi.MockData.CovidApiMockData;
import com.example.covid19dashapi.model.*;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class Covid19DataProviderServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private Covid19DataProviderService covid19DataProviderService;{
        MockitoAnnotations.openMocks(this);
    }

    @Test
    //@DisplayName("Get covid19 totals for all US States should return all state mock data.")
    public void getCov19TotalsForAllUSStatesTodayTest_ShouldReturnAllStateMockData(){

        when(restTemplate.getForObject(anyString(), any())).thenReturn(CovidApiMockData.getCovid19AllStateMockData());

        StateData[] stateData = covid19DataProviderService.getCov19TotalsForAllUSStatesToday();

        assertAll(
                () -> assertEquals("California", stateData[0].getState()),
                () -> assertEquals("Florida", stateData[1].getState())
        );
    }

    @Test
    //@DisplayName("Get covid19 totals for all country should return all country mock data.")
    public void getCov19TotalsForAllCountriesTodayTest_ShouldReturnAllCountryMockData(){

        when(restTemplate.getForObject(anyString(), any())).thenReturn(CovidApiMockData.getCovid19AllCountryMockData());

        CountryData[] countryData = covid19DataProviderService.getCov19TotalsForAllCountriesToday();

        assertAll(
                () -> assertEquals("India", countryData[0].getCountry()),
                () -> assertEquals("United States of America", countryData[1].getCountry())
        );
    }

    @Test
    //@DisplayName("Get covid19 totals for a country should return country mock data.")
    public void getCov19TotalsForCountriesTodayTest_ShouldReturnCountryMockData(){
        when(restTemplate.getForObject(anyString(), any(), any(Map.class))).thenReturn(CovidApiMockData.getCovid19CountryMockData());

        CountryData countryData = covid19DataProviderService.getCov19TotalsForCountriesToday("India");

        assertAll(
                () -> assertEquals("India", countryData.getCountry())
        );
    }

    @Test
    //@DisplayName("Get covid19 totals for all continent should return continent mock data.")
    public void getCov19TotalsForAllContinentsTodayTest_ShouldReturnAllContinentMockData(){

        when(restTemplate.getForObject(anyString(), any())).thenReturn(CovidApiMockData.getCovid19AllContinentMockData());

        ContinentData[] continentData = covid19DataProviderService.getCov19TotalsForAllContinentsToday();

        assertAll(
                () -> assertEquals("Asia", continentData[0].getContinent()),
                () -> assertEquals("Russia", continentData[1].getContinent())
        );
    }

    @Test
    //@DisplayName("Get covid19 totals globally should return global mock data.")
    public void getCov19TotalsGlobalTodayTest_ShouldReturnCovidApiMockData(){

        when(restTemplate.getForObject(anyString(), any())).thenReturn(CovidApiMockData.getCovid19GlobalMockData());

        CovidApiData covidApiData = covid19DataProviderService.getGlobalCov19TotalsToday();

        assertAll(
                () -> assertEquals(1237464633993L, covidApiData.getCases())
        );
    }

    @Test
    //@DisplayName("Get covid19 vaccine coverage for all countries should return all countries mock data.")
    public void getCov19VaccineCoverageForAllCountriesTodayTest_ShouldReturnAllCountriesVaccineCoverageMockData(){

        when(restTemplate.getForObject(anyString(), any(), any(Map.class))).thenReturn(CovidApiMockData.getCovid19VaccineCoverageAllCountryMockData());

        VaccineCoverageData[] vaccineCoverageData = covid19DataProviderService.getCov19VaccineCoverageForAllCountriesToday("1");

        assertAll(
                () -> assertEquals("India", vaccineCoverageData[0].getCountry()),
                () -> assertEquals("United States of America", vaccineCoverageData[1].getCountry())
        );
    }

    @Test
    //@DisplayName("Get covid19 vaccine coverage for a country should return country mock data.")
    public void getCov19VaccineCoverageForCountriesTodayTest_ShouldReturnCountriesVaccineCoverageMockData(){

        when(restTemplate.getForObject(anyString(), any(), any(Map.class))).thenReturn(CovidApiMockData.getCovid19VaccineCoverageCountryMockData());

        VaccineCoverageData vaccineCoverageData = covid19DataProviderService.getCov19VaccineCoverageForCountriesToday("1", "India");

        assertAll(
                () -> assertEquals("India", vaccineCoverageData.getCountry())
        );
    }
}
