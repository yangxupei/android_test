package com.example.yangxp.rheumatismweather.model;

import com.google.gson.annotations.SerializedName;

/**
 * Author: Yang xp
 * Date: 2017/10/13
 * Time: 13:39
 * Desc：
 */

public class Forecast {


    @SerializedName("astro")
    private Astronomical astronomical;

    private Cond cond;

    private String date;
    private String hum;
    private String pcpn;
    private String pop;
    private String pres;
    @SerializedName("tmp")
    private Temperature tmp;
    private String uv;
    private String vis;
    private Wind wind;

    public Astronomical getAstronomical() {
        return astronomical;
    }

    public void setAstronomical(Astronomical astronomical) {
        this.astronomical = astronomical;
    }

    public Cond getCond() {
        return cond;
    }

    public void setCond(Cond cond) {
        this.cond = cond;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHum() {
        return hum;
    }

    public void setHum(String hum) {
        this.hum = hum;
    }

    public String getPcpn() {
        return pcpn;
    }

    public void setPcpn(String pcpn) {
        this.pcpn = pcpn;
    }

    public String getPop() {
        return pop;
    }

    public void setPop(String pop) {
        this.pop = pop;
    }

    public String getPres() {
        return pres;
    }

    public void setPres(String pres) {
        this.pres = pres;
    }

    public Temperature getTmp() {
        return tmp;
    }

    public void setTmp(Temperature tmp) {
        this.tmp = tmp;
    }

    public String getUv() {
        return uv;
    }

    public void setUv(String uv) {
        this.uv = uv;
    }

    public String getVis() {
        return vis;
    }

    public void setVis(String vis) {
        this.vis = vis;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public static class Wind{
        @SerializedName("dir")
        private String direction;
        @SerializedName("deg")
        private String power;
        @SerializedName("sc")
        private String powerGrade;
        @SerializedName("spd")
        private String speed;

        public String getDirection() {
            return direction;
        }

        public void setDirection(String direction) {
            this.direction = direction;
        }

        public String getPower() {
            return power;
        }

        public void setPower(String power) {
            this.power = power;
        }

        public String getPowerGrade() {
            return powerGrade;
        }

        public void setPowerGrade(String powerGrade) {
            this.powerGrade = powerGrade;
        }

        public String getSpeed() {
            return speed;
        }

        public void setSpeed(String speed) {
            this.speed = speed;
        }
    }

    public static class Temperature{
        private String max;
        private String min;

        public String getMax() {
            return max;
        }

        public void setMax(String max) {
            this.max = max;
        }

        public String getMin() {
            return min;
        }

        public void setMin(String min) {
            this.min = min;
        }
    }

    public static class Cond{
        @SerializedName("code_d")
        private String codeDay;
        @SerializedName("code_n")
        private String codeNight;
        @SerializedName("txt_d")
        private String infoDay;
        @SerializedName("txt_n")
        private String infoNight;

        public String getCodeDay() {
            return codeDay;
        }

        public void setCodeDay(String codeDay) {
            this.codeDay = codeDay;
        }

        public String getCodeNight() {
            return codeNight;
        }

        public void setCodeNight(String codeNight) {
            this.codeNight = codeNight;
        }

        public String getInfoDay() {
            return infoDay;
        }

        public void setInfoDay(String infoDay) {
            this.infoDay = infoDay;
        }

        public String getInfoNight() {
            return infoNight;
        }

        public void setInfoNight(String infoNight) {
            this.infoNight = infoNight;
        }
    }

    public static class Astronomical{
        /**
         * 月出
         */
        @SerializedName("mr")
        private String moonRise;
        /**
         * 日落
         */
        @SerializedName("ms")
        private String moonSwoop;
        /**
         * 日出
         */
        @SerializedName("sr")
        private String sunRise;
        /**
         * 日落
         */
        @SerializedName("ss")
        private String sunSwoop;

        public String getMoonRise() {
            return moonRise;
        }

        public void setMoonRise(String moonRise) {
            this.moonRise = moonRise;
        }

        public String getMoonSwoop() {
            return moonSwoop;
        }

        public void setMoonSwoop(String moonSwoop) {
            this.moonSwoop = moonSwoop;
        }

        public String getSunRise() {
            return sunRise;
        }

        public void setSunRise(String sunRise) {
            this.sunRise = sunRise;
        }

        public String getSunSwoop() {
            return sunSwoop;
        }

        public void setSunSwoop(String sunSwoop) {
            this.sunSwoop = sunSwoop;
        }
    }


}
