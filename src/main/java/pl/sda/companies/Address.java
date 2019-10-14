package pl.sda.companies;

public class Address {

    private String street;
    private String city;
    private int number;

    public Address(String street, String city, int number) {
        this.street = street;
        this.city = city;
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public int getNumber() {
        return number;
    }
}
