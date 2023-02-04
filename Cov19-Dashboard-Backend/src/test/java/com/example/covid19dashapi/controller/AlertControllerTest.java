package com.example.covid19dashapi.controller;

import com.example.covid19dashapi.helper.DashApiConstants;
import com.example.covid19dashapi.model.AlertStatus;
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

@SpringBootTest
@AutoConfigureMockMvc
public class AlertControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AlertService alertService;

    @Test
    //@DisplayName("When alert is requested, the api returns the correct alert level.")
    void getAlertAboutCountryTest_ShouldReturnRequestedContent() throws Exception {

        AlertStatus alertStatus = new AlertStatus();
        alertStatus.setAlertLevel(DashApiConstants.AlertLevels.GREEN.name());
        Mockito.when(alertService.getAlertStatusAboutCountry(ArgumentMatchers.anyString())).thenReturn(alertStatus);

        mockMvc.perform(get("/v1/dash/cov19/alerts/countries/India"))
                .andExpect(content().json("{\"alertLevel\":\"GREEN\",\"countryData\":{\"updated\":0,\"cases\":0,\"todayCases\":0,\"deaths\":0,\"todayDeaths\":0,\"recovered\":0,\"todayRecovered\":0,\"active\":0,\"critical\":0,\"casesPerOneMillion\":0.0,\"deathsPerOneMillion\":0.0,\"tests\":0,\"testsPerOneMillion\":0.0,\"population\":0,\"oneCasePerPeople\":0.0,\"oneDeathPerPeople\":0.0,\"oneTestPerPeople\":0.0,\"activePerOneMillion\":0.0,\"recoveredPerOneMillion\":0.0,\"criticalPerOneMillion\":0.0,\"affectedCountries\":0,\"country\":\"\",\"countryInfo\":{\"lat\":0.0,\"long\":0.0,\"iso2\":\"\",\"iso3\":\"\",\"_id\":0,\"flag\":\"\"},\"totalVaccinationCoverage\":0},\"measuresToBeTaken\":[]}"));
    }

}
