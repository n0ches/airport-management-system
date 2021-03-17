public class Seat {

    private int seatId;
    private boolean available;
    private Passenger passenger;
    private Date bookingDate;
    private int price;

    public Seat(int seatId) {
        this.seatId = seatId;
    }
    public Seat(int seatId,int price) {
        this.seatId = seatId;
        this.price = price;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean status) {
        this.available = status;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "status=" + available +
                ", passenger=" + passenger +
                ", bookingDate=" + bookingDate +
                ", price=" + price +
                '}';
    }
}

