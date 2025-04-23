public class Klassid2 {
    public static void main(String[] args) {
        Inimene inimene = new Inimene();
        System.out.println(inimene.getName());
        inimene.setName("Henri");
        System.out.println(inimene.getName());
    }
}

class Inimene {
    private String name;

    public String getName() {
        return name;
    }
    public void setName(String newName) {
        name = newName;
    }
}