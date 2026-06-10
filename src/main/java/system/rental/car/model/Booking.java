package system.rental.car.model;

public class Booking{
    private int bookingId;
    private Customer customer;
    private Vehicle vehicle;
    private int days;
    private BookingStatus status =  BookingStatus.PENDING;

    public Booking(int bookingId, Customer customer, Vehicle vehicle, int days) {
        this.bookingId = bookingId;
        this.customer = customer;
        this.vehicle = vehicle;
        this.days = days;
        this.status = BookingStatus.PENDING;
    }

    public int bookingId() {
        return bookingId;
    }

    public Customer customer() {
        return customer;
    }

    public Vehicle vehicle() {
        return vehicle;
    }

    public int days() {
        return days;
    }

    public BookingStatus status() {
        return status;
    }

    public double totalCost() {
        return vehicle().dailyRate() * days;
    }

    public void updateStatus(BookingStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return customer().name() + vehicle().model();
    }
}