package com.example.covid19dashapi.model;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class VaccineCoverageData {

    private String country;
    private Map<String, Long> timeline;

    public  VaccineCoverageData(){
        this.country = "";
        this.timeline = new Map<String, Long>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean containsKey(Object key) {
                return false;
            }

            @Override
            public boolean containsValue(Object value) {
                return false;
            }

            @Override
            public Long get(Object key) {
                return null;
            }

            @Override
            public Long put(String key, Long value) {
                return null;
            }

            @Override
            public Long remove(Object key) {
                return null;
            }

            @Override
            public void putAll(Map<? extends String, ? extends Long> m) {

            }

            @Override
            public void clear() {

            }

            @Override
            public Set<String> keySet() {
                return null;
            }

            @Override
            public Collection<Long> values() {
                return null;
            }

            @Override
            public Set<Entry<String, Long>> entrySet() {
                return null;
            }
        };
    }

    public VaccineCoverageData(String country, Map<String, Long> timeline) {
        this.country = country;
        this.timeline = timeline;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Map<String, Long> getTimeline() {
        return timeline;
    }

    public void setTimeline(Map<String, Long> timeline) {
        this.timeline = timeline;
    }
}
