package zajecia6;

public class InheritanceConstructors {
    public static void main(String[] args) {
//        Car car = new Car();
        Van van = new Van(1);
        van.show();
    }
}

class Car {
    int seats = 4;

    Car(int a) {
        System.out.println("Creating car... " + a);
    }

    public void show() {
        System.out.println("Seats in car: " + seats);
    }
}

class Van extends Car {
    int seats = 10;

    Van(int a) {
        super(4); // jeżeli w klasie bazowej mam sparametryzowany konstruktor to muszę
        // jawnie wywołać konstruktor z tej klasy - za pomocą słowa super
        System.out.println("Creating van... " + a);

        // UWAGA! Wywołanie konstruktora z klasy bazowej musi być pierwszą instrukcją
        // w definicji konstuktora klasy pochodnej
    }
    // Wniosek!
    // Aby stworzyć obiekt klasy pochodnej musi być wywołany konstruktor z klasy bazowej.
    // Jeżeli nie zdefiniujemy konstruktora w klasie pochodnej to jest on wywoływany niejawnie
    // w konstruktorze domyślnym.

    @Override // adnotacja wymusza przesłonięcie
    // jeżeli zmodyfikuję sygnaturę metodę nad którą znajduje się adnotacja @Override w taki sposób, że nie będzie
    // ona przesłaniała metody z klasy bazowej to wóczas program się nie skompiluje
    public void show() {
        // Uwaga! Mówimy, że przesłaniamy metodę show z klasy bazowej.
        // Aby była mowa o przesłonięciu musimy mieć tę samą sygnaturę (nazwa + argumenty) metody.
        System.out.println("Seats in van: " + seats);

        // jeżeli chcemy mimo wszystko wywołać wersję z klasy bazowej to używamy słowa kluczowego "super"
        super.show();
        System.out.println(seats);
        System.out.println(super.seats);
    }
}

