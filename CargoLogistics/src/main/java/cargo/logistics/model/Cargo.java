package cargo.logistics.model;

public class Cargo {
    private String cargoId;
    private double weight;
    private String description;

    public Cargo(String cargoId, double weight, String description){
        if (weight <=0){throw new IllegalArgumentException("eh");}
        this.cargoId =cargoId;
        this.weight = weight;
        this.description = description;
    }

    public String cargoId(){return this.cargoId;}
    public double weight(){return this.weight;}
    public String description(){return this.description;}
    public void updateWeight(double weight){this.weight +=weight;}
    @Override
    public String toString(){return this.cargoId;}
}
/*

void updateWeight(double weight)

String toString() */