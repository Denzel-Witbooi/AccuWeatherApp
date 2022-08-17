package com.opsc7311.weatherapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.opsc7311.weatherapp.R;
import com.opsc7311.weatherapp.model.HourlyForecast;

import java.util.ArrayList;

public class HourlyForecastAdapter extends ArrayAdapter<HourlyForecast> {


    public HourlyForecastAdapter(@NonNull Context context, ArrayList<HourlyForecast> hourlyForecastArrayList) {
        super(context, 0, hourlyForecastArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        HourlyForecast hourlyForecast = getItem(position);
        Context context;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.hourly_forecast_items, parent, false);
        }

        TextView iconPhrase = convertView.findViewById(R.id.txt_rain_or_sun);
        TextView temperature = convertView.findViewById(R.id.txt_temp);
        TextView unit = convertView.findViewById(R.id.txt_unit);

        iconPhrase.setText(hourlyForecast.getIconPhrase());
        temperature.setText(String.valueOf(hourlyForecast.getValue()));
        unit.setText(hourlyForecast.getUnit());

        context = convertView.getContext();

        return convertView;
    }
}
