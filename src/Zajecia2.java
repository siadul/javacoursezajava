import java.util.Random;

public class Zajecia2 {
    public static void main(String[] args) {
        System.out.println("Zajęcia2");
        poczatekZajec(args);
        nowaMetoda(args);
    }

    public static void nowaMetoda(String[] args) {
        System.out.println("Jesteśmy w nowaMetoda!");
    }

    public static void poczatekZajec(String[] args) {
        // Zadanie 1
        // Proszę sprawdzić czy liczba dzieli się przez 3 bez reszty.
        // Wypisać stosowny komunikat.
        int liczba1 = 99;
        if (liczba1 / 3 * 3 == liczba1) {
            System.out.println("jest podzielna przez 3");
        } else {
            System.out.println("nie jest podzielna przez 3");
        }

        // Ćwiczenie 1
        // Proszę sprawdzić czy liczba1a dzieli się przez liczbe2a bez reszty.
        // Wypisać stosowny komunikat.
        int liczba1a = 27;
        int liczba2a = 13;
        if (liczba1a / liczba2a * liczba2a == liczba1a) {
            System.out.println(liczba1a + " jest podzielna przez " + liczba2a);
        } else {
            System.out.println(liczba1a + " nie jest podzielna przez " + liczba2a);
        }

        // Ćwiczenie 2
        // Sprawdzić czy liczba3 typu double jest całkowita.
        // Wskazówka:
        // Mogę zrzutować (int) 45.3 i wówczas dostanę liczbę bez części ułamkowej
        double liczba3 = 45.3;
        if (liczba3 == (int) liczba3) {
            System.out.println(liczba3 + " jest całkowita");
        } else {
            System.out.println(liczba3 + " nie jest całkowita");
        }

        // Jak sprawdzać podzielność liczb w lepszy sposób?
        // operator modulo % - zwraca resztę z dzielenia
        System.out.println(3 % 1); // 0
        System.out.println(3 % 2); // 1
        System.out.println(3 % 3); // 0
        // sprawdzanie czy liczba dzieli się bez reszty
        int liczba1b = 47;
        int liczba2b = 47;
        if (liczba1b % liczba2b == 0) {
            System.out.println(liczba1b + " jest podzielna przez " + liczba2b);
        } else {
            System.out.println(liczba1b + " nie jest podzielna przez " + liczba2b);
        }

        System.out.println(3 % 3); // 0
        System.out.println(4 % 3); // 1
        System.out.println(5 % 3); // 2
        System.out.println(6 % 3); // 0
        System.out.println(7 % 3); // 1
        System.out.println(8 % 3); // 2
        System.out.println(9 % 3); // 0

        System.out.println(4 % 4); // 0
        System.out.println(5 % 4); // 1
        System.out.println(6 % 4); // 2
        System.out.println(7 % 4); // 3
        System.out.println(8 % 4); // 0
        System.out.println(9 % 4); // 1

        System.out.println(0 % 4); // 0
        System.out.println(1 % 4); // 1
        System.out.println(2 % 4); // 2
        System.out.println(3 % 4); // 3
        System.out.println(4 % 4); // 0
        System.out.println(5 % 4); // 1

        // instrukcja switch
//         switch (zmienna) {
//             case wartość1:
//                  instrukcje...
//                 break; // wykonujemy wszystkie instrukcje aż do
//                          pierwszego słowa break
//             case wartość2:
//                 instrukcje...
//                 break;
//         ...
//             case wartośćN:
//                 instrukcje...
//                 break;
//              default: // blok domyślny
        // instrukcje
//         }
        // Uwaga pierwszych break może znaleźć się dopiero w którymś
        // z kolejnych bloków case.

        // Ćwiczenie 3
        // Wypisywać komunikat "krótkie" jeżeli długość imienia będzie
        // mniejsza niż 4, jeżeli dłuższe niż 3 ale krótsze 7 to "średnie"
        // jeżeli dłuższe niż 6 to "długie". Skorzystać z instrukcji switch.
        // Wskazówka:
        // Długość stringa pobieramy wywołując metodę length() np. imie.length()
        String imie = "Krzysztof";
//        String imie = "krzys";
        switch (imie.length()) {
            case 0:
                System.out.println("krótkie");
                break;
            case 1:
                System.out.println("krótkie");
                break;
            case 2:
                System.out.println("krótkie");
                break;
            case 3:
                System.out.println("krótkie");
                break;
            case 4:
            case 5:
            case 6:
                System.out.println("średnie");
                break;
            default:
                System.out.println("długie");
//                break; // ostatni break nie jest potrzebny, ponieważ
                // default musi być ostatnim casem
        }

        // Uwaga! w 'case' musimy mieć wartości stałe, zatem blok
        // switch przydaje się najczęściej wtedy gdy mamy ściśle
        // określony zbiór wartości, które może przyjąć określona zmienna


        // pętle

        // Ćwiczenie wypisać liczby od 1 do 10
        // I sposób
        System.out.println(1);
        System.out.println(2);
        System.out.println(3);
        System.out.println(4);
        System.out.println(5);
        System.out.println(6);
        System.out.println(7);
        System.out.println(8);
        System.out.println(9);
        System.out.println(10);

        // II sposób
        // pętla for
//    for (dekl. licznika; warunek wykonywania; modyfikacja_licznika) {
//        instrukcje...
//    }
        // przejście pętli -> iteracja
        // licznik -> iterator

        for (int i = 1; i < 11; i = i + 1) {
            System.out.println(i);
        }
        // jak działa powyższa pętla:
        // int i = 1;

        // I iteracja
        // 1 < 11, TAK
        // System.out.println(1);
        // i = 1 + 1 = 2

        // II iteracja
        // 2 < 11, TAK
        // System.out.println(2);

        // ...

        // X iteracja
        // 10 < 11, TAK
        // System.out.println(10);

        // XI iteracja
        // 11 < 11, NIE, kończę wykonywanie pętli

        // Ćwiczenie 2
        // Wypisać liczby od 100 do 0 z krokiem co 2
        // Output: 100, 98, 96, ..., 2, 0
        for (int j = 100; j >= 0; j = j - 2) {
            System.out.println(j);
        }

        // Zadanie 2
        // Wypisać wszystkie liczby od 100 do -100, z krokiem co 10
        // Output: 100, 90, 80, ..., -90, -100
        for (int j = 100; j >= -100; j = j - 10)
            System.out.println(j);
        System.out.println("hello");
        // Uwaga! jeżeli pominę nawiasy {} to zostanie wykonana
        // wyłącznie 1, najbliższa instrukcja


        // Zadanie 3
        // Wypisać wszystkie liczby podzielne przez 7
        // w przedziale od 1 do 100
        // Output: 7, 14, 21, ...
        System.out.println("I sposób");
        for (int i = 7; i <= 100; i = i + 1) {
            if (i % 7 == 0) {
                System.out.println(i);
            }
        }

        System.out.println("II sposób");
        for (int i = 7; i <= 100; i = i + 7) {
            System.out.println(i);
        }

        System.out.println("III sposób");
        for (int i = 1; i * 7 <= 100; i = i + 1) {
            System.out.println(i * 7);
        }

        // przecinek w pętli - 2 iteratory

        // Ćwiczenie 3
        // Wypisywać 2 liczby a i b (począwszy a=3 i b=7),
        // gdzie a - kolejna liczba podzielna przez 3,
        // b kolejna liczba podzielna przez 7, dopóki gdy a lub b jest
        // mniejsze niż 100
        // Wskazówka:
        // && - and (koniunkcja) oba warunki muszą być spełnione
        //      aby całe wyrażenie przyjęło wartość true
        // || - or (alternatywa) wystarczy 1 warunek spełniony aby
        //      całe wyrażenie przyjęło wartość true
        System.out.println("Ćwiczenie 3");
        for (int a = 3, b = 7; a < 100 || b < 100; a = a + 1, b = b + 1) {
            if (a % 3 == 0) {
                System.out.println("a: " + a);
            }
            if (b % 7 == 0) {
                System.out.println("b: " + b);
            }
        }

        // Uwaga! wszystkie elementy tej pętli są opcjonalne

        // operatory inkrementacji i dekrementacji
        // są często stosowane w pętlach for
        // i = i + 1 <=> ++i;

        // operator preinkrementacji - ++i
        int i = 0;
        System.out.println(++i); // 1

        // operator postinkrementacji - i++
        i = 0;
        System.out.println(i++); // 0, dlaczego?
        // zwracana jest wartość przed powiększeniem o 1

        i = 0;
        System.out.println(i++ + i); // 1
        System.out.println(i); // 1
        // i += 1 <=> i = i + 1
        // i += 0.1 <=> i = i + 0.1

        i = 0;
        i += 10; // <=> i = i + 10
        System.out.println(i); // ?

        i = 0;
        i += i++; // <=> i = i + i++
        System.out.println(i); // 0

        i = 0;
        i += ++i + i++; // <=> i = i + ++i + i++ <=> i = 0 + 1 + 1
        System.out.println(i); // 2

        i = 0;
        i += i++ + ++i; // <=> i = 0 + 2
        System.out.println(i); // 2

        // zadanie domowe dla ambitnych
        // a)
        i = 0;
        int j = 0;
        j = -i++ + + +-++j;

        // b) wskazówka: | - operator alternatywy bitowej
        i = 0;
        j = 0;
        j = --i | -i++ + + +-++j | i--;

        // operatory bitowe...
        // | - alternatywa bitowa np. 1 | 0 -> 1 OR 0 = 1
        // & - koniunkcja bitowa np. 1 & 0 -> 1 AND 0 = 0
        // ~ - negacje np. ~1 -> NOT 1 = 0
        // ^ - alternatywa wykluczająca np. 1 ^ 0 -> 1 XOR 0 = 1

        // >> - przesunięcie bitowe w prawo np. 10 >> 1
        // << - przesunięcie bitowe w lew np. 10 << 100
        // >>> - przesunięcie bitowe w prawo z wypełnieniem zerami

        System.out.println("alternatywa |");
        System.out.println(1 | 1); // 1
        System.out.println(1 | 0); // 1
        System.out.println(0 | 1); // 1
        System.out.println(0 | 0); // 0
        // wniosek: wystarczy, że jedno nie jest fałszem by zdanie było prawdziwe

        System.out.println("koniunkcja &");
        System.out.println(1 & 1); // 1
        System.out.println(1 & 0); // 0
        System.out.println(0 & 1); // 0
        System.out.println(0 & 0); // 0
        // oba muszą być prawdziwe by całe zdanie było prawdą

        System.out.println("negacja ~");
        System.out.println(~0);
        System.out.println(~1);
        // mam 1 byte
        byte b = 2; // 0000 0010
        b = 4;      // 0000 0100
        b = -128;      // 1000 0000 //
        System.out.println((byte) 128); // -128
        System.out.println((byte) 129); // -127
        System.out.println((byte) 255); // -1, 1111 1111
        // ZASTOSOWANIE: FLAGI, maski
        // 0111 1011
        // 0000 0001
        // 0000 0001
        // 255.255.255.0 - 1111 1111, 1111 1111, 1111 1111, 0000 0000

        System.out.println("alternatywa wykluczająca ^");
        System.out.println(1 ^ 1); // 0
        System.out.println(1 ^ 0); // 1
        System.out.println(0 ^ 1); // 1
        System.out.println(0 ^ 0); // 0
        // zdanie jest prawdziwe tylko wtedy gdy wartości są różne


        System.out.println("operatory przesunięć bitowych");
        System.out.println(1 << 0); // 1  - 2^0
        System.out.println(1 << 1); // 2  - 2^1
        // 1 << 1 -> 0000 0010 -> 2
        System.out.println(1 << 2); // 4  - 2^2
        // 1 << 2 -> 0000 0100 -> 4
        System.out.println(1 << 3); // 8  - 2^3
        System.out.println(1 << 4); // 16 - 2^4

        System.out.println(2 << 4); // 32 - 2^5

        System.out.println(8 >> 1); // 4
        System.out.println(8 >> 2); // 2
        System.out.println(8 >> 3); // 1

        System.out.println(-8 >> 1); // -4
        System.out.println(-8 >> 2); // -2
        System.out.println(-8 >> 3); // -1
        // przesunięcie bitowe liczby x w lewo o y jest równoznaczne
        // z pomnożeniem liczby x przez 2 do potęgi y

        // przesunięcie bitowe liczby x w prawo o y jest równoznaczne
        // z podzielniem liczby x przez 2 do potęgi y

        // przesunięcie bitowe z wypełnianiem
        System.out.println(-8 >>> 3); // do przeanalizowania w domu dla ambitnych

        // operatory przypisania
        i = 1;
        i += 1;
        i -= 1;
        i *= 1;
        i /= 1;
        i |= 1;
        i &= 1;
        i ^= 1; // i = i ^ 1;
        i >>= 1;
        i <<= 1;
        i >>>= 1; // i = i >>> 1

        // pętle a tablice...

        // Ćwiczenie
        // Wypełnić tablicę 100 elementową kolejnymi liczbami całkowitymi
        // począwszy od 0.
        // Następnie wypisać ją w odwrotnej kolejności.
        int[] tab1 = new int[100]; // mamy indeksy: 0 - 99
        // I sposób
//        tab1[0] = 1;
//        tab1[1] = 2;
//        tab1[2] = 2;
//        // ...
//        tab1[100] = 100;

        // II sposób
        // wypełnienie tablicy
        for (int k = 0; k < tab1.length; k++) {
            tab1[k] = k;
        }
        // wypisanie tablicy
        for (int k = 99; k >= 0; k--) {
            System.out.println(tab1[k]);
        }

        // pomocnicza metoda, jeżeli chcemy np. wyświetlać reprezentację bitową bajta
        System.out.println(Integer.toBinaryString(-8 & 0xFF));

        // pętla while
        // while (warunek) {
        //      instrukcje...
        // }
        // instrukcje będą wykonywane dopóki warunek będzie spełniony

        // instrukcja break; przerywa wykonywanie pętli (opuszczamy pętle)

        // Ćwiczenie
        // Wypisywać losowe liczby całkowite z zakresu 0:100 do momentu gdy wylosujemy liczbę 44
        Random random = new Random();
        // I sposób
        System.out.println("while");
        int randInt = 0;
        while (randInt != 44) {
            randInt = random.nextInt(100);
            System.out.println(randInt);
        }
        // II sposób - pętla for
        System.out.println("for");
        for (randInt = 0; randInt != 44; randInt = random.nextInt(100)) {
            System.out.println(randInt);
        }
        System.out.println(randInt); // musi być ponieważ, gdy wylosujemy 44 nie będziemy już jej wypisywać w ciele pętli

        // do-while
        System.out.println("do-while");
        do {
            randInt = random.nextInt(100);
            System.out.println(randInt);
        } while (randInt != 44 && randInt != 66);
        // losuj dopóki randInt nie jest 44 i nie jest 66

        System.out.println("pętla nieskończona + break");
        do {
            randInt = random.nextInt(100);
            System.out.println(randInt);
            if (randInt == 44 || randInt == 66) {
                break;
            }
        } while (true);


        // jedyna różnica w stosunku do while jest taka, że sprawdzanie warunku
        // wykonujemy dopiero po wykonaniu pierwszej iteracji


        // metody

        // klasy

    }

    // zadanie domowe, podzielić na metody poczatek zajęć
}
