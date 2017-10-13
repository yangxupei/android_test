package com.example.yangxp.rheumatismweather.model;

import com.google.gson.annotations.SerializedName;

/**
 * Author: Yang xp
 * Date: 2017/10/13
 * Time: 13:29
 * Desc：
 */

public class Suggestion {

    @SerializedName("cw")
    private CarWash carWash;

    @SerializedName("comf")
    private Comfort comfort;

    private Sport sport;

    public CarWash getCarWash() {
        return carWash;
    }

    public void setCarWash(CarWash carWash) {
        this.carWash = carWash;
    }

    public Comfort getComfort() {
        return comfort;
    }

    public void setComfort(Comfort comfort) {
        this.comfort = comfort;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public static class CarWash{
        @SerializedName("txt")
        private String info;

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }

    public static class  Sport{
        @SerializedName("txt")
        private String info;

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }

    public static class Comfort{

        @SerializedName("txt")
        private String info;

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }

}
