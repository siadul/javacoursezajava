import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Zajecia3 {
    public static void main(String[] args) {
//        z1z10();
//        z1z12();

//        methods(); // argumenty w metodach + wartości zwracane
//        scanner();
//        methodsExcercises();
        
        classes();
//        packets();
    }

    private static void classes() {
        // co to są klasy?
        // zbiór metod (i pól)
        String x = "jakiś tekst";
        System.out.println(x.length()); // wywołanie metody length na rzecz obiektu x
        // UWAGA! length() jest metodą związaną z obiektem x

        int[] y = {4, 5, 6}; // new int[]{4, 5, 6}
        System.out.println(y.length); // y.length przechowuje informację o liczbie elementów w tablicy y
        // UWAGA! length jest polem/field/property związanym z obiektem y

        // metody, które nie mają static w definicji mogą operować na polach
        // metody, które mają static w definicji nie mogą operować na polach
        // wektory

        // Przykład
        // stworzyć 3 wektory 3-elementowe i dodać je do siebie
        double v1X = 1, v1Y=2, v1Z=3,
               v2X = 10, v2Y=20, v2Z=30,
               v3X = 7, v3Y=6, v3Z=4;

        System.out.println((v1X + v2X + v3X) + ", " + (v1Y + v2Y + v3Y) + ", " + (v1Z + v2Z + v3Z));

        Vector v1 = new Vector();
        Vector v2 = new Vector();
        Vector v3 = new Vector();
        v1.X = 1; v1.Y=2; v1.Z=3;
        v2.X = 10; v2.Y=20; v2.Z=30;
        v3.X = 7; v3.Y=6; v3.Z=4;
        System.out.println((v1.X + v2.X + v3.X) + ", " + (v1.Y + v2.Y + v3.Y) + ", " + (v1.Z + v2.Z + v3.Z));
        // mniejsze ryzyko że popełnie błąd wpisując x zamiast X ze względu na kontrolę w czasie kompilacji
    }

    private static void methodsExcercises() {
        // Zadanie 1
        // Napisać metodę 'getSumOfStringLength(String arg1, String arg2)', która pobiera 2 Stringi
        // i zwraca sumę długości obu tych Stringow
        // np. getSumOfStringLength("ala", "ma kot") -> 9

        // Zadanie 2
        // Napisać metodę 'getSumOfSquares(double[] arr)', która zwraca sumę kwadratów liczb podanych jako
        // argument w postaci tablicy
        // np. getSumOfSquares(new int[]{4, 5, 6}) -> 16+25+36 = 77
        double[] arr = {4.2, 1.8, 33, 43.2};
        double sumOfSquares = getSumOfSquares(arr);
        System.out.println(sumOfSquares);

        // Zadanie 3
        // Napisać metodę 'getSimpleArray', która zwraca tablicę n-elementową wypełnioną kolejnymi liczbami
        // np. getSimpleArray(5) -> [1, 2, 3, 4, 5]
        double[] tab = getSimpleArray(99);
        System.out.println(Arrays.toString(tab));
//        System.out.println(Arrays.deepToString(tab)); // dla tablic wielowymiarowych używamy deepToString


        // Zadanie 4
        // Napisać metodę 'getSimpleArray', w wersji, która zwraca tablicę n-elementową wypełnioną wartościami
        // losowymi z przedziału od 0 do k
        // np. getSimpleArray(5, 100) -> [15, 26, 1, 11, 88]
        tab = getSimpleArray(99, 0.5);
        System.out.println(Arrays.toString(tab));
    }

    private static double[] getSimpleArray(int n) {
        double[] tab = new double[n];
        for(int i=0; i<tab.length; i++) {
            tab[i] = i;
        }

        return tab;
    }

    private static double[] getSimpleArray(int n, double k) {
        double[] tab = new double[n];
        Random random = new Random();
        for(int i=0; i<tab.length; i++) {
            tab[i] = random.nextDouble();
            if(tab[i] > k) {
                i--;
            }
        }

        return tab;
    }

    private static double getSumOfSquares(double[] values) {
        double sum = 0;
//        for (double value : values) { // pętla foreach
//            System.out.println(value);
//            sum += value * value;
//        }
        for (int i=0; i<values.length; i++) {
            System.out.println(values[i]);
            sum += values[i] * values[i];
        }

        return sum;
    }

    private static void scanner() {
        // Przykład
        // Napisać metodę getLength(arg), która przyjmuje ciąg znaków (String)
        // i zwraca jego długość
        // proszę nie korzystać String.length()
        int l = getLength("Java");
        System.out.println(l);

        // Przykład
        // Napisać metodę, która wczytuje liczbę z klawiatury i wypisuje jej kwadrat
        // Jeżeli użytkownik wpisze "stop", kończy się wykonywać nasz program.
//        readSquare();

        // Przykład
        // Napisać metodę, która wczytuje liczby z klawiatury i wypisuje ich sumę
        // Jeżeli użytkownik wpisze "stop", kończy się wykonywać nasz program.
        readSum();
    }

    private static void methods() {
        // Przykład
        // Napisać metodę, która wyszukuje najmniejszy element z zestawu
        // (tablicy liczb)
        double x1 = .0026, x2 = 315, x3 = 72.4;
        min(x1, x2, x3);

        x1 = 32;
        x2 = 244;
        x3 = 8778;
        min(x1, x2, x3);

        double[] array1 = {4, 88, 234, 423, 0.453, 0.23};
        min(array1); // Uwaga! nazwa zmiennej przekazywanej do metody nie ma znaczenia
        // nie musi się nazywać 'values'
        min(new double[]{4, 7, 3}); // Tak naprawdę nie muszę w ogóle przekazywać zmiennej
        // do metody; mogę przekazać stałą wartość

        // Przykład
        // Obliczyć kwadrat z najmniejszej liczby spośród tablicy n wartości typu double
//        min(array1) * min(array1); to nam nie zadziała, wartość najmniejsza jest wyłącznie
        // wypisywana na konsolę za pomocą metody System.out.println
        // musi ona "wychodzić" z metody.
        // Do tego służą typy zwracane określone w metodach.

        // Składnia
//        public static return_type foo(args) {
//            return some_value; // słowo return powoduje przerwanie wykonywania metody
        // opuszczenie jej i zwrócenie wartości podanej po słowie return
//        }

        System.out.println("użycie min z typem zwracanym");
        double minValue;
        minValue = min(array1);
        System.out.println(minValue * minValue);
        System.out.println(Math.pow(2, 10)); // 1024, Math.pow - zwraca n-tą potęgę podstawy = arg1, gdzie n = arg2
        System.out.println(Math.pow(minValue, 10));
    }

    private static void readSquare() {
        // konwencja nazewnicza metod
        // stosujemy camelCase - notacja wielbłądzia
        // fooBarSomeOtherWordsInMethodName()
        // Uwaga 1 Nazwa metody (tak samo jak zmiennej) nie może zaczynać sie m.in od cyfry
        // Uwaga 2 Mogą istnieć różne "wersje" metody tzn. np. mamy 2 metody min różniące się
        //         wyłącznie listą argumentów. Takie zjawisko nazywamy PRZECIĄŻANIEM METOD (Overloading)

        // Scanner - klasa służąca do operacji na Stringach m.in wczytywania danych ze strumieni
        System.out.println("Podaj liczbę lub słowo 'stop': ");
        Scanner scanner = new Scanner(System.in);

        do {
            String input = scanner.nextLine(); // wczytuje dane z klawiatury do momentu
            // wpisania znaku końca linii ("\n")

            int i = 0;
            try {
                i = Integer.parseInt(input); // przekształcamy wczytany String na int
            } catch (Exception e) {
                if (input.equals("stop")) {
                    System.exit(0); // Kończy wykonywanie programu
                    // tutaj mogłoby być return zamiast System.exit
                    // wówczas wyszlibyśmy z metody readSum
                }
                System.out.println("Podano nieprawidłową wartość. Podaj liczbę lub słowo 'stop'"); // instrukcje wykonywane gdy nie uda się wykonać poprzedniego
                // bloku tzn. zostanie rzucony wyjątek
            }
            // blok try-catch - zabezpiecznie przed tym żeby program się nie wywalił
            // program może się wywalić jeżeli zawiera wywołania niebezpiecznych metod
            // jakie to są niebezpieczne metody?
            // to metody, które po nazwie posiadają 'throws Nazwa_Klasy_Wyjątku'
            // np. Integer.parseInt(String s) throws NumberFormatException {

            System.out.println(i * i);
        } while(true);
    }

    private static void readSum() {
        System.out.println("Podaj liczbę lub słowo 'stop': ");
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        do {
            String input = scanner.nextLine();
            int i = 0;
            try {
                i = Integer.parseInt(input);
            } catch (Exception e) {
                if (input.equals("stop")) {
                    System.out.println(sum);
                    System.exit(0);
                }
                System.out.println("Podano nieprawidłową wartość. Podaj liczbę lub słowo 'stop'");
            }
            sum += i;

//            System.out.println(sum);
        } while(true);
    }

    private static int getLength(String value) {
        System.out.println("in getLength() method");
        char[] charArray = value.toCharArray();

        return charArray.length; // Array.length
    }

    /**
     * Zwraca najmniejszą wartość spośród 3 liczb typu double
     */
    private static void min(double x1, double x2, double x3) {
//        double x1 = 5.6, x2 = 3.5, x3 = 7.4;

        System.out.println("in method min()");
        double[] tab1 = {x1, x2, x3}; // x1 = 5.6, x2 = 3.5, x3 = 7.4;
        double min = Double.MAX_VALUE; // największa możliwa do przechowywania wartość dla min
        for(int i=0; i<tab1.length; i++) {
            if (tab1[i] < min) {
                // tab1[i] jest najmniejsze z przedziału 0:i
                min = tab1[i];
            }
        }
        System.out.println(min);
    }

    /**
     * Zwraca najmniejszą wartość spośród tablicy liczb typu double
     */
    private static double min(double[] values) {
        System.out.println("in method min()");
        double min = Double.MAX_VALUE;
        for(int i=0; i<values.length; i++) {
            if (values[i] < min) {
                min = values[i];
            }
        }

        return min;
    }

    private static void z1z12() {
        // ciąg arytmetyczny - 2, 4, 6, 8
        // r - krok, różnica ciągu - wartość stała = 2
        // a - wyraz poczatkowy = 2
        // n - liczba wyrazów ciągu = 4
        // obliczyć sumę (2 + 4 + 6 + 8) = 20
        double a = 2;
        double n = 4;
        double r = 2;
        System.out.println(a + r * (n - 1)); // n-ty wyraz ciągu
        System.out.println((((2 * a + (n-1) * r) * n) / 2)); // suma

        // za pomocą pętli
        double suma = a;
        double nty = a;
        for (int i=1; i<n; i++) {
            nty += r;
            suma += nty;
            System.out.println(i + ": " + suma);
        }
        System.out.println(suma);
    }

    private static void z1z10() {
        // znaleźć najmniejszą spośród 3 liczb x1, x2, x3
        // I sposób - if
        double x1 = 5.6, x2 = 3.5, x3 = 7.4;
        if (x1 <= x2 && x1 <= x3) {
            System.out.println(x1);
        } else if (x2 <= x1 && x2 <= x3) {
            System.out.println(x2);
        } else if (x3 <= x1 && x3 <= x2) {
            System.out.println(x3);
        }

        if(x1 <= x2) {
            if(x1 <= x3) {
                System.out.println(x1);
            } else { // x2 >= x1 > x3     x1 <= x2
                System.out.println(x3);
            }
        } else if(x2 <= x3) { // x2 = 3, x3 = 2, czy 2 <= 3? tak
            if(x2 <= x1) {
                System.out.println(x2);
            } else {
                // ?
            }
        } else if(x3 <= x1) {
            // wiemy, że nie jest prawdą, że x2 <= x3
            // to oznacza, że x3 < x2
            System.out.println(x3);
        } else {
            // ?
        }
        // *dla ambitnych - do przeanalizowania i optymalizacji w domu

        System.out.println("II sposób");
        double[] tab1 = {x1, x2, x3, .02}; // x1 = 5.6, x2 = 3.5, x3 = 7.4;
        double min = Double.MAX_VALUE; // największa możliwa do przechowywania wartość dla min
        for(int i=0; i<tab1.length; i++) {
            if (tab1[i] < min) {
                // tab1[i] jest najmniejsze z przedziału 0:i
                min = tab1[i];
            }
        }
        System.out.println(min);
    }
}

class Vector {
    double X;
    double Y;
    double Z;
}