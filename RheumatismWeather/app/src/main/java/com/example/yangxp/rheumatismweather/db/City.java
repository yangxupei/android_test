package com.example.yangxp.rheumatismweather.db;

import org.litepal.crud.DataSupport;

/**
 * Author: Yang xp
 * Date: 2017/10/12
 * Time: 17:13
 * Desc：市
 */
public class City extends DataSupport {

    private int id;
    /**
     * 市名称
     */
    private String cityName;

    /**
     * 市代码
     */
    private int cityCode;

    /**
     * 省份id
     */
    private int provinceId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getCityCode() {
        return cityCode;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }
}
