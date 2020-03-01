package zajecia4.student;

import java.util.Date;

public class Pet {
    private String name = "noname";
    private String type;
    private String race;
    private boolean isMale = false; // dla booleanów gettery mają prefix is
    private boolean strokable;
    private int legs = 4; // możemy ustawiać wartości polom w miejsu definicji
    private Date birthdate;
    private double weight;
    private double height;

    // Konstruktor znajduje się zazwyczaj bezpośrednio pod definicją pól
    // Uwaga!
    // Konstruktor, który nie przyjmuje żadnych argumentów nazywany jest konstruktorem
    // domyślnym.
    // Jeżeli nie zdefiniujemy żadnego konstruktora to wówczas zostanie on utworzony
    // z automatu (jako pusta metoda)
    // Jeżeli utworzymy jakikolwiek konstrutkor (w szczególności sparametryzowany),
    // to wówczas nie istnieje wersja konstruktora domyślnego generowanego z automatu

    public Pet() {
        name = "Burek";
    }

    public Pet(String name) {
        this.name = name;
    }

    public Pet(
            String name,
            String type,
            String race,
            boolean isMale,
            boolean strokable,
            Date birthdate,
            double weight,
            double height
    ) {
        this(name);
        this.type = type;
        this.race = race;
        this.isMale = isMale;
        this.strokable = strokable;
        this.birthdate = birthdate;
        this.weight = weight;
        this.height = height;
    }

    public Pet(
            String name,
            String type,
            String race,
            boolean isMale,
            boolean strokable,
            int legs,
            Date birthdate,
            double weight,
            double height
    ) {
        // Uwaga! moge odwoływać się do innych zdefiniowanych konstruktorów, ale
        // musi to być pierwsza instrukcja w konstruktorze
        this(name, type, race, isMale, strokable, birthdate, weight, height);
        this.legs = legs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public boolean isStrokable() {
        return strokable;
    }

    public void setStrokable(boolean strokable) {
        this.strokable = strokable;
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", race='" + race + '\'' +
                ", isMale=" + isMale +
                ", strokable=" + strokable +
                ", legs=" + legs +
                ", birthdate=" + birthdate +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }
}
