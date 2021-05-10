package com.galvanize;

public class CellPhone {

    private final CallingCard callingCard;
    private boolean isTalking = false;
    private String phoneHistory = "";
    private int currentPhoneCallDuration = 0;
    private int totalElapsedMinutes = 0;

    public CellPhone(CallingCard card) {
        this.callingCard = card;
    }

    public CallingCard getCard() {
        return this.callingCard;
    }

    public boolean isTalking() {
        return isTalking;
    }

    public void call(String phoneNumber) {
        this.isTalking = true;
        this.currentPhoneCallDuration = 0;
        this.phoneHistory += " " + phoneNumber;
    }

    public void tick() {
        this.currentPhoneCallDuration++;
        this.totalElapsedMinutes++;
        if (this.totalElapsedMinutes >= callingCard.getRemainingMinutes()) {
            this.endCall();
        }
        callingCard.useMinutes(1);
    }

    public void endCall() {
        if (this.currentPhoneCallDuration > 1) {
            this.phoneHistory += String.format(" (%s minutes),", this.currentPhoneCallDuration);
        } else {
            this.phoneHistory += String.format(" (%s minute),", this.currentPhoneCallDuration);
        }
        this.currentPhoneCallDuration = 0;
        this.isTalking = false;
    }

    public String getHistory() {
        return this.phoneHistory.substring(1, this.phoneHistory.length() - 1);
    }
}
