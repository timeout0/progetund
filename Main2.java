public class Main2 {
    public static void main(String[] args) {
        Resistor r = new Resistor(220);
        System.out.println(r.getPower(5));
    }
}
 
class Resistor {
    double r;
    
    public Resistor(double r) {
        this.r = r; 
    }

    public double getCurrent(double u) {
        return u / r;
    }

    public double getPower(double u) {
        return u * getCurrent(u);
    }

}