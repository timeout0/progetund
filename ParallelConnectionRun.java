import java.util.*;

abstract class AbstractResistor {
    abstract double getResistance();

    double getCurrent(double u) {
        return u / getResistance();
    }
}

class Resistor extends AbstractResistor {
    double r;

    public Resistor(double r) {
        this.r = r;
    }

    double getResistance() {
        return this.r;
    }
}

abstract class MultipleConnection extends AbstractResistor {
    List<AbstractResistor> resistors = new ArrayList<AbstractResistor>();

    void addResistor(AbstractResistor r) {
        resistors.add(r);
    }
}

class ParallelConnection extends MultipleConnection {
    double getResistance() {
        double inversesum = 0;
        for (AbstractResistor r : resistors) {
            inversesum += 1 / r.getResistance();
        }
        return 1/inversesum;
    }
}

public class ParallelConnectionRun{
    public static void main(String[] args){
        ParallelConnection p=new ParallelConnection();
        p.addResistor(new Resistor(220));
        p.addResistor(new Resistor(220));
        p.addResistor(new Resistor(110));
        System.out.println(p.getResistance());
    }
}