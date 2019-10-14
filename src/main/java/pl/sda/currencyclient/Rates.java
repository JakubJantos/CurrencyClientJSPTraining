package pl.sda.currencyclient;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rates {
    private String USD;
    private String GBP;
    private String PLN;

    public Rates(@JsonProperty("USD") String USD,
                 @JsonProperty("GBP") String GBP,
                 @JsonProperty("PLN")String PLN) {
        this.USD = USD;
        this.GBP = GBP;
        this.PLN = PLN;
    }

    public String getUSD() {
        return USD;
    }

    public String getGBP() {
        return GBP;
    }

    public String getPLN() {
        return PLN;
    }

    @Override
    public String toString() {
        return "Rates \n" +
                "USD -> " + USD +"\n" +
                "GBP -> " + GBP + "\n" +
                "PLN -> " + PLN + "\n";
    }
}
