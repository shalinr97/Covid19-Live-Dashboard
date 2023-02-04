package com.example.covid19dashapi.model;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AlertStatus {

    private String alertLevel; // Red, Yellow, Green

    private CountryData countryData;

    private List<String> measuresToBeTaken;

    public AlertStatus() {
        this.alertLevel = "";
        this.countryData = new CountryData();
        this.measuresToBeTaken = new List<String>() {
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

    public AlertStatus(String alertLevel, CountryData countryData, List<String> measuresToBeTaken) {
        this.alertLevel = alertLevel;
        this.countryData = countryData;
        this.measuresToBeTaken = measuresToBeTaken;
    }

    public CountryData getCountryData() {
        return countryData;
    }

    public void setCountryData(CountryData countryData) {
        this.countryData = countryData;
    }

    public String getAlertLevel() {
        return alertLevel;
    }

    public void setAlertLevel(String alertLevel) {
        this.alertLevel = alertLevel;
    }

    public List<String> getMeasuresToBeTaken() {
        return measuresToBeTaken;
    }

    public void setMeasuresToBeTaken(List<String> measuresToBeTaken) {
        this.measuresToBeTaken = measuresToBeTaken;
    }

}
