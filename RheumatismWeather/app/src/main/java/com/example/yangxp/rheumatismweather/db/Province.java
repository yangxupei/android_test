package com.example.yangxp.rheumatismweather.db;

import org.litepal.crud.DataSupport;

public class Province extends DataSupport {

    /**
     * id
     */
    private int id;
    /**
     * 省名称
     */
    private String provinceName;

    /**
     * 省代码
     */
    private int provinceCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public int getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(int provinceCode) {
        this.provinceCode = provinceCode;
    }
}
