import java.util.*;
public class Pist {
    private int  id;
    private String type;
    private int capacity;
    private Queue planeQueue;

    public Pist(int id,String type, int capacity) {
    	this.id = id;
        this.type = type;
        this.capacity = capacity;
        this.planeQueue = new Queue();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Queue getPlaneQueue() {
        return planeQueue;
    }

    public void setPlaneQueue(Queue planeQueue) {
        this.planeQueue = planeQueue;
    }

    public void addPlaneToQueue(Plane plane) {
        planeQueue.enqueue(plane);
    }

    @Override
    public String toString() {
        return id+"-"+type+" pist ("+capacity+" planes)";
        //queuedaki uçaklar yazdırılacak
    }

}