package pl.sda.companies;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CompaniesControler {
    private final CompaniesSrvice companiesSrvice;

    public CompaniesControler(CompaniesSrvice companiesSrvice) {
        this.companiesSrvice = companiesSrvice;
    }

    @GetMapping("/companies")
    public String listCompanies(){
        return "companies/companies";
    }

    @PostMapping(value = "/companies", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    private String findCompanies(@RequestParam(required = false) String NIP,
                                 @RequestParam(required = false) String nazwa,
                                 Model model){

        List<Company> foundCompanies = companiesSrvice.find(NIP,nazwa);
        model.addAttribute("companies", foundCompanies);

        return "companies/companies";
    }
}

