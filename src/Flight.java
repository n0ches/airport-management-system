import java.util.ArrayList;
import java.util.List;

public class Flight {
    private int id;
    private Airport source;
    private Airport destination;
    private Date departureTime;
    private Date arrivalTime;
    private Plane plane;
    private List<Pilot> pilots;
    private List<Host> hosts;
    private List<Passenger> passengers;
    private List<Seat> seats;
    private int flightCost;

    public Flight(int id, Airport source, Airport destination, Date departureTime, Date arrivalTime, Plane plane, int flightCost) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.plane = plane;
        this.flightCost = flightCost;
        this.pilots = new ArrayList<Pilot>();
        this.hosts = new ArrayList<Host>();
        this.passengers = new ArrayList<Passenger>();
        this.seats = new ArrayList<Seat>();
    }

    public void bookSeat (Passenger passenger, int seatId,int price, Date date)
    {
        for(int i = 0; i< this.seats.size();i++)
        {
            if(this.seats.get(i).getSeatId() == seatId)
            {
                this.seats.get(i).setPassenger(passenger);
                this.seats.get(i).setPrice(price);
                this.seats.get(i).setBookingDate(date);
                this.seats.get(i).setAvailable(false);
                break;
            }
        }
    }

    public void cancleReservation(int seatId)
    {
        for(int i = 0; i< this.seats.size();i++)
        {
            if(this.seats.get(i).getSeatId() == seatId)
            {
                this.seats.get(i).setPassenger(null);
                this.seats.get(i).setPrice(0);
                this.seats.get(i).setBookingDate(null);
                this.seats.get(i).setAvailable(false);
                break;
            }
        }
    }

    public void changePilot(Pilot newPilot,Pilot oldPilot)
    {
        this.pilots.remove(oldPilot);
        this.pilots.add(newPilot);
    }

    public void changeHost(Host newHost,Pilot oldHost)
    {
        this.hosts.remove(oldHost);
        this.hosts.add(newHost);
    }

    public void changeSeatOwner(int seatId, Passenger newPassenger)
    {
        for(int i = 0; i< this.seats.size();i++)
        {
            if(this.seats.get(i).getSeatId() == seatId)
            {
                this.seats.get(i).setPassenger(newPassenger);
                break;
            }
        }
    }

    public void displayAllPassengers()
    {
        for(Passenger passenger:passengers)
        {
            System.out.println(passenger.toString());
        }
    }

    public void displayAllPilots()
    {
        for(Pilot pilot:pilots)
        {
            System.out.println(pilot.toString());
        }
    }

    public void displayAllHost()
    {
        for(Host host: hosts)
        {
            System.out.println(host.toString());
        }
    }

    public double calculateIncome()
    {
        double income = 0.0;
        for (Seat seats: this.seats) {
            income += seats.getPrice();
        }
        return income;
    }


    public  int getId() {
        return id;
    }

    public  void setId(int id) { this.id = id; }

    public Airport getSource() {
        return source;
    }

    public void setSource(Airport source) {
        this.source = source;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public List<Pilot> getPilots() {
        return pilots;
    }

    public void setPilots(List<Pilot> pilots) {
        this.pilots = pilots;
    }

    public List<Host> getHosts() {
        return hosts;
    }

    public void setHosts(List<Host> hosts) {
        this.hosts = hosts;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public int getFlightCost() {
        return flightCost;
    }

    public void setFlightCost(int flightCost) {
        this.flightCost = flightCost;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "source=" + source +
                ", destination=" + destination +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", plane=" + plane +
                ", pilots=" + pilots +
                ", hosts=" + hosts +
                ", passengers=" + passengers +
                ", seats=" + seats +
                ", flightCost=" + flightCost +
                '}';
    }
}


