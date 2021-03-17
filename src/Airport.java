import java.util.ArrayList;

public class Airport {
    private  int id;
    private String name;
    private Address address;
    private int pistCount;
    private ArrayList<Pist>pists;

    public Airport(int id, String name, Address address, int pistCount) {
    	this.id = id;
        this.name = name;
        this.address = address;
        this.pistCount = pistCount;
        this.pists = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public  void setId(int id) {
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

    public int getPistCount() {
        return pistCount;
    }

    public void setPistCount(int pistCount) {
        this.pistCount = pistCount;
    }

    public ArrayList<Pist> getPists() {
        return pists;
    }

    public void setPists(ArrayList<Pist> pists) {
        this.pists = pists;
    }

    public void addPist(Pist p) {
        pists.add(p);
    }

    public void setPermission(int pistNumber, Plane p) {
       p.setPermission(true);
       pists.get(pistNumber).addPlaneToQueue(p);
    }

  
    @Override
    public String toString() {
        return name+"\nAddress: "+address.toString();
        //pists will be added
    }


}