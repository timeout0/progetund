import java.util.*;

abstract class AbstractTakistaja {
    abstract double getResistance();
    double getCurrent(double u){
        return u / getResistance();
    }
}

class Resistorx extends AbstractTakistaja {
    double r;

    public Resistorx(double r) {
        this.r = r;
    }

    double getResistance() {
        return this.r;
    }
}

abstract class MultipleConnection2 extends AbstractTakistaja {
    List<AbstractTakistaja> resistors = new ArrayList<AbstractTakistaja>();

    void addResistor(AbstractTakistaja r) {
        resistors.add(r);
    }
}

class ParallelConnection2 extends MultipleConnection2 {
    double getResistance() {
        double inversesum = 0;
        for (AbstractTakistaja r : resistors) {
            inversesum += 1 / r.getResistance();
        }
        return 1/inversesum;
    }
}

public class Jarka{
    public static void main(String[] args){
        ParallelConnection2 p=new ParallelConnection2();
        p.addResistor(new Resistorx(220));
        p.addResistor(new Resistorx(220));
        p.addResistor(new Resistorx(110));
        System.out.println(p.getResistance());
    }
}
