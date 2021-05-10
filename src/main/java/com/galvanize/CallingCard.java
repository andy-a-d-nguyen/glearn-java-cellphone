package com.galvanize;

public class CallingCard {

    private final int costPerMinute;

    private int remainingMinutes;

    public CallingCard(int costPerMinute) {
        this.costPerMinute = costPerMinute;
    }

    public int getCostPerMinute() {
        return costPerMinute;
    }

    public void addDollars(int dollars) {
        this.remainingMinutes += dollars * 100 / costPerMinute;
    }

    public int getRemainingMinutes() {
        return this.remainingMinutes;
    }

    public void useMinutes(int minutes) {
        this.remainingMinutes = Math.max(this.remainingMinutes - minutes, 0);
    }
}
