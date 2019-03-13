package com.clicklabs.makeapi;

import com.google.gson.annotations.SerializedName;

public class CountryModel {

    @SerializedName("name")
    private String countryName;

    public CountryModel(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }
}