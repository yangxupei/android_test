package com.example.yangxp.rheumatismweather.db;

import org.litepal.crud.DataSupport;

/**
 * Author: Yang xp
 * Date: 2017/10/12
 * Time: 17:16
 * Desc：县
 */

public class County extends DataSupport {

    private int id;
    private String countyName;
    /**
     * 天气id
     */
    private String weatherId;
    private int cityId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public String getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(String weatherId) {
        this.weatherId = weatherId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
}
