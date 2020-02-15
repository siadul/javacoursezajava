import java.util.Arrays;

// klasa
public class Zajecia1 {

    // metoda (główna)
    // każdy program, który uruchamiamy musi mieć metodę główną
    // czyli miejsce od którego zaczyna się wykonywać kod

    /**
     * Metoda wypisuje informacje odnośnie typów zmiennych itp.
     *
     * @param args - argumenty z konsoli
     */
    public static void main(String[] args) {
        // Ćwiczenie 1

        // main - nazwa metody
        // String[] args - lista argumentów

        // Przykłady:
        // sin(x) - metoda(funkcja) sin, argument x

        // asin(x) - metoda(funkcja) asin, argument x należy do <-1, 1>
        // String[] - typ argumentu
        /* System.out.println("Hello world1");
        System.out.println("Hello world2");
        System.out.println("Hello world3"); */
        // System.out.println("Hello world4");

        // co to jest zmienna?
        // to fragment pamięci w którym możemy przechowywać pewne wartości określonego typu
        // do którego odwołujemy się za pomocą adresu

        // bit - 0,1
        // 1101110111011101110111011101110111011101110111011101110111011101
        // 00000001 - 64bit
        // 00000002 -
        // 00000003 -

        // bajt = 8bitów
        // 1111 1111 - 0-255, ponieważ musimy przechowywać liczby ujemne dzielimy przedział
        // "na pół"

        // możliwe typy zmiennych
        // * - najczęściej używane

        // TYPY PODSTAWOWY
        // całkowite
        // byte - 1 bajt - zakres od -128 do 127 (przydatny w obsłudze strumieni) np. 8
        // short - 2 bajty - zakres od -32 768 do 32 767 np. -23
        // *int - 4 bajty - zakres od -2 147 483 648 do 2 147 483 647
        //                  np. 1, 2, 3, 404, -543
        // long - 8 bajtów - zakres od -2^63 do (2^63)-1 (posiadają przyrostek L, lub l)
        //                   np. 3l

        // zmiennoprzecinkowe
        // float - 4 bajty - max ok 6-7 liczb po przecinku (posiadają przyrostek F, lub f)
        //                   np. 4.3f
        // *double - 8 bajtów - max ok 15 cyfr po przecinku (posiadają przyrostek D, lub d)
        //                      np. 4.3

        // logiczny
        // boolean - true/false np. true, false

        // znakowy
        // char - 1 znak np. 'a', b', '2'

        // TYPY OBIEKTOWE
        // String - do obsługi łańcuchów znaków np. "zajava", tworzy się np. przy pomocy znaku "
        // Array - tablice - pozwalają przechowywać serie wartości tego samego typu
        // Inne (własne utworzone za pomocą class) - np. Zajecia1


        // Komentarze - bloki kodu nie brane pod uwagę przez kompilator
        //      //                      - jednoliniowe
        //      /* kod zakomentowany */ - wieloliniowe
        //      /** */                  - dokumentujący m.in. do generowania dokumentacji np. za pomocą JavaDoc

        // Przydatny skrót: Ctrl + '/'  - zakomentuj/odkomentuj

        // Ćwiczenie 2
        // Napisać program, który dodaje dwie wartości typu short i wypisuje sumę na
        // standardowe wyjście
        System.out.println((short) ((short) 32767 + (short) 32767)); // 19998
        // ponieważ suma tych 2 liczb nie mieści się w zakresie możliwych liczby short zostanie
        // ona ucięta (nie zaokrąglona) do możliwej do zapisania wartości typu short

        short short1; // deklarcja zmiennej
        short1 = 32767; // przypisanie
        short short2;
        short2 = 32767;
        short short3;
        short3 = (short) (short1 + short2);
        System.out.println(short3);

        // (short)4 - rzutuję liczbę na typ short

        // Ćwiczenie 3
        // Wypisać różnicę dwóch bajtów.
        byte byte1 = 7; // mogę przypisywać jednocześnie z deklaracją zmiennej
        byte byte2 = 10, byte3, byte4, byte5 = 0;
        byte3 = (byte) (byte1 - byte2);
        System.out.println(byte3);
        System.out.println(byte5);

        // przed użyciem zmiennej musi być ona zawsze ZAINICJALIZOWANA
        int i1 = 45;
        long l1 = 55;
        long l2 = i1 + l1;
        System.out.println(l2);
        System.out.println(55);
        System.out.println(55l);
        // literka l po liczbie oznacza wymuszenie użycia typu long

        // uwaga na operacje dzielenia na liczbach całkowitych!
        System.out.println(3 / 2); // zostaje ucięta część ułamkowa ponieważ 3 i 2 są całkowite
        System.out.println((double) 3 / 2); // 1.5 - konwertuje liczbę całkowitą 3 typu int
        // na typ zmiennoprzecinkowy, a nastepnie dzielę przez 2
        // efektem dzielenie liczb zmiennoprzecinkowych jest również wartośc zmiennoprzecinkowa
        System.out.println(3.0 / 2); // 1.5 - tutaj bezpośrednio wskazuje typ liczby 3
        System.out.println(3. / 2); // 1.5
        System.out.println(.2 / 2); // 0.2 / 2 = 0.1

        System.out.println(.2f / 2); // 0.1, f - wymusza typ float

        System.out.println(2E3); // notacja naukowa
        System.out.println(2e3); // notacja naukowa
        System.out.println(1e-3); // notacja naukowa

        System.out.println(071); // system oktalny (ósemkowy)
        System.out.println(0xFF); // system heksadecymlany (szesnatkowy)
        // 10 - A
        // 11 - B
        // 12 - C
        // 13 - D
        // 14 - E
        // 15 - F

//        np. kolory są często zapisywane za pomocą byteów lub hexów
//        rgb(255, 255, 200)
//        #0099FF

        boolean boolean1 = true;
        boolean boolean2 = false;
        System.out.println(boolean1);
        System.out.println(boolean2);
        System.out.println(boolean1 && boolean2);

        // char
        char ch1 = 'K'; // uwaga! nie "";
        System.out.println(ch1);

        // obiektowe
        // String
        String str1 = "KLM"; // uwaga! nie '';
        System.out.println(str1);

        // łączenie stringów...
        System.out.println("Wartość str1 wynosi: " + str1); // konkatenacja - łączenie stringów

        int i = 45;
        System.out.println("Wartość str1 wynosi: " + 45); // konkatenacja - łączenie stringów

        // Uwaga! Pułapka
        System.out.println("Wartość str1 wynosi: " + 45 + 55); // konkatenacja - łączenie stringów
        System.out.println("Wartość str1 wynosi: " + (45 + 55)); // nawias gwarantuje nam pierwszeństwo
        // wykonania sumowania

        // tablice (Array)
        int ii1;
        int ii2;
        int ii3;
        // ...
        int ii100;
        // zamiast tworzenia 100 zmiennych mogę stworzyć tablicę 100-elementową
        int[] iiTab1 = new int[100];
        // int[] - oznacza zadeklaruj zmienną typu tablica liczb integer (int)
        // albo
        int[] iiTab2 = {1, 2, 3};
        // UWAGA! tablice w języku Java zawsze indeksujemy począwszy od 0
        int x0 = iiTab2[0]; // iiTab2[0] oznacza zwróć wartość elementu o indeksie 0
        int x1 = iiTab2[1];
        int x2 = iiTab2[2];
        System.out.println(x0);
        iiTab2[2] = 10;
        System.out.println(iiTab2); // [I@7699a589
        // jeżeli przekazujemy typ obiektowy np. Array, Zajecia1 do metody
        // System.out.println to wówczas wypisywany jest ciąg znaków, który składa się z
        // prefixu odpowiedniego dla typu obiektu [I, separatora @ oraz hashCode
        System.out.println(Arrays.toString(iiTab2)); // [1, 2, 10]
        System.out.println(iiTab2[0]);
        System.out.println(iiTab2[1]);
        System.out.println(iiTab2[2]);
        System.out.println(iiTab2.length); // length zwraca liczbę elementów w tablicy

        // Uwaga! Stringi to również obiekty!
        String str2 = "Jakiś tekst";
        System.out.println(str2.toLowerCase()); // np. toLowerCase to metoda,
        // która zmienia wielkość liter na małe
        // Stringi mimo, że są obiektami to przekazywane do println będą wypisywane
        // w "normalny" sposób
        System.out.println(str2.toLowerCase()); // np. toLowerCase to metoda,

        // obiekty (wartości typów obiektowych) tworzymy przy pomocy
        // operatora new (wyjątek: String oraz Array)
//        String str3 = new String("jakiś tekst");
        // równoważnie:
//        String str3 = "jakiś tekst";

//        int[] arr1 = new int[2];
        // równoważnie:
//        int[] arr1 = {0, 0};

        // zakres widzialności zmiennych
        {
            int b = 6;
            {
                int a = 5;
                System.out.println(b); // zmienna utworzona w zakresie zewnętrznym jest
                // widoczna w zakresie wewnetrznym
            } // tutaj zmienna a kończy swoje życie (jest usuwana ze stosu)

//            System.out.println(a); // błąd! nie działa to w drugą stronę! tzn.
//            // zmienna tworzona w zakresie wewnętrznym nie jest widoczna
//            // z poziomu zakresu zewnętrznego
        }

        int a = 4; // jestem w stanie deklarować ponownie zmienną a, mimo że była
        // deklarowana wcześniej (ale w bloku wewnętrznym)
        System.out.println(a);

        // nie mogę "nadpisywać deklaracji zmiennych"
        {
            int c = 6;
//            int c = 10; // błąd
            {
//                int c = 7; // błąd, 'c' już zadeklarowana
            }
//            int c = 10; // błąd
        }

        // instrukcje warunkowe "if"
        // składnia
//        if (warunek) {
//            kod wykonywany gdy warunek jest prawdziwy
//        }

//        lub
//
//        if (warunek) {
//            kod wykonywany gdy warunek jest prawdziwy
//        } else {
//            kod wykonywany gdy warunek jest NIE prawdziwy
//        }
//
//        lub

//        if (warunek1) {
//            kod wykonywany gdy warunek1 jest prawdziwy
//        } else if(warunek2) {
//            kod wykonywany gdy warunek1 jest NIEPRAWDZIWY oraz warunek2 jest prawdziwy
//        } else {
//            kod wykonywany gdy warunek1 jest NIEPRAWDZIWY oraz warunek2 jest NIEPRAWDZIWY
//        }

        // Ćwiczenie
        // Wypisać komunikat "dzieli się 2", jeżeli liczba dzieli się przez 2 bez reszty
        // W przeciwnym wypadku wypisać "nie dzieli się przez 2"
        int liczba1 = 9;
        int liczba2 = liczba1/2; // 4
        int liczba3 = liczba2*2; // 8
        if (liczba1 == liczba3) {
            System.out.println("dzieli się 2");
        }
        if (liczba1 != liczba3) {
            System.out.println("nie dzieli się 2");
        }

        // II sposób
        if(liczba1 == liczba3) {
            System.out.println("dzieli się 2");
        } else {
            System.out.println("nie dzieli się 2");
        }

        // III sposób
        if(liczba1 == liczba3) {
            System.out.println("dzieli się 2");
        } else if(liczba1 != liczba3) {
            System.out.println("nie dzieli się 2");
        }














    }

}
