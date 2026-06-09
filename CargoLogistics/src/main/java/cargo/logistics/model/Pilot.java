package cargo.logistics.model;

import java.util.ArrayList;
import java.util.List;

public class Pilot {
    private int pilotId;
    private String name;
    private int experienceYears;
    private List<String> certifications = new ArrayList<>();

    public Pilot(int id, String name, int exp, List<String> certs){
        if (exp <= 0 || certs.isEmpty()){throw new IllegalArgumentException("and then?");}
        this.pilotId = id;
        this.name = name;
        this.experienceYears = exp;
        this.certifications = certs;
    }

    public int pilotId(){return this.pilotId;}
    public String name(){return this.name;}
    public int experienceYears(){return this.experienceYears;}
    public List<String> certifications(){return new ArrayList<>(this.certifications);}
    public boolean hasCertification(String cert){
        return this.certifications.contains(cert) ? true : false;
    }
    public void addCertifications(String cert){
        this.certifications.add(cert);
    }

    @Override
    public String toString(){return this.name + " ";}

}
/*
List<String> certifications()
boolean hasCertification(String cert)
void addCertification(String cert)
String toString()
Requirement

Return a defensive copy. */
