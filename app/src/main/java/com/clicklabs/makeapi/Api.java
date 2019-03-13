package com.clicklabs.makeapi;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "https://restcountries.eu/rest/v2/";

    @GET("all?fields=name")
    Call<ArrayList<CountryModel>> getCountryName();
}