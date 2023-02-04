package com.example.covid19dashapi.model;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContinentData extends CovidApiData {

    private String continent;
    private LocationInfo continentInfo;
    private List<String> countries;

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public ContinentData() {
        super();
        this.continent = "";
        this.continentInfo = new LocationInfo();
        this.countries = new List<String>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<String> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(String s) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends String> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends String> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public String get(int index) {
                return null;
            }

            @Override
            public String set(int index, String element) {
                return null;
            }

            @Override
            public void add(int index, String element) {

            }

            @Override
            public String remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<String> listIterator() {
                return null;
            }

            @Override
            public ListIterator<String> listIterator(int index) {
                return null;
            }

            @Override
            public List<String> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
    }

    public ContinentData(Long updated, Long cases, Long todayCases, Long deaths, Long todayDeaths, Long recovered, Long todayRecovered, Long active, Long critical, Double casesPerOneMillion, Double deathsPerOneMillion, Long tests, Double testsPerOneMillion, Long population, Double oneCasePerPeople, Double oneDeathPerPeople, Double oneTestPerPeople, Double activePerOneMillion, Double recoveredPerOneMillion, Double criticalPerOneMillion, Integer affectedCountries, String continent, LocationInfo continentInfo, List<String> countries) {
        super(updated, cases, todayCases, deaths, todayDeaths, recovered, todayRecovered, active, critical, casesPerOneMillion, deathsPerOneMillion, tests, testsPerOneMillion, population, oneCasePerPeople, oneDeathPerPeople, oneTestPerPeople, activePerOneMillion, recoveredPerOneMillion, criticalPerOneMillion, affectedCountries);
        this.continent = continent;
        this.continentInfo = continentInfo;
        this.countries = countries;
    }

    public LocationInfo getContinentInfo() {
        return continentInfo;
    }

    public void setContinentInfo(LocationInfo continentInfo) {
        this.continentInfo = continentInfo;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    @Override
    public String toString() {
        return "ContinentData{" +
                "continentInfo=" + continentInfo +
                ", countries=" + countries +
                '}';
    }
}
