package com.example.sandeep.transferservice.model;

public class LimitModel {
    private int maxLimit;
    private int minLimit;
    private int dailyMaxLimit;

    public LimitModel() {
    }

    public LimitModel(int maxLimit, int minLimit, int dailyMaxLimit) {
        this.maxLimit = maxLimit;
        this.minLimit = minLimit;
        this.dailyMaxLimit = dailyMaxLimit;
    }

    public int getMaxLimit() {
        return maxLimit;
    }

    public void setMaxLimit(int maxLimit) {
        this.maxLimit = maxLimit;
    }

    public int getMinLimit() {
        return minLimit;
    }

    public void setMinLimit(int minLimit) {
        this.minLimit = minLimit;
    }

    public int getDailyMaxLimit() {
        return dailyMaxLimit;
    }

    public void setDailyMaxLimit(int dailyMaxLimit) {
        this.dailyMaxLimit = dailyMaxLimit;
    }
}
