import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Plane {
    private String planeCode;
    private String name;
    private int baggageCapacity;
    private int seatNumber;
    private int age;
    private List<Flight> flighthistory;
    private Queue nextFlights;
    private int fuelCapacity;
    private List<Seat> seats;
    private FlightCompany flightCompany;
    private boolean permission;

    public Plane(String planeCode, String name, int baggageCapacity, int seatNumber, int age, int fuelCapacity, FlightCompany flightCompany) {
        this.planeCode = planeCode;
        this.name = name;
        this.baggageCapacity = baggageCapacity;
        this.seatNumber = seatNumber;
        this.age = age;
        this.fuelCapacity = fuelCapacity;
        this.flightCompany = flightCompany;
        this.flighthistory = new ArrayList<Flight>();
        this.nextFlights = new Queue();
        permission=false;
    }

    //Flight will check that is plane available or not on this flights time and location time
    public boolean isAvailable(Flight flight)
    {
        boolean availabe = true;
        return availabe;
    }

    public void addSeat(int seatId)
    {
        Seat seat = new Seat(seatId);
        this.seats.add(seat);
    }

    public void addSeat(int seatId,int price)
    {
        Seat seat = new Seat(seatId,price);
        this.seats.add(seat);
    }

    public void addFlightToNextFlights(Flight flight)
    {
        this.nextFlights.enqueue(flight);
    }

    public String getPlaneCode() {
        return planeCode;
    }

    public void setPlaneCode(String planeCode) {
        this.planeCode = planeCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBaggageCapacity() {
        return baggageCapacity;
    }

    public void setBaggageCapacity(int baggageCapacity) {
        this.baggageCapacity = baggageCapacity;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Flight> getFlighthistory() {
        return flighthistory;
    }

    public void setFlighthistory(List<Flight> flighthistory) {
        this.flighthistory = flighthistory;
    }

    public Queue getNextFlights() {
        return nextFlights;
    }

    public void setNextFlights(Queue nextFlights) {
        this.nextFlights = nextFlights;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public FlightCompany getFlightCompany() {
        return flightCompany;
    }

    public void setFlightCompany(FlightCompany flightCompany) {
        this.flightCompany = flightCompany;
    }
    
    public boolean isPermission() {
		return permission;
	}

	public void setPermission(boolean permission) {
		this.permission = permission;
	}

	@Override
    public String toString() {
        return "Plane{" +
                "planeCode='" + planeCode + '\'' +
                ", name='" + name + '\'' +
                ", baggageCapacity=" + baggageCapacity +
                ", seatNumber=" + seatNumber +
                ", age=" + age +
                ", flighthistory=" + flighthistory +
                ", nextFlights=" + nextFlights +
                ", fuelCapacity=" + fuelCapacity +
                ", seats=" + seats +
                ", flightCompany=" + flightCompany +
                '}';
    }
}

