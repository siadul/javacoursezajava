package zajecia8.ex4_1;

public class Building {
    private String address;
    private double size;
    private double temperature;

//    public Building() {} // musi istnieć, jeżeli w klasach
    // pochodnych chce móc tworzyć obiekty bez argumentów w
    // wywołaniach konstruktorów

    public Building(String address) {
        System.out.println(this);
        this.address = address;
    }
    public Building(String address, double size) {
        this(address);
        System.out.println(this);
        this.size = size;
    }
    public Building(String address, double size, double temperature) {
        this(address, size);
        System.out.println(this);
        this.temperature = temperature;
    }
}
