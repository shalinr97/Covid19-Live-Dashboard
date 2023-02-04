package com.example.covid19dashapi.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class StateData extends CovidApiData {

    private String state;

    public  StateData(){
        super();
        this.state = "";
    }

    public StateData(Long updated, Long cases, Long todayCases, Long deaths, Long todayDeaths, Long recovered, Long todayRecovered, Long active, Long critical, Double casesPerOneMillion, Double deathsPerOneMillion, Long tests, Double testsPerOneMillion, Long population, Double oneCasePerPeople, Double oneDeathPerPeople, Double oneTestPerPeople, Double activePerOneMillion, Double recoveredPerOneMillion, Double criticalPerOneMillion, Integer affectedCountries, String state) {
        super(updated, cases, todayCases, deaths, todayDeaths, recovered, todayRecovered, active, critical, casesPerOneMillion, deathsPerOneMillion, tests, testsPerOneMillion, population, oneCasePerPeople, oneDeathPerPeople, oneTestPerPeople, activePerOneMillion, recoveredPerOneMillion, criticalPerOneMillion, affectedCountries);
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return super.toString() + "StateData{" +
                "state='" + state + '\'' +
                '}';
    }
}
