package com.example.covid19dashapi.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CovidApiData {
    private Long updated;
    private Long cases;
    private Long todayCases;
    private Long deaths;
    private Long todayDeaths;
    private Long recovered;
    private Long todayRecovered;
    private Long active;
    private Long critical;
    private Double casesPerOneMillion;
    private Double deathsPerOneMillion;
    private Long tests;
    private Double testsPerOneMillion;
    private Long population;
    private Double oneCasePerPeople;
    private Double oneDeathPerPeople;
    private Double oneTestPerPeople;
    private Double activePerOneMillion;
    private Double recoveredPerOneMillion;
    private Double criticalPerOneMillion;
    private Integer affectedCountries;

    public Integer getAffectedCountries() {
        return affectedCountries;
    }

    public void setAffectedCountries(Integer affectedCountries) {
        this.affectedCountries = affectedCountries;
    }

    public CovidApiData() {
        this.updated = 0L;
        this.cases = 0L;
        this.todayCases = 0L;
        this.deaths = 0L;
        this.todayDeaths = 0L;
        this.recovered = 0L;
        this.todayRecovered = 0L;
        this.active = 0L;
        this.critical = 0L;
        this.casesPerOneMillion = 0D;
        this.deathsPerOneMillion = 0D;
        this.tests = 0L;
        this.testsPerOneMillion = 0D;
        this.population = 0L;
        this.oneCasePerPeople = 0D;
        this.oneDeathPerPeople = 0D;
        this.oneTestPerPeople = 0D;
        this.activePerOneMillion = 0D;
        this.recoveredPerOneMillion = 0D;
        this.criticalPerOneMillion = 0D;
        this.affectedCountries = 0;
    }

    public CovidApiData(Long updated, Long cases, Long todayCases, Long deaths, Long todayDeaths, Long recovered, Long todayRecovered, Long active, Long critical, Double casesPerOneMillion, Double deathsPerOneMillion, Long tests, Double testsPerOneMillion, Long population, Double oneCasePerPeople, Double oneDeathPerPeople, Double oneTestPerPeople, Double activePerOneMillion, Double recoveredPerOneMillion, Double criticalPerOneMillion, Integer affectedCountries) {
        this.updated = updated;
        this.cases = cases;
        this.todayCases = todayCases;
        this.deaths = deaths;
        this.todayDeaths = todayDeaths;
        this.recovered = recovered;
        this.todayRecovered = todayRecovered;
        this.active = active;
        this.critical = critical;
        this.casesPerOneMillion = casesPerOneMillion;
        this.deathsPerOneMillion = deathsPerOneMillion;
        this.tests = tests;
        this.testsPerOneMillion = testsPerOneMillion;
        this.population = population;
        this.oneCasePerPeople = oneCasePerPeople;
        this.oneDeathPerPeople = oneDeathPerPeople;
        this.oneTestPerPeople = oneTestPerPeople;
        this.activePerOneMillion = activePerOneMillion;
        this.recoveredPerOneMillion = recoveredPerOneMillion;
        this.criticalPerOneMillion = criticalPerOneMillion;
        this.affectedCountries = affectedCountries;
    }

    public Long getUpdated() {
        return updated;
    }

    public void setUpdated(Long updated) {
        this.updated = updated;
    }

    public Long getCases() {
        return cases;
    }

    public void setCases(Long cases) {
        this.cases = cases;
    }

    public Long getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(Long todayCases) {
        this.todayCases = todayCases;
    }

    public Long getDeaths() {
        return deaths;
    }

    public void setDeaths(Long deaths) {
        this.deaths = deaths;
    }

    public Long getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(Long todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public Long getRecovered() {
        return recovered;
    }

    public void setRecovered(Long recovered) {
        this.recovered = recovered;
    }

    public Long getTodayRecovered() {
        return todayRecovered;
    }

    public void setTodayRecovered(Long todayRecovered) {
        this.todayRecovered = todayRecovered;
    }

    public Long getActive() {
        return active;
    }

    public void setActive(Long active) {
        this.active = active;
    }

    public Long getCritical() {
        return critical;
    }

    public void setCritical(Long critical) {
        this.critical = critical;
    }

    public Double getCasesPerOneMillion() {
        return casesPerOneMillion;
    }

    public void setCasesPerOneMillion(Double casesPerOneMillion) {
        this.casesPerOneMillion = casesPerOneMillion;
    }

    public Double getDeathsPerOneMillion() {
        return deathsPerOneMillion;
    }

    public void setDeathsPerOneMillion(Double deathsPerOneMillion) {
        this.deathsPerOneMillion = deathsPerOneMillion;
    }

    public Long getTests() {
        return tests;
    }

    public void setTests(Long tests) {
        this.tests = tests;
    }

    public Double getTestsPerOneMillion() {
        return testsPerOneMillion;
    }

    public void setTestsPerOneMillion(Double testsPerOneMillion) {
        this.testsPerOneMillion = testsPerOneMillion;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Double getOneCasePerPeople() {
        return oneCasePerPeople;
    }

    public void setOneCasePerPeople(Double oneCasePerPeople) {
        this.oneCasePerPeople = oneCasePerPeople;
    }

    public Double getOneDeathPerPeople() {
        return oneDeathPerPeople;
    }

    public void setOneDeathPerPeople(Double oneDeathPerPeople) {
        this.oneDeathPerPeople = oneDeathPerPeople;
    }

    public Double getOneTestPerPeople() {
        return oneTestPerPeople;
    }

    public void setOneTestPerPeople(Double oneTestPerPeople) {
        this.oneTestPerPeople = oneTestPerPeople;
    }

    public Double getActivePerOneMillion() {
        return activePerOneMillion;
    }

    public void setActivePerOneMillion(Double activePerOneMillion) {
        this.activePerOneMillion = activePerOneMillion;
    }

    public Double getRecoveredPerOneMillion() {
        return recoveredPerOneMillion;
    }

    public void setRecoveredPerOneMillion(Double recoveredPerOneMillion) {
        this.recoveredPerOneMillion = recoveredPerOneMillion;
    }

    public Double getCriticalPerOneMillion() {
        return criticalPerOneMillion;
    }

    public void setCriticalPerOneMillion(Double criticalPerOneMillion) {
        this.criticalPerOneMillion = criticalPerOneMillion;
    }

    @Override
    public String toString() {
        return "CovidApiData{" +
                "updated=" + updated +
                ", cases=" + cases +
                ", todayCases=" + todayCases +
                ", deaths=" + deaths +
                ", todayDeaths=" + todayDeaths +
                ", recovered=" + recovered +
                ", todayRecovered=" + todayRecovered +
                ", active=" + active +
                ", critical=" + critical +
                ", casesPerOneMillion=" + casesPerOneMillion +
                ", deathsPerOneMillion=" + deathsPerOneMillion +
                ", tests=" + tests +
                ", testsPerOneMillion=" + testsPerOneMillion +
                ", population=" + population +
                ", oneCasePerPeople=" + oneCasePerPeople +
                ", oneDeathPerPeople=" + oneDeathPerPeople +
                ", oneTestPerPeople=" + oneTestPerPeople +
                ", activePerOneMillion=" + activePerOneMillion +
                ", recoveredPerOneMillion=" + recoveredPerOneMillion +
                ", criticalPerOneMillion=" + criticalPerOneMillion +
                ", affectedCountries=" + affectedCountries +
                '}';
    }
}
