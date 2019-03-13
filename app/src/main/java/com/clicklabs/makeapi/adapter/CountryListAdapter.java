package com.clicklabs.makeapi.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.clicklabs.makeapi.CountryModel;
import com.clicklabs.makeapi.R;

import java.util.ArrayList;

public class CountryListAdapter extends RecyclerView.Adapter<CountryListAdapter.CountryListViewHolder> {

    private ArrayList<CountryModel> countryList;
    private onItemClickListener mListener;


    public CountryListAdapter(ArrayList<CountryModel> mCountryList) {

        countryList=mCountryList;
    }

    @NonNull
    @Override
    public CountryListAdapter.CountryListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.country_name_container,viewGroup,false);

        CountryListViewHolder holder = new CountryListViewHolder(view,mListener);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CountryListAdapter.CountryListViewHolder countryListViewHolder, int i) {
        countryListViewHolder.tvCountryName.setText(countryList.get(i).getCountryName());
    }

    @Override
    public int getItemCount() {

        return countryList.size();
    }

    public class CountryListViewHolder extends RecyclerView.ViewHolder {
        TextView tvCountryName;

        public CountryListViewHolder(@NonNull View itemView, final onItemClickListener listener) {
            super(itemView);
            tvCountryName = itemView.findViewById(R.id.tvcountryName);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener!=null) {
                        int i = getAdapterPosition();
                        if(i !=RecyclerView.NO_POSITION) {
                            listener.onItemClick(i);
                        }
                    }
                }
            });
        }
    }

    public interface onItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(onItemClickListener listener) {
        mListener = listener;
    }
}
