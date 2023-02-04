package com.example.covid19dashapi.MockData;

import com.example.covid19dashapi.model.*;

public final class CovidApiMockData {
     public static StateData[] getCovid19AllStateMockData(){
        StateData[] stateData = new StateData[2];
        stateData[0] = new StateData();
        stateData[0].setState("California");
        stateData[1] = new StateData();
        stateData[1].setState("Florida");
        return stateData;
    }

    public static CountryData[] getCovid19AllCountryMockData(){
        CountryData[] countryData = new CountryData[2];
        countryData[0] = new CountryData();
        countryData[1] = new CountryData();
        countryData[0].setCountry("India");
        countryData[1].setCountry("United States of America");
        return countryData;
    }

    public static CountryData getCovid19CountryMockData(){
        CountryData countryData = new CountryData();
        countryData.setCountry("India");
        return countryData;
    }

    public static CovidApiData getCovid19GlobalMockData(){
        CovidApiData covidApiData = new CovidApiData();
        covidApiData.setCases(1237464633993L);
        return covidApiData;
    }

    public static ContinentData[] getCovid19AllContinentMockData(){
        ContinentData[] continentData = new ContinentData[2];
        continentData[0] = new ContinentData();
        continentData[1] = new ContinentData();
        continentData[0].setContinent("Asia");
        continentData[1].setContinent("Russia");
        return  continentData;
    }

    public static VaccineCoverageData[] getCovid19VaccineCoverageAllCountryMockData(){
        VaccineCoverageData[] vaccineCoverageData = new VaccineCoverageData[2];
        vaccineCoverageData[0] = new VaccineCoverageData();
        vaccineCoverageData[1] = new VaccineCoverageData();

        vaccineCoverageData[0].setCountry("India");
        vaccineCoverageData[1].setCountry("United States of America");
        return vaccineCoverageData;
    }

    public static VaccineCoverageData getCovid19VaccineCoverageCountryMockData(){
        VaccineCoverageData vaccineCoverageData = new VaccineCoverageData();
        vaccineCoverageData.setCountry("India");
        return vaccineCoverageData;
    }
}
