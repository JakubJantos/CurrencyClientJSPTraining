package pl.sda.currencyclient;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FixerResponce {
    String base;
    Rates rates;

    @JsonCreator
    public FixerResponce(@JsonProperty("base") String base,
                         @JsonProperty("rates") Rates rates) {
        this.base = base;
        this.rates = rates;
    }

    public String getBase() {
        return base;
    }

    public Rates getRates() {
        return rates;
    }

    public Double getEurToPln(){
        return Double.parseDouble(rates.getPLN());
    }

    public Double getEurToUsd(){
        return Double.parseDouble(rates.getUSD());
    }

    public Double getEurToGBP(){
        return Double.parseDouble(rates.getGBP());
    }


    @Override
    public String toString() {
        return "FixerResponce for" +
                "base ->" + base  +
                ", rates ->" + rates;
    }
}
