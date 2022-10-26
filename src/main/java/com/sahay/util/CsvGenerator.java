package com.sahay.util;

import com.sahay.entity.EthiopianAirline;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.QuoteMode;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class CsvGenerator {

    public ByteArrayInputStream exportToCsv(List<EthiopianAirline> ethiopianAirlines  , String[] headers) {

        CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL)
                .withHeader(headers);

        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format)) {

            for (EthiopianAirline ethiopianAirline : ethiopianAirlines) {
                List<?> data = Arrays.asList(
                        ethiopianAirline.getWalletReferenceId(),
                        ethiopianAirline.getAmount(),
                        ethiopianAirline.getCurrency(),
                        ethiopianAirline.getPnr(),
                        ethiopianAirline.getCustomerPhoneNumber(),
                        ethiopianAirline.getDateCreated());

                System.out.println("data = " + data);
                csvPrinter.printRecord(data);
                log.debug("exportToCsv() : Converted data to csv successfully : {} ", data);
            }
            csvPrinter.flush();
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            log.error("exportToCsv() : error occurerd while converting data to csv", e.getMessage());
            throw new RuntimeException("Failed to import Object to csv : " + e.getMessage());
        }

    }


}
