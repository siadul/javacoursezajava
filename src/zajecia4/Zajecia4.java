package zajecia4;
// aby stworzyć pakiet, dodajemy nowy folder w obrębie src, a następnie umieszczamy
// na samej górze pliku "package NAZWA_PAKIETU;"

// jezeli robie to za pomocą IntelliJ to wtedy "package NAZWA_PAKIETU" zostanie
// dodane automatycznie

// klasa Vector z pliku Zajecia3 jest niewidoczna na poziomie klasy Zajecia4,
// ponieważ znajduje się w innym pakiecie, w tzw. pakiecie DOMYŚLNYM
// tzn. bezpośrednio pod src/

import zajecia4.student.Car;
import zajecia4.student.Pet;
import zajecia4.student.Student;

import java.util.Arrays;
import java.util.Date;

public class Zajecia4 {
    public static void main(String[] args) {
//        fields();
//        ex1();
//        constructors();
//        varargs();
        finals();
//        staticFieldsAndMethods();
//        static initialization vs initialization block
    }

    private static void varargs() {
        // varargs - metody z dowolną liczba argumentów tego samego typu
        printArgs();
        printArgs("test");
        printArgs("test", "test2");

        System.out.println(
                Arrays.toString(
                        printSquares(1, 0.1, 0.01)
                )
        );
        System.out.println(
                Arrays.toString(
                        printSquares(1)
                )
        );
        System.out.println(
                Arrays.toString(
                        printSquares(10, 100, 1000, 5, 6, 7)
                )
        );
        // podobny efekt jak przy przeciązaniu, z tym, że przy przeciązaniu musimy
        // mieć ściśle określoną liczbe argumentów

        // Uwaga! varargs musi być ostatnim argumentem metody

        // Przykład
        // Napisac metodę, która przyjmuje dowolną liczbę argumentów typu double
        // i zwraca tablicę zawierającą kwadraty z tych argumentów
    }

    private static void printArgs(String... args) {
//        System.out.println(args); // [Ljava.lang.String;@31befd9f

        // Wniosek
        // args jest tablicą Stringów
        System.out.println(Arrays.toString(args));
    }

    private static double[] printSquares(int a, double... values) {
        double[] result = new double[values.length];
        for (int i = 0; i < values.length; i++) {
            result[i] = a*values[i]*values[i];
        }

        return result;
    }

    private static void constructors() {
        // konstruktor to metoda statyczna, której celem jest inicjalizacja pól obiektu,
        // który tworzy

        // Uwaga 1 Konstruktor nie może mieć określonego typu zwracanego, ponieważ
        // wywołujemy go zawsze wtedy gdy tworzmy obiekt.
        // Jak wywoływać konstruktory
        Date date = new Date();

        // Uwaga 2 Ponieważ konstruktor jest metodą, możemy ją przeciążać, czyli
        // napisać X jego wersji różniących się typem argumentów

        // Uwaga 3 Konstruktor nazywa się ZAWSZE tak samo jak nazwa klasy

        // Przykład
        // Dodać konstruktor do klasy Pet, który setuje wszystkie jego pola.
        // Utworzyć obiekt klasy Pet w oparciu o ten konstruktor.
        // Pet pet1 = new Pet(); // nie zadziała, jeżeli mam wyłącznie konstuktor
        //                          sparametryzowany (na szczęscie mam obie wersje)
        Pet pet1 = new Pet("Burek");
        System.out.println(pet1);
        Pet pet2 = new Pet("Azor", "dog", "bulldog",
                true, true, 4, new Date(), 20, 50);
        System.out.println(pet2);

    }

    private static void ex1() {
        // Zadanie
        // Stworzyć klasę Pet w pakiecie student a następnie
        // - dodać min. 3 pola różnych typów,
        // - gettery,
        // - settery
        // - przesłoniętą metodę toString
        // Skorzystać z tej klasy i jej metod oraz pól w metodzie Zajecia4.main

        // Uwaga 1! Pet musi być klasą publiczną, ponieważ gdyby nie była publiczna
        // to jej dostęp byłby pakietowy, a więc nie mógłbym tworzyć instancji tej klasy
        // poza obrębem pakietu student.
        // Uwaga 2! w jednym pliku nie może być więcej niż 1 klasa publiczna.

        // Wniosek: Pet musi być klasą publiczną w nowym pliku Pet.java w pakiecie student
        Pet pet1 = new Pet();
        System.out.println(
                pet1.getLegs()
        );
        pet1.setLegs(3);
        pet1.setBirthdate(new Date()); // bieżący czas
        pet1.setName("Tofik");
        pet1.setType("dog");
        pet1.setRace("Chihuahua");
        pet1.setStrokable(false);

        System.out.println(pet1);




    }

    private static void finals() {
        // final - pola oznaczone jako final nie mogę zmienić swojej wartości
        Car c1 = new Car("opel");
        c1.show();
        c1.go(10);
        c1.go(20);
        c1.go(15);
        c1.show();
//        c1.milage = 0;
//        c1.brand = "aston martin";
        c1.replaceCounter();
        c1.show();

    }

    private static void staticFieldsAndMethods() {
    }

    private static void fields() {
        Vector v1 = new Vector();
        v1.X = 4;
        v1.Y = 5;
        v1.Z = 6;

        Vector v2 = new Vector();
        v2.X = 100;
        v2.Y = 200;
        v2.Z = 400;

        System.out.println("v1: " + v1);
        System.out.println("v2: " + v2);

        // Pole pozwalają nam określać stan obiektów

        // Przykład
        // Wypisać wektor będący sumą wektorów v1 i v2
        // I sposób
        double v3X = v1.X + v2.X;
        double v3Y = v1.Y + v2.Y;
        double v3Z = v1.Z + v2.Z;
        System.out.println(
                "v3: [X: " + v3X + ", Y: " + v3Y + ", Z: " + v3Z
        );

        // II sposób
        Vector v3 = new Vector();
        v3.X = v1.X + v2.X;
        v3.Y = v1.Y + v2.Y;
        v3.Z = v1.Z + v2.Z;
//        System.out.println("v3: [X: " + v3.X + ", Y: " + v3.Y + ", Z: " + v3.Z);
        System.out.println("v3: " + v3);

        // III sposób
        Vector v4 = new Vector();
//        v4.addX(v1, v2);
//        System.out.println("v4: " + v4); // v4: [X: 0.0, Y: 0.0, Z: 0.0]
        v4 = v4.addX(v1, v2);
        System.out.println("v4: " + v4); // v4: [X: 104.0, Y: 205.0, Z: 406.0]

        // IV sposób
        Vector v5 = new Vector();
        v5.add(v1, v2);
        System.out.println("v5: " + v5); // [X: 104.0, Y: 205.0, Z: 406.0]

        // Wniosek 1
        // Metoda addX() wyłącznie tworzy nowy obiekt Vector, dlatego po wywołaniu
        // v4.addX(v1, v2); i wypisaniu v4 widzimy, że współrzędne
        // nie zostały zmodyfikowane

        // Metoda add() modyfikuje stan wektora, dlatego wystarczy wywołanie
        // v5.add(v1, v2); by po wypisaniu otrzymać zmodyfikowane współrzędne

        // Inaczej mówiąc:
        // Pierwsza metoda 'addX' zwraca nowy obiekt, ale nie rusza obiektu tzn.
        // nie modyfikuje stanu obiektu na rzecz którego wywoływana jest metoda (v4)

        // Natomiast druga metoda 'add' modyfikuje stan obiektu (v5), ale nie zwraca
        // żadnego nowego obiektu

        // Wniosek 2
        // Korzystając z obiektów zyskuje czas i gwarancję powtarzalności wyników

        Student student1 = new Student();
        // jeżeli klasa znajduje się w innym pakciecie to wówczas nie jest widoczna,
        // CHYBA że jest publiczna (przed słowem class znajduje się "public"),
        // ale wówczas musimy ją zaimportować

//        student1.birthdate; // nie zadziała, pole birthdate ma dostęp prywatny, więc
        // jest widoczne wyłącznie w klasie Student

        // W jaki sposób zatem mogę uzyskać dostęp do pola name, surname i birthdate?

        // I pomysł: usunięcie modyfikatora private
        // student1.name // nie działa, komunikat: name nie jest publiczne
        // Wyjaśnienie:
        // Usunięcie modyfikatora private sprawia, że pole zyskuje DOSTĘP PAKIETOWY
        // Dostęp pakietowy oznacza, że pole jest widoczne W OBRĘBIE TEGO SAMEGO PAKIETU

        // II pomysł: zmiana modyfikatora private na public
        // student1.name = "jan"; // działa, natomiast nie jest to najlepsze rozwiązanie
        // imienia nie powinnien móc modyfikować każdy

        // III pomysł: poprzez akcesory (gettery i settery)
        // UWAGA! gettery i settery mają zawsze dostęp publiczny, wobec tego
        // mogę z nich korzystać poza obrębem klasy w której są zdefiniowane
        System.out.println(student1.getName()); // null
        System.out.println(student1.getBirthdate()); // 0
        // skąd się wziął null i co on oznacza?
        // nie ustawiliśmy nigdzie wartości polu name, w związku z tym przyjeło ono
        // wartość domyślną
        // wartością domyślna dla wszystkich typów obiektowych jest null
        // null oznacza wartość pustą, nie ustawioną

        // dla typu int wartością domyślną jest 0

        student1.setName("Jan");
        System.out.println(student1.getName());
    }
}


class Vector {

    // pola
    double X;
    double Y;
    double Z;

    // metody - nadpisujemy wersję z klasy Object
    public String toString() { // Uwaga! metoda nie posiada modyfikatora static
        return "[X: " + X + ", Y: " + Y + ", Z: " + Z + "]";
    }

    public Vector addX(Vector vector1, Vector vector2) {
//        return vector1 + vector2; nie zadziała, nie możemy sumować zdefiniowanych klas
        Vector vector3 = new Vector();
        vector3.X = vector1.X + vector2.X;
        vector3.Y = vector1.Y + vector2.Y;
        vector3.Z = vector1.Z + vector2.Z;

        return vector3;
    }

    // Napisać metodę, która dodaje 2 wektory, ale sumę zapisuje
    // do pól tej klasy.
    // Czyli zamiast tworzenia nowego Vectora w metodzie add będziemy
    // odwoływać się do pól tej klasy.
    public void add(Vector vector1, Vector vector2) {
        X = vector1.X + vector2.X;
        Y = vector1.Y + vector2.Y;
        Z = vector1.Z + vector2.Z;
    }

    // Uwaga! Nie jest możliwe dodanie metod, które różnią się wyłącznie
    // typem zwracanym!
    // Inaczej mówiąc: nie jest możliwe przeciążanie metod za pomocą typów zwracanych
}

// przed przeniesieniem klasy Zajecia4 do pakietu zajecia4 mamy błąd,
// bo klasa Vector już jest zdefiniowana w pliku Zajecia3.java