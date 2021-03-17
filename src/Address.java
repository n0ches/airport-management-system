public class Address {
    private String country;
    private String city;
    private String town;

    public Address(String country, String city, String town) {
        this.country = country;
        this.city = city;
        this.town = town;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Override
    public String toString() {
        return town+","+city+","+country;

    }



}