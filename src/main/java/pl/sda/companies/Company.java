package pl.sda.companies;

public class Company {
    private Long NIP;
    private String nazwa;
    private int regon;
    private Address address;

    public Company( Long NIP, String nazwa, int regon, Address address) {
        this.NIP = NIP;
        this.nazwa = nazwa;
        this.regon = regon;
        this.address = address;
    }

    public String getNazwa() {
        return nazwa;
    }

    public Long getNIP() {
        return NIP;
    }

    public int getRegon() {
        return regon;
    }

    public Address getAddress() {
        return address;
    }
}
