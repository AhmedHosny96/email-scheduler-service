package com.sahay.services;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import java.io.ByteArrayInputStream;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Service
@Slf4j
public class SchedulerService {

    @Value("${ethiopianAirline.email1}")
    private String webSupportMail;

    @Value("${ethiopianAirline.email2}")
    private String payAtBankMail;

    @Value("${ethiopianAirline.email3}")
    private String itServiceDeskMail;

    private final EthiopianAirlineService ethiopianAirlineService;

    private final NbeService nbeService;

    private final MailSenderService mailSenderService;

    // TODO: ETHIOPIAN AIRLINE EMAIL FOR EVERY 30 MIN

    @Scheduled(fixedRate = 30, timeUnit = TimeUnit.MINUTES)
    public void sendToEthiopianAirline()  {

        ByteArrayInputStream payload = ethiopianAirlineService.fetchLastTranx();

        if (payload != null) {
        try {
            mailSenderService.sendMail(
                     webSupportMail + "," + payAtBankMail + "," + itServiceDeskMail,
                    "Ethiopian airline tickets purchased via sahay ",
                    "Successfully issued tickets for the last 30 minutes ",
                    payload
            );
            log.info("Email send  to ethiopian airlines : {}");

        } catch (Exception exception) {
            log.error("Error occurred while sending email to ethiopian airlines : {}", exception.getMessage());
        }

        } else {
            log.info("Email not sent , no ethiopian airline ticket for the last 30 min : {}");

        }

    }

    // TODO: NATION BANK FOR EVERYDAY @8:30 AM

    @Scheduled(cron = "0 30 8 ? * *")
    public void sendToNBE() {
        nbeService.getBalancesForNBE();
    }


    //TODO: SHEWA SUPER MARKET EVERYDAY @12:00 AM


    //TODO: AGENT COMMMISION RELEASE , EVERY FRIDAY @ 2:00 PM


}
