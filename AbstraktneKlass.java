abstract class AbstractTakistaja{
    abstract double getResistance();
    double getCurrent(double u){
        return u / getResistance();
    }
}

class Takistaja extends AbstractTakistaja {
    double r;

    public Takistaja(double r) {
        this.r = r;
    }

    double getResistance() {
        return this.r;
    }
    }

class Luliti extends AbstractTakistaja {
    boolean on;

    public Luliti(boolean on) {
        this.on = on;
    }

    double getResistance() {
        return on ? 0 : 1000000000;
    }
    public void on(){on=true;}
    public void off(){on=false;}
    public double getCurrent(double u){
        if(on){
            if(u>0){
                throw new RuntimeException("short circuit");
            }
        }
        return super.getCurrent(u);
    }
}

public class AbstraktneKlass {
    public static void main(String[] args) {
        AbstractTakistaja r1 = new Takistaja(22);
        System.out.println(r1.getResistance());
    }
}
