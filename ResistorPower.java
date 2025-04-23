class Resistor2 {
    double r;
 
    public Resistor2(double r) {
       this.r = r;
    }
 
    public double getCurrent(double u) {
       return u / r;
    }
 
    public double getPower(double u) {
       return u * getCurrent(u);
    }
 }
 
 public class ResistorPower {
    public static void main(String[] args) {
       Resistor2 r = new Resistor2(220);
       System.out.println(r.getPower(5));
    }
 }