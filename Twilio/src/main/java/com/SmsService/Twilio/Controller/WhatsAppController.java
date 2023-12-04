package com.SmsService.Twilio.Controller;
import com.SmsService.Twilio.Payload.MessageRequest;
import com.SmsService.Twilio.Service.TwilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WhatsAppController {

    private final TwilioService twilioService;

    @Autowired
    public WhatsAppController(TwilioService twilioService) {
        this.twilioService = twilioService;
    }

    @PostMapping("/send-whatsapp")
    public void sendWhatsAppMessage(@RequestBody MessageRequest request) {
        try {
            twilioService.sendWhatsAppMessage(request.getTo(), request.getMessage());
        } catch (Exception e) {
            // Log the exception details
            e.printStackTrace();
            // Handle the exception appropriately (e.g., return an error response to the client)
        }

    }
}