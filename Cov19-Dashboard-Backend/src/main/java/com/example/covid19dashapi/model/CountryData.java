package com.example.covid19dashapi.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CountryData extends CovidApiData {

    private String country;
    private LocationInfo countryInfo;
    private Long totalVaccinationCoverage;

    public CountryData() {
        super();
        this.country = "";
        this.countryInfo = new LocationInfo();
        this.totalVaccinationCoverage = 0L;
    }

    public CountryData(Long updated, Long cases, Long todayCases, Long deaths, Long todayDeaths, Long recovered, Long todayRecovered, Long active, Long critical, Double casesPerOneMillion, Double deathsPerOneMillion, Long tests, Double testsPerOneMillion, Long population, Double oneCasePerPeople, Double oneDeathPerPeople, Double oneTestPerPeople, Double activePerOneMillion, Double recoveredPerOneMillion, Double criticalPerOneMillion, Integer affectedCountries, String country, LocationInfo countryInfo, Long totalVaccinationCoverage) {
        super(updated, cases, todayCases, deaths, todayDeaths, recovered, todayRecovered, active, critical, casesPerOneMillion, deathsPerOneMillion, tests, testsPerOneMillion, population, oneCasePerPeople, oneDeathPerPeople, oneTestPerPeople, activePerOneMillion, recoveredPerOneMillion, criticalPerOneMillion, affectedCountries);
        this.country = country;
        this.countryInfo = countryInfo;
        this.totalVaccinationCoverage = totalVaccinationCoverage;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocationInfo getCountryInfo() {
        return countryInfo;
    }

    public void setCountryInfo(LocationInfo countryInfo) {
        this.countryInfo = countryInfo;
    }

    public Long getTotalVaccinationCoverage() {
        return totalVaccinationCoverage;
    }

    public void setTotalVaccinationCoverage(Long totalVaccinationCoverage) {
        this.totalVaccinationCoverage = totalVaccinationCoverage;
    }
}
