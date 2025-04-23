import java.util.ArrayList;
import java.util.List;

class Resistor3 {
    double r;
 
    public Resistor3(double r) {
       this.r = r;
    }
 
    public double getCurrent(double u) {
       return u / r;
    }
 
    public double getPower(double u) {
       return u * getCurrent(u);
    }

    public double getResistance() {
        return r;
    }
}

class Jada {
    List<Resistor3> resistors = new ArrayList<Resistor3>();

    void addResistor(Resistor3 r) {
        resistors.add(r);
    }

    double getTotalResistance() {
        double sum = 0;
        for (Resistor3 r : resistors) {
            sum += r.getResistance();
        }
        return sum;
    }

    double getCurrent(double u) {
        return u / getTotalResistance();
    }
}

public class JadaYhendus {
    public static void main(String[] args) {
        Jada sc = new Jada();
        sc.addResistor(new Resistor3(220));
        sc.addResistor(new Resistor3(220));
        sc.addResistor(new Resistor3(110));
        System.out.println(sc.getTotalResistance());
        System.out.println(sc.getCurrent(12));
    }
}
