package cargo.logistics.model;

public class Route {
    private String origin;
    private String destination;
    private double distance;

    public Route(String origin, String destination, double distance){
        if (distance < 0){throw new IllegalArgumentException("hhayibo");}
        this.origin = origin;
        this.destination = destination;
        this.distance = distance;
    }

    public String origin(){return this.origin;}
    public String destination(){return this.destination;}
    public double distance(){return this.distance;}
    public double estimatedFuelRequired(){return this.distance * 2.5;}

}
/*
String origin()
String destination()
double distance()
double estimatedFuelRequired()
Fuel formula:
distance * 2.5 */
