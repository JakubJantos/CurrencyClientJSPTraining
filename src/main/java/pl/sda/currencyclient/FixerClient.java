package pl.sda.currencyclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import kong.unirest.JacksonObjectMapper;
import kong.unirest.Unirest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;


@Service
public class FixerClient {

    public RatesResponse getRates(LocalDate exchangeDate, String selectedBase) {

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(FAIL_ON_UNKNOWN_PROPERTIES, false);

        Unirest.config().setObjectMapper(new JacksonObjectMapper(mapper));

        FixerResponce response = Unirest.get("http://data.fixer.io/api/" + exchangeDate)
                .queryString("access_key", "acbc96c064ef32725ac5dbe0a2e41942")
                .queryString("symbols", "USD,GBP,PLN")
                .asObject(FixerResponce.class)
                .getBody();

        RatesResponse ratesResponse = toRatesResponse(selectedBase, response);
        return ratesResponse;
    }

    private RatesResponse toRatesResponse(String selectedBase, FixerResponce response) {

        Map<String, Double> rates = new HashMap<>();

        if (selectedBase.equals(response.getBase())) {
            rates.put("USD", Double.parseDouble(response.getRates().getUSD()));
            rates.put("PLN", Double.parseDouble(response.getRates().getPLN()));
            rates.put("GBP", Double.parseDouble(response.getRates().getGBP()));
        } else {
            if (selectedBase.equals("PLN")) {
                rates.put("USD", response.getEurToUsd() / response.getEurToPln());
                rates.put("GBP", response.getEurToGBP() / response.getEurToPln());
                rates.put("EUR", 1.0 / response.getEurToPln());
            } else if (selectedBase.equals("USD")) {
                rates.put("PLN", response.getEurToPln() / response.getEurToUsd());
                rates.put("GBP", response.getEurToGBP() / response.getEurToUsd());
                rates.put("EUR", 1.0 / response.getEurToUsd());
            } else if (selectedBase.equals("GBP")) {
                rates.put("USD", response.getEurToUsd() / response.getEurToGBP());
                rates.put("PLN", response.getEurToPln() / response.getEurToGBP());
                rates.put("EUR", 1.0 / response.getEurToGBP());
            } else {
                throw new IllegalArgumentException("Illigal base");
            }
        }
        return new RatesResponse(selectedBase, rates);
    }
}
