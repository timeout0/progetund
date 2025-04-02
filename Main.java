class Resistor {
    double r;

    public Resistor(double r) {
        this.r = r;
    }

    public double getCurrent(double u) {
        return u / r;
    }
}

public class Main {
    public static void main(String[] args) {
        Resistor[] resistors = new Resistor[2];
        resistors[0] = new Resistor(220);
        resistors[1] = new Resistor(4700);
        double totalCurrent = 0;
        for (int i = 0; i < resistors.length; i++) {
            totalCurrent += resistors[i].getCurrent(5);
        }
        System.out.println(totalCurrent);
    }
  }