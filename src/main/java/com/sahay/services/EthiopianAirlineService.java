package com.sahay.services;

import com.sahay.entity.EthiopianAirline;
import com.sahay.repository.EthiopianAirlineRepository;
import com.sahay.util.CsvGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.util.List;

@RequiredArgsConstructor
@Service
public class EthiopianAirlineService {

    private final EthiopianAirlineRepository airlineRepository;

    private final CsvGenerator csvGenerator;


    public ByteArrayInputStream fetchLastTranx() {

        List<EthiopianAirline> ethiopianAirlinesLastTranx = airlineRepository.findEthiopianAirlinesLastTranx();

        if (!ethiopianAirlinesLastTranx.isEmpty()) {
            ByteArrayInputStream data = csvGenerator.exportToCsv(ethiopianAirlinesLastTranx,
                    new String[]{"Transaction Reference", "Credit", "Currency", "PNR", "Phone number", "Date"}
            );
            return data;
        }

        return null;

    }
}
