import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map.Entry;

public class Manager {
    private HashMap<Integer,FlightCompany> flightCompanies;
    private HashMap<Integer,Airport> airports;
    private HashMap<Integer,Flight> flights;
    private HashMap<Integer,Pilot> pilots;
    private HashMap<Integer,Host> hosts;
    private HashMap<String,Plane> planes;
    private HashMap<Integer,Pist> pists;
    private HashMap<Integer,Passenger> passengers;



    public Manager() {
        this.flightCompanies = new HashMap<>();
        this.airports = new HashMap<>();
        this.flights = new HashMap<>();
        this.pilots = new HashMap<>();
        this.hosts = new HashMap<>();
        this.planes = new HashMap<>();
        this.pists = new HashMap<>();
        this.passengers = new HashMap<>();

    }

    
    //(due to date not hour)
    public void searchAvaliableSeats(Date departureDate,Date arrivalDate, int minPrice, int maxPrice) {
        ArrayList<Plane> avaliablePlanes= searchAvaliablePlane(departureDate,arrivalDate);

        for(Plane plane: avaliablePlanes)
        {
            for(Seat seat:plane.getSeats())
            {
                if(seat.isAvailable() && seat.getPrice()>minPrice && seat.getPrice()<maxPrice)
                {
                    System.out.println(seat.toString());
                }
            }
        }
    }
    public void searchAvaliablePilots(Date departureDate, Date arrivalDate) {
        ArrayList<Pilot> avaliablePilots = new ArrayList<Pilot>();
        for(Entry<Integer,Pilot> pilot: pilots.entrySet())
        {
            boolean pilotStatus = false;
            Queue temp = new Queue();

            while(!pilot.getValue().getNextFlights().isEmpty())
            {
                Flight flight = (Flight) pilot.getValue().getNextFlights().peek();
                temp.enqueue(pilot.getValue().getNextFlights().dequeue());
                String depTime = Integer.toString(departureDate.getDay()) + Integer.toString(departureDate.getMonth()) +Integer.toString(departureDate.getYear());
                String arrivTime = Integer.toString(arrivalDate.getDay()) + Integer.toString(arrivalDate.getMonth()) +Integer.toString(arrivalDate.getYear());
                String flightDepTime = Integer.toString(flight.getDepartureTime().getDay()) + Integer.toString(flight.getDepartureTime().getMonth()) +Integer.toString(flight.getDepartureTime().getYear());
                String flightArrivTime = Integer.toString(flight.getArrivalTime().getDay()) + Integer.toString(flight.getArrivalTime().getMonth()) +Integer.toString(flight.getArrivalTime().getYear());
                if(!(((Integer.parseInt(depTime)<Integer.parseInt(flightDepTime)) && (Integer.parseInt(arrivTime)>Integer.parseInt(flightDepTime))) || ((Integer.parseInt(depTime)<Integer.parseInt(flightArrivTime)) && (Integer.parseInt(arrivTime)>Integer.parseInt(flightArrivTime)))))
                {
                    pilotStatus = true;
                    break;
                }
            }
            while(!temp.isEmpty())
            {
                pilot.getValue().getNextFlights().enqueue(temp.dequeue());
            }
            if(pilotStatus)
            {
                avaliablePilots.add(pilot.getValue());
                System.out.println(pilot.getValue());
            }
        }
    }
    public void searchAvaliableHosts(Date departureDate, Date arrivalDate) {
        ArrayList<Host> avaliableHosts = new ArrayList<Host>();
        for(Entry<Integer,Host> host: hosts.entrySet())
        {
            boolean hostStatus = false;
            Queue temp = new Queue();
            while(!host.getValue().getNextFlights().isEmpty())
            {
                Flight flight = (Flight) host.getValue().getNextFlights().peek();
                temp.enqueue(host.getValue().getNextFlights().dequeue());
                String depTime = Integer.toString(departureDate.getDay()) + Integer.toString(departureDate.getMonth()) +Integer.toString(departureDate.getYear());
                String arrivTime = Integer.toString(arrivalDate.getDay()) + Integer.toString(arrivalDate.getMonth()) +Integer.toString(arrivalDate.getYear());
                String flightDepTime = Integer.toString(flight.getDepartureTime().getDay()) + Integer.toString(flight.getDepartureTime().getMonth()) +Integer.toString(flight.getDepartureTime().getYear());
                String flightArrivTime = Integer.toString(flight.getArrivalTime().getDay()) + Integer.toString(flight.getArrivalTime().getMonth()) +Integer.toString(flight.getArrivalTime().getYear());
                if(!(((Integer.parseInt(depTime)<Integer.parseInt(flightDepTime)) && (Integer.parseInt(arrivTime)>Integer.parseInt(flightDepTime))) || ((Integer.parseInt(depTime)<Integer.parseInt(flightArrivTime)) && (Integer.parseInt(arrivTime)>Integer.parseInt(flightArrivTime)))))
                {
                    hostStatus = true;
                    break;
                }
            }
            while(!temp.isEmpty())
            {
                host.getValue().getNextFlights().enqueue(temp.dequeue());
            }
            if(hostStatus)
            {
                avaliableHosts.add(host.getValue());
                System.out.println(host.getValue());
            }
        }
    }
    public ArrayList<Plane> searchAvaliablePlane(Date departureDate, Date arrivalDate) {
        ArrayList<Plane> avaliablePlanes = new ArrayList<Plane>();
        for(Entry<String,Plane> plane: planes.entrySet())
        {
            boolean planeStatus = false;
            Queue temp = new Queue();
            while(!plane.getValue().getNextFlights().isEmpty())
            {
                Flight flight = (Flight) plane.getValue().getNextFlights().peek();
                temp.enqueue(plane.getValue().getNextFlights().dequeue());
                String depTime = Integer.toString(departureDate.getDay()) + Integer.toString(departureDate.getMonth()) +Integer.toString(departureDate.getYear());
                String arrivTime = Integer.toString(arrivalDate.getDay()) + Integer.toString(arrivalDate.getMonth()) +Integer.toString(arrivalDate.getYear());
                String flightDepTime = Integer.toString(flight.getDepartureTime().getDay()) + Integer.toString(flight.getDepartureTime().getMonth()) +Integer.toString(flight.getDepartureTime().getYear());
                String flightArrivTime = Integer.toString(flight.getArrivalTime().getDay()) + Integer.toString(flight.getArrivalTime().getMonth()) +Integer.toString(flight.getArrivalTime().getYear());
                if(!(((Integer.parseInt(depTime)<Integer.parseInt(flightDepTime)) && (Integer.parseInt(arrivTime)>Integer.parseInt(flightDepTime))) || ((Integer.parseInt(depTime)<Integer.parseInt(flightArrivTime)) && (Integer.parseInt(arrivTime)>Integer.parseInt(flightArrivTime)))))
                {
                    planeStatus = true;
                    break;
                }
            }
            while(!temp.isEmpty())
            {
                plane.getValue().getNextFlights().enqueue(temp.dequeue());
            }
            if(planeStatus)
            {
                avaliablePlanes.add(plane.getValue());
                System.out.println(plane.getValue().toString());
            }
        }
        return avaliablePlanes;
    }
    public void searchPassenger (String name, String surname) {
    	for (Entry<Integer, Passenger> p : passengers.entrySet()) {
    		if(p.getValue().getName().equals(name) && p.getValue().getSurname().equals(surname))
    			System.out.println(p.getValue().toString());
    	}
    }
    public void searchFlightCompany (String name) {
    	for (Entry<Integer, FlightCompany> company : flightCompanies.entrySet()) {
    		if(company.getValue().getName().equals(name))
    			System.out.println(company.getValue().toString());
    	}
    }
    public void addPassenger (String name, String surname, int idNumber, Phone phone, Date birthday, String gender, double weight, double height , int bagID, double bagWeight) {
        passengers.put(idNumber, new Passenger(name,surname,idNumber,phone,birthday,gender,weight,height,bagID,bagWeight));
    }
    //(pilot or co-pilot)
    public void addPilot (String name, String surname, int idNumber, Phone phone, Date birthday, String gender, double weight, double height, String rank, FlightCompany flightCompany, int workExperience, int salary) {
    	pilots.put(idNumber, new Pilot(name,surname,idNumber,phone,birthday,gender,weight,height,rank,flightCompany,workExperience,salary));
    }
    public void addHost (String name, String surname, int idNumber, Phone phone, Date birthday, String gender, double weight, double height, int workExperience, int salary, FlightCompany flightCompany) {
    	hosts.put(idNumber, new Host(name,surname,idNumber,phone,birthday,gender,weight,height,workExperience,salary,flightCompany));
    }
    public void addPlane (String planeCode, String name, int baggageCapacity,int seatNumber, int age, int fuelCapacity,FlightCompany flightCompany) {
    	planes.put(planeCode, new Plane(planeCode, name,  baggageCapacity,  seatNumber,  age,  fuelCapacity,  flightCompany));
    }
    public void addAirport (int id, String name, Address address, int pistCount) {
    	airports.put(id, new Airport(id, name,  address,  pistCount));
    }
    public void addPist (int id, String type, int capacity) {
    	pists.put(id, new Pist(id,type,  capacity));
    }
    public void addFlight (int id, Airport source, Airport destination, Date departureTime, Date arrivalTime, Plane plane,int flightCost) {
    	flights.put(id, new Flight(id, source,  destination,  departureTime, arrivalTime, plane, flightCost));
    }
    public void addReservation (int flightId, int seatId, Passenger passenger,int price, Date date ) {
        flights.get(flightId).bookSeat(passenger, seatId, price, date);
    }
    public void addFlightCompany(int id, String name, Address address, Phone phone, int budget) {
    	flightCompanies.put(id,  new FlightCompany(id, name,  address,  phone, budget));
    }
    public void deleteFlightCompany(int id) {
    	flightCompanies.remove(id);
    }
    public void deletePilot(int id) {
        pilots.remove(id);
    }
    public void deleteHost(int id) {
        hosts.remove(id);
    }
    public void deletePlane(int id) {
        planes.remove(id);
    }
    public void deleteAirport(int id) {
       airports.remove(id);
    }
    public void deletePist(int id) {
        pists.remove(id);
    }
    public void deleteFlight(int id) {
       flights.remove(id);
    }
    public void deletePassenger(int id) {
        passengers.remove(id);
    }
    public void deleteReservation(int flightId, int seatId) {
        flights.get(flightId).cancleReservation(seatId);
    }
}