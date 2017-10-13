package com.example.yangxp.rheumatismweather.model;

/**
 * Author: Yang xp
 * Date: 2017/10/13
 * Time: 13:25
 * Desc：
 */

public class Api {

    private ApiCity city;

    public ApiCity getCity() {
        return city;
    }

    public void setCity(ApiCity city) {
        this.city = city;
    }

    public static class ApiCity{
        private String api;
        private String pm25;

        public String getApi() {
            return api;
        }

        public void setApi(String api) {
            this.api = api;
        }

        public String getPm25() {
            return pm25;
        }

        public void setPm25(String pm25) {
            this.pm25 = pm25;
        }
    }

}
