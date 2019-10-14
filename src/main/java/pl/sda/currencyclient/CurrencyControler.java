package pl.sda.currencyclient;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class CurrencyControler {

    private final FixerClient fixerClient;

    public CurrencyControler(FixerClient fixerClient) {
        this.fixerClient = fixerClient;
    }

    @GetMapping("/currency")
    public String getCurrency(){
        return "currency";
    }

    @PostMapping("/currency")
    public String findCurrencies(@RequestParam String exchangeDate,
                                 @RequestParam String selectedBase, Model model){

        LocalDate exDate = LocalDate.parse(exchangeDate);

        model.addAttribute("currenciesRates", fixerClient.getRates(exDate, selectedBase));
        model.addAttribute("selectetDate", exchangeDate);
        model.addAttribute("prevSel", selectedBase);

        return "currency";
    }


}
