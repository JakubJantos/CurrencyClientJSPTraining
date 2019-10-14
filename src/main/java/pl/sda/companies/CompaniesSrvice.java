package pl.sda.companies;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CompaniesSrvice {

    private static final Map<Long, Company> companies = new HashMap<>();

    static {
        Address address = new Address("NMP", "cze-wa", 56);
        long nip = 1234567894L;
        companies.put(nip, new Company(nip, "ACME", 987123456, address));

        Address address1 = new Address("aleja", "cze-wa", 102);
        long nip1 = 7364037270L;
        companies.put(nip1, new Company(nip1, "Kappa", 93837278, address1));
    }




    public List<Company> find(String nip, String nazwa) {
        if (nip != null) {
            Long convertedNip = Long.parseLong(nip.replaceAll("[\\s\\-]", ""));

            if (companies.containsKey(convertedNip)) {
                Company foud = companies.get(convertedNip);
                return nazwa == null || foud.getNazwa().equals(nazwa) ?
                        Collections.singletonList(foud) :
                        Collections.emptyList();
            } else {
                return Collections.emptyList();
            }
        } else {
            if (nazwa == null) {
                return new ArrayList<>(companies.values());

            } else {
                return companies.values().stream()
                        .filter(c -> c.getNazwa().equals(nazwa))
                        .collect(Collectors.toList());
            }
        }
    }
}
