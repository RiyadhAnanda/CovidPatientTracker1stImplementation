package project1package;


public class Infected extends Person {


    private double casenumber;
    
    // default constructor
    public Infected() {
        super();
        casenumber = 4.0;
    }
    
    // constructor to use to create a new student
    public Infected(String n, String i, double g) {
        super(n,i);
        casenumber = g;
    }

    // getter and setter for casenumber
    public double getCasenumber() {
        return casenumber;
    }
    public void setCasenumber(double casenumber) {
        this.casenumber = casenumber;
    }
    
    // string representation of this Infected
    public String toString () {
        return super.toString()+" casenumber: "+casenumber;
    }
}

