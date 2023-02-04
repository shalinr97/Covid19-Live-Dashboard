package com.example.covid19dashapi.service;

import com.example.covid19dashapi.helper.DashApiConstants;
import com.example.covid19dashapi.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.sql.Struct;
import java.util.HashMap;
import java.util.Map;

@Service
public class Covid19DataProviderService {

    @Autowired
    RestTemplate restTemplate;

    public CovidApiData getGlobalCov19TotalsToday() {
        return restTemplate.getForObject(DashApiConstants.diseaseShApiUrl + "v3/covid-19/all", CovidApiData.class);
    }

    public StateData[] getCov19TotalsForAllUSStatesToday() {
        return restTemplate.getForObject(DashApiConstants.diseaseShApiUrl + "v3/covid-19/states", StateData[].class);
    }

    public ContinentData[] getCov19TotalsForAllContinentsToday() {
        return restTemplate.getForObject(DashApiConstants.diseaseShApiUrl + "v3/covid-19/continents", ContinentData[].class);
    }

    public CountryData[] getCov19TotalsForAllCountriesToday() {
        return restTemplate.getForObject(DashApiConstants.diseaseShApiUrl + "v3/covid-19/countries", CountryData[].class);
    }

    public CountryData getCov19TotalsForCountriesToday(String country) {
        Map<String, String> vars = new HashMap<>();
        vars.put("country", country);
        return restTemplate.getForObject(DashApiConstants.diseaseShApiUrl + "v3/covid-19/countries/{country}", CountryData.class, vars);
    }

    public VaccineCoverageData[] getCov19VaccineCoverageForAllCountriesToday(String lastDays) {
        Map<String, String> vars = new HashMap<>();
        vars.put("lastdays", lastDays);
        return restTemplate.getForObject(DashApiConstants.diseaseShApiUrl + "v3/covid-19/vaccine/coverage/countries?lastdays={lastdays}", VaccineCoverageData[].class, vars);
    }

    public VaccineCoverageData getCov19VaccineCoverageForCountriesToday(String lastDays, String country) {
        Map<String, String> vars = new HashMap<>();
        vars.put("lastdays", lastDays);
        vars.put("country", country);
        return restTemplate.getForObject(DashApiConstants.diseaseShApiUrl + "v3/covid-19/vaccine/coverage/countries/{country}?lastdays={lastdays}", VaccineCoverageData.class, vars);
    }

    public Map<String, Long> getCov19VaccineCoverageForAllToday(String lastDays) {
        Map<String, String> vars = new HashMap<>();
        vars.put("lastdays", lastDays);
        return restTemplate.getForObject(DashApiConstants.diseaseShApiUrl + "v3/covid-19/vaccine/coverage?lastdays={lastdays}", Map.class, vars);
    }
}
