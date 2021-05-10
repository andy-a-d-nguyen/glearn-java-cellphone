package com.galvanize;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CallingCardTests {

    CallingCard card;

    @Test
    void initializeCallingCardTest() {
        card = new CallingCard(10);

        assertEquals(10, card.getCostPerMinute(), "should return cost per minute");
    }

    @Test
    void addMoneyTest() {
        card = new CallingCard(20);
        card.addDollars(1);

        assertEquals(5, card.getRemainingMinutes(), "should return remaining minutes");
    }

    @Test
    void useMinutesTest() {
        card = new CallingCard(20);
        card.addDollars(1);
        card.useMinutes(3);

        assertEquals(2, card.getRemainingMinutes(), "should return correct remaining minutes after use");
    }

    @Test
    void useMoreMinutesThanBalanceTest() {
        card = new CallingCard(5);
        card.addDollars(2);
        card.useMinutes(43);

        assertEquals(0, card.getRemainingMinutes(), "should return 0 if more minutes are used than are available");
    }

    @Test
    void ignoreDecimalsInBalanceCalculationTest() {
        card = new CallingCard(11);
        card.addDollars(3);

        assertEquals(27, card.getRemainingMinutes(), "should ignore decimals in balance calculation");
    }
}
