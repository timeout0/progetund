public class Klassid {
    public static void main(String[] args) {
        Auto auto = new Auto("Sillamäe", 50);

        auto.Kiirenda(20);
        auto.Kiirenda(50);
        auto.Aeglusta(90);
    }
}

class Auto {
    int kiirus = 0;
    int maxspeed;
    final int rattaid = 4;

    public Auto(String asukoht, int mspeed) {
        maxspeed = mspeed;
        System.out.println("Auto valmis " + asukoht + " vabrikus!");
    }

    public void Kiirenda(int vahe) {
        kiirus += vahe;
        if (kiirus > maxspeed) {
            kiirus = maxspeed;
        };
        System.out.println("Sõidab kiirusega " + kiirus + " km/h");
    }
    public void Aeglusta(int vahe) {
        kiirus -= vahe;
        if (kiirus < 0) {
            kiirus = 0;
        };
        System.out.println("Auto sõidab kiirusega " + kiirus + " km/h");
    }
}