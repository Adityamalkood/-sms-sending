package com.SmsService.Twilio.Controller;
import com.SmsService.Twilio.Payload.OTPGenerator;
import com.SmsService.Twilio.Payload.OTPRequest;
import com.SmsService.Twilio.Payload.VerifyOTPRequest;
import com.SmsService.Twilio.Service.SMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class OTPController {

    @Autowired
    private SMSService smsService;
    // Assume the generated OTP is stored in a map with phone numbers as keys
    private Map<String, String> otpMap = new HashMap<>();

    @PostMapping("/send-otp")
    public String sendOTP(@RequestBody OTPRequest otpRequest) {
        String phoneNumber = otpRequest.getPhoneNumber();

        // Generate OTP
        String otp = OTPGenerator.generateOTP(6); // You can adjust the length as needed

        // Store the OTP in the map with the phone number
        otpMap.put(phoneNumber, otp);

        // Send SMS with OTP
        smsService.sendSMS(phoneNumber, "Your OTP is: " + otp);

        return "OTP sent successfully";
    }

    @PostMapping("/verify-otp")
    public String verifyOTP(@RequestBody VerifyOTPRequest verifyOTPRequest) {
        String phoneNumber = verifyOTPRequest.getPhoneNumber();
        String enteredOTP = verifyOTPRequest.getEnteredOTP();

        // Get the stored OTP for the phone number
        String storedOTP = otpMap.get(phoneNumber);

        if (storedOTP != null && storedOTP.equals(enteredOTP)) {
            // OTP is valid, perform further actions (e.g., user authentication)
            return "OTP is valid";
        } else {
            // Invalid OTP
            return "Invalid OTP";
        }
    }
}