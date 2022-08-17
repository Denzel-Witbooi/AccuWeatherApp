package com.opsc7311.weatherapp.model;

public class HourlyForecast {
    private String IconPhrase;
    private int Value;
    private String Unit;

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }


    public int getValue() {
        return Value;
    }

    public void setValue(int value) {
        Value = value;
    }

    public String getIconPhrase() {
        return IconPhrase;
    }

    public void setIconPhrase(String iconPhrase) {
        IconPhrase = iconPhrase;
    }
}
