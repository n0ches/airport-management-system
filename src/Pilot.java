import java.util.LinkedList;


public class Pilot extends Person implements Employee{
    private String rank;
    private FlightCompany flightCompany;
    private int workExperience;
    private int salary;
    private Queue nextFlights;

    public Pilot(String name, String surname, int idNumber, Phone phone, Date birthday, String gender, double weight, double height, String rank, FlightCompany flightCompany, int workExperience, int salary) {
        super(name, surname, idNumber, phone, birthday, gender, weight, height);
        this.rank = rank;
        this.flightCompany = flightCompany;
        this.workExperience = workExperience;
        this.salary = salary;
        this.nextFlights = new Queue();
    }

    @Override
    public void addFlightToNextFlight(Flight flight) {
        this.nextFlights.enqueue(flight);
    }

    @Override
    public boolean isAvailable(Flight flight) {
        return false;
    }

    @Override
    public void addFligt(Flight flight) {
        addFlightToFlightHistory(flight);
    }


    public String getRank() {
        return rank;
    }
    public FlightCompany getFlightCompany() {
        return this.flightCompany;
    }


    public int getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Queue getNextFlights() {
        return nextFlights;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }


}