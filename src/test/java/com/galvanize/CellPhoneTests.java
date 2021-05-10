package com.galvanize;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellPhoneTests {

    CallingCard card;
    CellPhone phone;

    @Test
    void initializeCellPhoneTest() {
        card = new CallingCard(10);
        card.addDollars(1);

        phone = new CellPhone(card);

        assertEquals(card, phone.getCard(), "should initialize a cell phone with a calling card");
    }

    @Test
    void checkForActiveCallTest() {
        card = new CallingCard(10);
        card.addDollars(1);
        phone = new CellPhone(card);

        assertFalse(phone.isTalking(), "should return false when no call is being made");

        phone.call("555-1212");

        assertTrue(phone.isTalking(), "should return true when call is being made");

        phone.tick();

        phone.endCall();

        assertFalse(phone.isTalking(), "should return false when call has ended");
    }

    @Test
    void checkRemainingMinutesTest() {
        card = new CallingCard(10);
        card.addDollars(1);
        phone = new CellPhone(card);
        phone.call("555-1212");
        phone.tick();
        phone.tick();
        phone.endCall();

        assertEquals(8, card.getRemainingMinutes(), "should return correct remaining minutes");
    }

    @Test
    void checkPhoneHistoryTest() {
        card = new CallingCard(10);
        card.addDollars(1);
        phone = new CellPhone(card);
        phone.call("555-1111");
        phone.tick();
        phone.endCall();

        phone.call("555-2222");
        phone.tick();
        phone.tick();
        phone.endCall();

        assertEquals("555-1111 (1 minute), 555-2222 (2 minutes)", phone.getHistory(), "should return phone history");
    }

    @Test
    void checkBalanceWhileCallingTest() {
        card = new CallingCard(20);
        card.addDollars(1);
        phone = new CellPhone(card);

        phone.call("555-1111");
        phone.tick();
        phone.tick();
        phone.endCall();

        phone.call("555-3333");
        phone.tick();
        phone.tick();
        phone.tick();

        assertFalse(phone.isTalking(), "should return false when card has no balance");

        assertEquals(0, card.getRemainingMinutes(), "should return 0 when all minutes is used up");
    }
}
