package com.example.covid19dashapi.controller;

import com.example.covid19dashapi.MockData.CovidApiMockData;
import com.example.covid19dashapi.helper.DashApiConstants;
import com.example.covid19dashapi.model.AlertStatus;
import com.example.covid19dashapi.model.CovidApiData;
import com.example.covid19dashapi.service.AlertService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class Covid19DataControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Covid19DataController covid19DataController;

    @Test
    void getGlobalCov19TotalsTodayTest_ShouldReturnGlobalData() throws Exception {
        Mockito.when(covid19DataController.getGlobalCov19TotalsToday()).thenReturn(CovidApiMockData.getCovid19GlobalMockData());

        mockMvc.perform(get("/v1/dash/cov19/all"))
                .andExpect(content().json("{\"updated\":0,\"cases\":1237464633993,\"todayCases\":0,\"deaths\":0,\"todayDeaths\":0,\"recovered\":0,\"todayRecovered\":0,\"active\":0,\"critical\":0,\"casesPerOneMillion\":0.0,\"deathsPerOneMillion\":0.0,\"tests\":0,\"testsPerOneMillion\":0.0,\"population\":0,\"oneCasePerPeople\":0.0,\"oneDeathPerPeople\":0.0,\"oneTestPerPeople\":0.0,\"activePerOneMillion\":0.0,\"recoveredPerOneMillion\":0.0,\"criticalPerOneMillion\":0.0,\"affectedCountries\":0}"))
                .andExpect(status().isOk());
    }

    @Test
    void getCov19TotalsForAllUSStatesTodayTest_ShouldReturnAllUSSatesData() throws Exception {
        Mockito.when(covid19DataController.getCov19TotalsForAllUSStatesToday()).thenReturn(CovidApiMockData.getCovid19AllStateMockData());

        mockMvc.perform(get("/v1/dash/cov19/all"))
                .andExpect(status().isOk());
    }

    @Test
    void getCov19TotalsForAllCountriesTodayTest_ShouldReturnALlCountriesData() throws Exception {
        Mockito.when(covid19DataController.getCov19TotalsForAllCountriesToday()).thenReturn(CovidApiMockData.getCovid19AllCountryMockData());

        mockMvc.perform(get("/v1/dash/cov19/countries"))
                .andExpect(status().isOk());
    }

    @Test
    void getCov19TotalsForAllContinentsTodayTest_ShouldReturnAllContinentsData() throws Exception {
        Mockito.when(covid19DataController.getCov19TotalsForAllContinentsToday()).thenReturn(CovidApiMockData.getCovid19AllContinentMockData());

        mockMvc.perform(get("/v1/dash/cov19/continents"))
                .andExpect(content().json("[{\"updated\":0,\"cases\":0,\"todayCases\":0,\"deaths\":0,\"todayDeaths\":0,\"recovered\":0,\"todayRecovered\":0,\"active\":0,\"critical\":0,\"casesPerOneMillion\":0.0,\"deathsPerOneMillion\":0.0,\"tests\":0,\"testsPerOneMillion\":0.0,\"population\":0,\"oneCasePerPeople\":0.0,\"oneDeathPerPeople\":0.0,\"oneTestPerPeople\":0.0,\"activePerOneMillion\":0.0,\"recoveredPerOneMillion\":0.0,\"criticalPerOneMillion\":0.0,\"affectedCountries\":0,\"continent\":\"Asia\",\"continentInfo\":{\"lat\":0.0,\"long\":0.0,\"iso2\":\"\",\"iso3\":\"\",\"_id\":0,\"flag\":\"\"},\"countries\":[]}]"));
    }

    @Test
    void getCov19TotalsForCountriesTodayTest_ShouldReturnCountryData() throws Exception {
        Mockito.when(covid19DataController.getCov19TotalsForCountriesToday("India")).thenReturn(CovidApiMockData.getCovid19CountryMockData());

        mockMvc.perform(get("/v1/dash/cov19/countries/India"))
                .andExpect(content().json("{\"updated\":0,\"cases\":0,\"todayCases\":0,\"deaths\":0,\"todayDeaths\":0,\"recovered\":0,\"todayRecovered\":0,\"active\":0,\"critical\":0,\"casesPerOneMillion\":0.0,\"deathsPerOneMillion\":0.0,\"tests\":0,\"testsPerOneMillion\":0.0,\"population\":0,\"oneCasePerPeople\":0.0,\"oneDeathPerPeople\":0.0,\"oneTestPerPeople\":0.0,\"activePerOneMillion\":0.0,\"recoveredPerOneMillion\":0.0,\"criticalPerOneMillion\":0.0,\"affectedCountries\":0,\"country\":\"India\",\"countryInfo\":{\"lat\":0.0,\"long\":0.0,\"iso2\":\"\",\"iso3\":\"\",\"_id\":0,\"flag\":\"\"},\"totalVaccinationCoverage\":0}"))
                .andExpect(status().isOk());
    }

    @Test
    void getCov19VaccineCoverageForCountriesTodayTest_ShouldReturnCountryVaccineData() throws Exception {
        Mockito.when(covid19DataController.getCov19VaccineCoverageForCountriesToday("India", "1")).thenReturn(CovidApiMockData.getCovid19VaccineCoverageCountryMockData());

        mockMvc.perform(get("/v1/dash/cov19/vaccine/coverage/countries/India/1"))
                .andExpect(content().json("{\"country\":\"India\",\"timeline\":{}}"));
    }

    @Test
    void getCov19VaccineCoverageForAllCountriesTodayTest_ShouldReturnAllCountryVaccineData() throws Exception {
        Mockito.when(covid19DataController.getCov19VaccineCoverageForAllCountriesToday("1")).thenReturn(CovidApiMockData.getCovid19VaccineCoverageAllCountryMockData());

        mockMvc.perform(get("/v1/dash/cov19/vaccine/coverage/countries/1"))
                .andExpect(content().json("[{\"country\":\"India\",\"timeline\":{}}]"));
    }






}
