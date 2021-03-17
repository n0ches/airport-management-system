import java.util.ArrayList;

public class FlightCompany {
    private int id;
    private String name;
    private Address address;
    private Phone phone;
    private ArrayList<Plane> planes;
    private ArrayList<Pilot>pilots;
    private ArrayList<Host>hosts;
    private int budget;
    public FlightCompany(int id, String name, Address address, Phone phone, int budget) {
    	this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.planes = new ArrayList<>();
        this.pilots = new ArrayList<>();
        this.hosts = new ArrayList<>();
        this.budget = budget;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public Phone getPhone() {
        return phone;
    }
    public void setPhone(Phone phone) {
        this.phone = phone;
    }
    public ArrayList<Plane> getPlanes() {
        return planes;
    }
    public void setPlanes(ArrayList<Plane> planes) {
        this.planes = planes;
    }
    public ArrayList<Pilot> getPilots() {
        return pilots;
    }
    public void setPilots(ArrayList<Pilot> pilots) {
        this.pilots = pilots;
    }
    public ArrayList<Host> getHosts() {
        return hosts;
    }
    public void setHosts(ArrayList<Host> hosts) {
        this.hosts = hosts;
    }
    public int getBudget() {
        return budget;
    }
    public void setBudget(int budget) {
        this.budget = budget;
    }

    public void addPlane(Plane plane) {
        planes.add(plane);
        System.out.println("Plane was added succesfully");
    }

    public void addPilot(Pilot pilot) {
        pilots.add(pilot);
        System.out.println("Pilot was added succesfully");
    }

    public void addHost(Host host) {
        hosts.add(host);
        System.out.println("Host was added succesfully");
    }

    public void deletePlane(Plane plane) {
        planes.remove(plane);
        System.out.println("Plane was deleted succesfully");
    }

    public void deletePilot(Pilot pilot) {
        pilots.remove(pilot);
        System.out.println("Pilot was deleted succesfully");
    }

    public void deleteHost(Host host) {
        hosts.remove(host);
        System.out.println("Host was deleted succesfully");
    }

    public void displayAllPilots() {
        for (Pilot pilot : pilots) {
            System.out.println(pilot.toString());
        }
    }

    public void displayAllHosts() {
        for (Host host : hosts) {
            System.out.println(host.toString());
        }
    }

    public void displayAllPlanes() {
        for (Plane plane : planes) {
            System.out.println(plane.toString());
        }
    }

    public void displayAllEmployees() {
        System.out.println("HOSTS: ");
        displayAllHosts();
        System.out.println("PILOTS: ");
        displayAllPilots();
    }

    public double totalIncome() {
        double income=0.0;

        for (Plane plane:planes)
        {
            for(Flight flight:plane.getFlighthistory())
            {
                for(Seat seat:flight.getSeats())
                {
                    if(!seat.isAvailable())
                    {
                        income += seat.getPrice();
                    }
                }
            }
        }


        return income;
    }

    public double totalOutcome() {
        double outcoume=0.0;
        for(Pilot pilot:pilots)
        {
            outcoume += pilot.getWorkExperience() * pilot.getSalary();
        }
        for(Host host:hosts)
        {
            outcoume += host.getWorkExperience() * host.getSalary();
        }
        return outcoume;
    }

    public double totalGain() {
        double totalGain= totalIncome() - totalOutcome();
        System.out.println(totalGain);
        return totalGain;
    }
}