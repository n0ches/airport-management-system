import java.util.LinkedList;

public class Host extends Person implements Employee {

    private int workExperience;
    private int salary;
    private FlightCompany flightCompany;
    private Queue nextFlights;

    public Host(String name, String surname, int idNumber, Phone phone, Date birthday, String gender, double weight, double height, int workExperience, int salary, FlightCompany flightCompany) {
        super(name, surname, idNumber, phone, birthday, gender, weight, height);
        this.workExperience = workExperience;
        this.salary = salary;
        this.flightCompany = flightCompany;
        this.nextFlights = new Queue();
    }

    //Flights will be in order
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

    public FlightCompany getFlightCompany() {
        return flightCompany;
    }

    public void setFlightCompany(FlightCompany flightCompany) {
        this.flightCompany = flightCompany;
    }

    public Queue getNextFlights() {
        return nextFlights;
    }

    public void setNextFlights(Queue nextFlights) {
        this.nextFlights = nextFlights;
    }

    @Override
    public String toString() {
        return "Host{" +
                "workExperience=" + workExperience +
                ", salary=" + salary +
                ", flightCompany=" + flightCompany +
                ", nextFlights=" + nextFlights +
                '}';
    }
}
