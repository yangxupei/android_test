package com.example.yangxp.rheumatismweather.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Author: Yang xp
 * Date: 2017/10/13
 * Time: 15:29
 * Desc：
 */

public class Weather {

    private String status;

    @SerializedName("basic")
    private Base base;

    private Api api;

    private Now now;

    private Suggestion suggestion;

    @SerializedName("daily_forecast")
    private List<Forecast> forecastList;

//    @SerializedName("hourly_forecast")
//    private List<Forecast> forecasts;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Base getBase() {
        return base;
    }

    public void setBase(Base base) {
        this.base = base;
    }

    public Api getApi() {
        return api;
    }

    public void setApi(Api api) {
        this.api = api;
    }

    public Now getNow() {
        return now;
    }

    public void setNow(Now now) {
        this.now = now;
    }

    public Suggestion getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(Suggestion suggestion) {
        this.suggestion = suggestion;
    }

    public List<Forecast> getForecastList() {
        return forecastList;
    }

    public void setForecastList(List<Forecast> forecastList) {
        this.forecastList = forecastList;
    }

//    public List<Forecast> getForecasts() {
//        return forecasts;
//    }
//
//    public void setForecasts(List<Forecast> forecasts) {
//        this.forecasts = forecasts;
//    }
}
