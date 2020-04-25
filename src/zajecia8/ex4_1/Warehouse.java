package zajecia8.ex4_1;

public class Warehouse extends Building {
    private double availability;

    public Warehouse(String address, double size, double temperature, double availability) {
        super(address, size, temperature);
        this.availability = availability;
    }

}
