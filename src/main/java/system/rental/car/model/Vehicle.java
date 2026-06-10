package system.rental.car.model;

public class Vehicle{
    private String model;
    private double dailyRate;
    private boolean available = true;

    public Vehicle(String model, double dailyRate) {
        this.model = model;
        this.dailyRate = dailyRate;
        this.available = true;
    }

    public String model(){ return model;}

    public double dailyRate() { return dailyRate;}

    public boolean isAvailable() { return available;}

    public void setAvailable(boolean availability) {
        this.available = availability;
    }

    public void updateDailyRate(double rate) {
        if (rate < 0) throw new IllegalArgumentException();
        this.dailyRate = rate;
    }

    @Override
    public String toString() {
        return model() + " - " + "R" + dailyRate() +"/day";
    }
}