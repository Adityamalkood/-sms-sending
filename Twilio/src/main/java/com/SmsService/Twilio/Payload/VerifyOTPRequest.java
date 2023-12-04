package com.SmsService.Twilio.Payload;
public class VerifyOTPRequest {

    private String phoneNumber;
    private String enteredOTP;

    // Constructors, getter, and setter methods

    public VerifyOTPRequest() {
        // Default constructor
    }

    public VerifyOTPRequest(String phoneNumber, String enteredOTP) {
        this.phoneNumber = phoneNumber;
        this.enteredOTP = enteredOTP;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEnteredOTP() {
        return enteredOTP;
    }

    public void setEnteredOTP(String enteredOTP) {
        this.enteredOTP = enteredOTP;
    }
}
