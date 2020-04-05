package zajecia6;

public class Abstracts {
    public static void main(String[] args) {
        Circus circus = new Circus();

//        LivingCreature livingCreature1 = new LivingCreature();
        // Ponieważ klasa LivingCreature jest abstrakcyjna to nie mogę utworzyć
        // instancji tej klasy

        Human human1 = new Human();
        Dog dog = new Dog();

//        circus.showTime(livingCreature1); // nie zadziała
        circus.showTime(human1); // rzutowanie w górę na typ LivingCreature!
        circus.showTime(dog); // rzutowanie w górę na typ LivingCreature!

        human1.doSomething();
    }
}

class Circus {
    public void showTime(LivingCreature livingCreature) {
        System.out.println(
                livingCreature.getClass().getName()
        );
        livingCreature.show(); // polimorfizm!!!

        // Dzięki polimorfizmowi livingCreature.show() wywołuje wersję metody show
        // za pierwszym razem z klasy Human a za drugim z klasy Dog.
        // Mówiąc inaczej informacja o typie obiektu jest wiązana z wywołaniem w trakcie
        // wykonywania programu.
    }
}

abstract class LivingCreature {
    public void doSomething() {
        System.out.println("LivingCreature is doing something...");
    }

//    public void show() {
//        System.out.println("Hi I am Living Creature");
//    }
    // powyższy komunikat jest bezsensowny, taka informacja nie daje nam nic cennego
    // w związku z tym chcemy zablokować możliwość wywołania metody show bezpośrednio dla
    // klasy LivingCreature.

    // W tym celu używamy słowa abstract przed definicją metody:
    abstract public void show();

    // Uwaga! Jeżeli klasa zawiera co najmniej jedną metodę abstrakcyjną to również
    // sama musi być oznaczona jako abstrakcyjna.

    // Jeżeli klasa abstrakcyjna to oznacza, że nie jestem w stanie stworzyć instancji tej klasy.

    // Uwaga! Może istnieć klasa, która jest abstrakcyjna, ale posiada same nieabstrakcyjne metody
    // ale nie może istnieć nieabstrakcyjna klasa, która posiada choć jedna abstrakcyjną metodę

    // Wniosek!
    // Oznaczamy metodę jak abstract aby przeznaczyć ją do przesłonięcia.
    // Wówczas przenosimy odpowiedzialność za napisanie definicji tej metody w miejsce
    // definicji klasy pochodnej

    // Uwaga!
    // Jeżeli w klasie bazowej oznaczę metodę jako abstrakcyjną to w klasie pochodnej
    // MUSI istnieć jej implementacja CHYBA ŻE klasa pochodna jest również abstrakcyjna
    // (wówczas nie musi istnieć taka implementacja).
}

class Human extends LivingCreature {
    public void show() {
        doSomething();
        System.out.println("Hi I am Human");
    }
}

class Dog extends LivingCreature {
    public void show() {
        System.out.println("Woof woof");
    }
}