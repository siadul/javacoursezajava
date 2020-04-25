package zajecia8.ex3_2;

public class Sender {
    String name; // package
    String surname;
    String address;

    public Sender(String name, String surname, String address) {
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Hello my name is " + name + " " + surname
                + ", I live in " + address;
    }
}
