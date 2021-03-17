
public class Passenger extends Person {
    private double bagID;
    private double bagWeight;

    public Passenger(String name, String surname, int idNumber, Phone phone, Date birthday, String gender, double weight, double height, double bagID, double bagWeight) {
        super(name, surname, idNumber, phone, birthday, gender, weight, height);
        this.bagID = bagID;
        this.bagWeight = bagWeight;
    }

    public double getBagID() {
        return bagID;
    }
    public void setBagID(double bagID) {
        this.bagID = bagID;
    }
    public double getBagWeight() {
        return bagWeight;
    }
    public void setBagWeight(double bagWeight) {
        this.bagWeight = bagWeight;
    }
    @Override
    public String toString() {
        return "Passenger [bagID=" + bagID + ", bagWeight=" + bagWeight + "]";
    }



}