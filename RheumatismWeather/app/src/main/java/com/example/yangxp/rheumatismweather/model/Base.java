package com.example.yangxp.rheumatismweather.model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/**
 * Author: Yang xp
 * Date: 2017/10/13
 * Time: 11:34
 * Desc：天气解析基础类
 */

public class Base {

    @SerializedName("city")
    private String cityName;

    @SerializedName("id")
    private String weatherId;

    private Update update;

    public Update getUpdate() {
        return update;
    }

    public void setUpdate(Update update) {
        this.update = update;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(String weatherId) {
        this.weatherId = weatherId;
    }

    public static class Update{
        @SerializedName("loc")
        private String updateTime;

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }
    }


}
