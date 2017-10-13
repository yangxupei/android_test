package com.example.yangxp.rheumatismweather.model;

/**
 * Author: Yang xp
 * Date: 2017/10/13
 * Time: 13:27
 * Desc：当前
 */

public class Now {

    private String tmp;

    private Cond cond;

    public String getTmp() {
        return tmp;
    }

    public void setTmp(String tmp) {
        this.tmp = tmp;
    }

    public Cond getCond() {
        return cond;
    }

    public void setCond(Cond cond) {
        this.cond = cond;
    }

    public static class Cond{
        private String txt;

        public String getTxt() {
            return txt;
        }

        public void setTxt(String txt) {
            this.txt = txt;
        }
    }

}
