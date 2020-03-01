package zajecia4.student;

public class Car {
    public final String brand; // marka
    private double milage; // przebieg samochodu

    public Car(String brand) {
        this.brand = brand; // brand muszę ustawić tylko raz np. w konstruktorze
    }

    public void go(double distance) {
        this.milage += distance;
    }

    public void show() {
        System.out.println("brand: " + brand);
        System.out.println("milage: " + milage);
    }

    public void replaceCounter() {
        this.milage = 0;
    }
}
