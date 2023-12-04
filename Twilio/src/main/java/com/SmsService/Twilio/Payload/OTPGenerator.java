package com.SmsService.Twilio.Payload;
import java.util.Random;

public class OTPGenerator {

    public static String generateOTP(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("OTP length must be greater than 0");
        }

        // Define the character set for the OTP
        String characters = "0123456789";
        StringBuilder otp = new StringBuilder();

        // Use a secure random number generator
        Random random = new Random();

        // Build the OTP with random characters from the character set
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            otp.append(characters.charAt(index));
        }

        return otp.toString();
    }
}
