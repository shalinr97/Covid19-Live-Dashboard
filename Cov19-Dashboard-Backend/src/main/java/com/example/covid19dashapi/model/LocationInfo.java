package com.example.covid19dashapi.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LocationInfo {

    @JsonProperty("lat")
    private Double latitude;

    @JsonProperty("long")
    private Double longitude;

    private String iso2;
    private String iso3;
    private Long _id;
    private String flag;

    public LocationInfo() {
        this.latitude = 0D;
        this.longitude = 0D;
        this.iso2 = "";
        this.iso3 = "";
        this._id = 0L;
        this.flag = "";
    }

    public LocationInfo(Double latitude, Double longitude, String iso2, String iso3, Long _id, String flag) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.iso2 = iso2;
        this.iso3 = iso3;
        this._id = _id;
        this.flag = flag;
    }

    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }

    public String getIso3() {
        return iso3;
    }

    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double Longitude) {
        this.longitude = Longitude;
    }
}
