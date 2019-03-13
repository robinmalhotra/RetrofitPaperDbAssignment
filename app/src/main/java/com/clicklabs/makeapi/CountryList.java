package com.clicklabs.makeapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CountryList extends AppCompatActivity {

    private RecyclerView rvCountryList;
    private ArrayList<CountryModel> mCountryList;
    private CountryListAdapter mCountryListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_list);
        rvCountryList = findViewById(R.id.rvCountryList);
        rvCountryList.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvCountryList.setLayoutManager(linearLayoutManager);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<ArrayList<CountryModel>> call = api.getCountryName();
        call.enqueue(new Callback<ArrayList<CountryModel>>() {
            @Override
            public void onResponse(Call<ArrayList<CountryModel>> call, Response<ArrayList<CountryModel>> response) {
             mCountryList = response.body();
             rvCountryList.setAdapter(new CountryListAdapter(mCountryList));
            }

            @Override
            public void onFailure(Call<ArrayList<CountryModel>> call, Throwable t) {
                Log.d("Failure","not Working");
            }
        });
    }
}
