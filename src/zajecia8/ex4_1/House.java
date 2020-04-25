package zajecia8.ex4_1;

public class House extends Building {
    private int residents;

    public House(String address, double size, double temperature, int residents) {
        super(address, size, temperature);
        this.residents = residents;
    }
}
