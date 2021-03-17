import java.util.ArrayList;
import java.util.List;

abstract class Person {

    private String name;
    private String surname;
    private int idNumber;
    private Phone phone;
    private Date birthday;
    private String gender;
    private double weight;
    private double height;
    private List<Flight> flightHistory;

    public Person(String name, String surname, int idNumber, Phone phone, Date birthday, String gender, double weight, double height) {
        this.name = name;
        this.surname = surname;
        this.idNumber = idNumber;
        this.phone = phone;
        this.birthday = birthday;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.flightHistory = new ArrayList<Flight>();
    }

    public void addFlightToFlightHistory(Flight flight)
    {
        this.flightHistory.add(flight);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public List<Flight> getFlightHistory() {
        return flightHistory;
    }

    public void setFlightHistory(List<Flight> flightHistory) {
        this.flightHistory = flightHistory;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", idNumber=" + idNumber +
                ", phone=" + phone +
                ", birthday=" + birthday +
                ", gender='" + gender + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                ", flightHistory=" + flightHistory +
                '}';
    }
}
