package com.sahay.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;

@Service
@Slf4j
public class NbeService {


    @Value("${nbe.url}")
    private String NBE_URL;

    public ResponseEntity<?> getBalancesForNBE() {

        try {
            RestTemplate restTemplate = new RestTemplate();

            ResponseEntity<Object> report = restTemplate.getForEntity(
                    NBE_URL, Object.class
            );
            log.info("NBE report : {}", report);

            return new ResponseEntity<>(report, HttpStatus.OK);
        } catch (Exception e) {
            log.error("error occurred : {}", e.getMessage());
            return new ResponseEntity<>("Error!, Please try again", HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }


}
