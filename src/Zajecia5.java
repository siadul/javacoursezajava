import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Zajecia5 {
    public static void main(String[] args) {
//        strings();
//        regex();
//        ex2();
//        ex3();
//        ex5();
        // nty wyraz ciągu: an = q^(n-1) * a1
        // suma wyrazów ciągu geometrycznego: Sn = a1(1 - q^n)/(1-q)
//        ex7();
         regexEx1();
    }

    private static void regexEx1() {
        // Przykład:
        // Znaleźć wszystkie podciągi pasujące do uproszczonego wzorca adresu email
        // [znaki alfanumeryczne]@[znaki alfanumeryczne].[znaki alfanumeryczne] w zmiennej str1 wczytywanej z klawiatury
        // Uwaga! . - w wyrażeniach regularnych oznacza dowolny znak
//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.nextLine();
//        System.out.println(input);
//        Pattern pat = Pattern.compile("[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]{2,}");
//        Matcher mat = pat.matcher(input);
//        while(mat.find()) {
//            System.out.println(mat.group());
//        }

        // Przykład:
        // Znaleźć wszystkie nazwiska w stringu wejściowym, zakładając, że nazwisko musi
        // zaczynać się z dużej litery oraz składać z liter bądź znaku -
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(input);
        Pattern pat = Pattern.compile("[A-Z][a-z-]+[A-z][a-z]+");
        Matcher mat = pat.matcher(input);
        while(mat.find()) {
            System.out.println(mat.group());
        }

        // zadanie domowe - skończyć ten przykład
    }

    private static void ex7() {
        A a = new A();
        String initials = A.getInitials("Krzysztof", "Krzysztofowicz");
        System.out.println(initials);

//        String invertedInitials = B.getInvertedInitials("Krzysztof", "Krzysztofowicz");
        // to wyżej nie zadziała, metoda jest nie statyczna tym razem

        B b = new B();
        String invertedInitials = b.getInvertedInitials("Krzysztof", "Krzysztofowicz");
        System.out.println(invertedInitials);
    }

    private static void ex5() {
        System.out.println(geometricTest(10, 0) + "\n"); // zbyt mało liczb
        System.out.println(geometricTest(10, 0, 0, 4, 0) + "\n");
        System.out.println(geometricTest(10, 0, 0, 0, 0) + "\n");
        System.out.println(geometricTest(10, 100, 1000, 10000, 100000) + "\n");
        System.out.println(geometricTest(1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1, 0.5) + "\n");
    }

    private static boolean geometricTest(double... doubles) {
        // ciąg geometryczny - ciąg liczb: istnieje stała q dla której zachodzi wzór
        // an = q * an-1
        // q = an/an-1, an-1 != 0
        boolean isGeometric = true;

        if(doubles.length < 5) {
            System.out.println("zbyt mało liczb");

            return false;
        }

        boolean isGeometricZero = true;
        for (int i=1; i<doubles.length; i++) {
            if(doubles[i] != 0) {
                isGeometricZero = false;
                break;
            }
        }
        if (isGeometricZero) {
            System.out.println("ciąg geometryczny, q = 0");

            return true;
        }

        double q = doubles[1]/doubles[0];
        for(int i=1; i<doubles.length; i++) {
            if(doubles[i]/doubles[i-1] != q) {
                return false;
            }
        }
        System.out.println("q = " + q);

        return isGeometric;
    }

    private static void ex2() {
        sortMin(4.03, 5.2, 7.2, 2, 0.02);
    }

    private static void ex3() {
        double[] arr = new double[]{4.03, 5.2, 7.2, 2, 0.02};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(sortMax(arr)));
        System.out.println(Arrays.toString(arr));
    }

    private static double[] sortMax(double[] doubles) {
        // I sposób
        double[] result = Arrays.copyOf(doubles, doubles.length);

        // II sposób - przepisać elementy do nowej tablicy przy użyciu pętli


        Arrays.sort(result);
        // Uwaga! Arrays.sort modyfikuje tablice podaną jako argument zamiast
        // zwracać nowej. Jeżeli nie jest to dla mnie oczekiwane zachowanie to muszę
        // wcześniej wykonać kopię tablicy wejściowej.

        return result;
    }

    private static void sortMin(
            double d1,
            double d2,
            double d3,
            double d4,
            double d5
            ) {
        double[] arr1 = {d1, d2, d3, d4, d5};

        // I sposób:
        // sortowanie przez wybieranie/wstawiawnie/bądź sortowanie bąbelkow lub inne
        // quicksort

        // II sposób - sort z comparatorem - dla ambitnych
//        Double[] arr2 = {d1, d2, d3, d4, d5};
//        Arrays.sort(arr1);
//        Arrays.sort(arr2, new Comparator<>(){
//            @Override
//            public int compare(Double aDouble, Double t1) {
//                return ?;
//            }
//        });
        System.out.println(Arrays.toString(arr1));

        /// III sposób - sort, wypisanie tablic od końca
        Arrays.sort(arr1);
        for (int i=arr1.length - 1; i>=0; i--) {
            System.out.println(arr1[i]);
        }
    }


    private static void regex() {
        // Wyrażenie regularne regex/regexp - służą do wyszukiwania/przetwarzania ciągów znaków
        // klasy Pattern i Matcher
        // Przykład:
        // Znaleźć ciąg znaków składający się z 3 cyfr w obrębie stringa "Ala ma 999 kotów"

        Pattern pat;
        Matcher mat;
        boolean found;

//        pat = Pattern.compile("\d\d\d"); // "\d"
        pat = Pattern.compile("\\d\\d\\d"); // "\d"
        mat = pat.matcher("Ala ma 999 kotów");
        found = mat.matches(); // czy string "Ala ma 999 kotów" składa się z 3 cyfr?
        System.out.println(found);
        mat = pat.matcher("999");
        found = mat.matches();
        System.out.println(found);

        // Klasa znaków
        // \d - cyfra
        // \D - wszystko poza cyfrą
        // . - dowolny znak
        // \s - biały znak np. spacja ale również znak tabulacji
        // \S - wszystko poza białym znakiem
        // \w - znak mogący tworzyć słowo
        // \W - wszystko poza znakiem mogącym tworzyć słowo
        // \n - znak końca lini
        // \t - znak tabulacji

        // Operatory
        // * - powtórzenie dowolnej liczby razy
        // + - oznacza powtórzenie znaku stojącego przed nim co najmniej 1 raz.
        //     Uwaga! jest to operator zachłanny tzn. dopasowuje najdłuższy możliwy ciąg znaków.
        // +? - to co wyżej, operator leniwy
        // {1,3} - oznacza powtórzenie znaku stojącego przed nim co najmniej 1 raz ale nie więcej niż 3
        // ? - może wystąpić co najwyżej 1 raz
        // (?=) - operator przewidywania
        // (?<=) - operator przewidywania wstecznego
        // [znaki] - dowolny znak ze zbioru 'znaki'

        // Grupy - wybieramy określony podciąg z ciągu znaków pasującego do zdefiniowanego wzorca.
        //         tworzymy je za pomocą nawiasów '(' i ')'


        // Przykład
        // Sprawdzić czy dany ciąg wejściowy składa się z cyfr
        pat = Pattern.compile("\\d+");
        mat = pat.matcher("999a");
        System.out.println(mat.matches());
        mat = pat.matcher("99999999999");
        System.out.println(mat.matches());

        // Przykład:
        // Sprawdzić czy w obrębie stringu "Ala ma 999 kotów" występuje ciąg znaków składający się z 3 cyfr
        pat = Pattern.compile("\\d\\d\\d");
        mat = pat.matcher("Ala ma 999 kotów");
        found = mat.find();
        System.out.println(found);

        // Wniosek:
        // matches - sprawdza czy cały string wejsciowy pasuje do wzorca
        // find - sprawdza czy w obrębie tego stringa występuje string pasujący do wzorca

        // Przykład:
        // Pobrać numer telefonu ze zmiennej. Walidować je przy pomocy wzorców. Numer telefonu powinien być w formacie
        // 9cyfr (3grupy po 3znaki, między grupami może być znak spacji) poprzedzonych ewentualnie prefixem ze znakeim +
        // np. +48 564 876 123, +48767898653, 534534534
        pat = Pattern.compile("((\\+\\d{1,3})?)( ?\\d{3}){3}");
        System.out.println(pat.matcher("+48 564876123").matches());
        System.out.println(pat.matcher("+48 564 876 123").matches());
        System.out.println(pat.matcher("564876123").matches());

        // Uwaga! znak + ma szczególne znaczenie w przypadku wyrażeń regularnych, aby odebrać mu "moc" musimy
        // go "wyescapować" przy pomocy znaku '\'

        // Istnieje wiele różnych stron pomocnych do tworzenia/testowania wyrażeń regularnych np.
        // https://regexr.com/

        // replaceAll - z regex
        String s = "Ala98 ma 5 kotów";
        // Przykład
        // Usunąć wszystkie cyfry ze stringa s.
        System.out.println(
                s.replaceAll("\\d", "")
        );

        // Przykład
        // Zamienić wszystkie odstępy miedzy słowami, które składają z większej liczby białych znaków niż 1
        // na pojedyczne spacje
        System.out.println(
                "Ala        ma      \nkotów".replaceAll("\\s*", " ")
        ); //  A l a  m a  k o t ó w
        System.out.println(
                "Ala        ma      \nkotów".replaceAll("\\s+", " ")
        );

        pat = Pattern.compile("e.+d");
        mat = pat.matcher("extend cup end table");
        while(mat.find()) {
            System.out.println("Dopasowana sekwencja: " + mat.group());
        }

        System.out.println("Leniwa wersja kwantyfikatora +");
        pat = Pattern.compile("e.+?d"); // dopasowanie najkrótszych podciągów pasujących do wzorca
        mat = pat.matcher("extend cup end table");
        while(mat.find()) {
            System.out.println("Dopasowana sekwencja: " + mat.group());
        }


        // split - przeciwieństwo metody join - dzielimy stringa na tablicę stringów przy pomocy separatora
        pat = Pattern.compile("[,.;]");
        String strs[] = pat.split("one two,alpha9.12;done.");
        System.out.println(Arrays.toString(strs));

        // Przykład
        // Sprawdzić czy ciąg znaków sklada się z samych liter bądź cyfr.
        pat = Pattern.compile("[a-z0-9]+");
        mat = pat.matcher("894nr sth");
        System.out.println(mat.matches());
        mat = pat.matcher("894nrsth");
        System.out.println(mat.matches());
    }

    private static void strings() {
        String str1 = new String("my first string");
        String str2 = "my second string"; // literały
        System.out.println(str1);
        System.out.println(str2);

        char chars[] = {'a', 'b', 'c'};
        char chars2[] = new char[3];
        chars2[0] = 'a';
        chars2[1] = 'b';
        chars2[2] = 'c';
        String str3 = new String(chars);
        System.out.println(str3);

        System.out.println("def");

        System.out.println(str1.length());

        String name = "Krzysztof";
        String surname = "Krzysztofowicz";
        System.out.println(name + " " + surname); // StringBuilder/StringBuffer

        // mogę mieszać typy w przypadku konkatenacji
        System.out.println("years: " + 40);

        // ale uwaga na pułapkę
        System.out.println("years: " + 40 + 40);
        System.out.println("years: " + (40 + 40));


        // metoda toString
        C c = new C();
        System.out.println(c);
        System.out.println(c.toString());

        // Wniosek
        // Jeżeli chcę zdefiniować własny sposób wypisywania obiektów
        // to wówczas przesłaniam metodę toString()

        // wyodrębnianie znaków - charAt
        // Przykład:
        // Wypisać 3 znak imienia
        System.out.println(name.charAt(2)); // Uwaga! Indeks zaczyna się od 0

        // getChars - wyodrębniamy więszka liczbę znaków
        String s = "getChars example";
        int start = 3;
        int end = 5;
        char buf[] = new char[end - start];
        s.getChars(start, end, buf, 0);
        System.out.println(buf);

        // getBytes - zwraca tablicę bajtów
        String s2 = "abc";
        System.out.println(Arrays.toString(s2.getBytes()));
        System.out.println((byte)'a');

        // char[] toCharArray()
        String s3 = "ala ma kota";
        System.out.println(Arrays.toString(s3.toCharArray()));


        // Porównywanie łańcuchów znaków
        C c1 = new C();
        C c2 = new C();
        System.out.println(c1 == c2); // UWAGA! Pułapka, porównujemy referencje, a nie pola
        String ss1 = new String("a");
        String ss2 = new String("a");
        String ss3 = "a";
        String ss4 = "a";
        System.out.println(ss1 == ss2);
        System.out.println(ss3 == ss4);

        // UWAGA! do porównywania stringów używamy metody equals
        // equals()
        System.out.println(ss1.equals(ss2));
        System.out.println(ss3.equals(ss4));

        // Porównywanie bez uwzględniania wielkości liter
        String ss5 = "ala";
        String ss6 = "Ala";
        System.out.println(ss5.equalsIgnoreCase(ss6));

        // inny sposób - toLowerCase/toUpperCase
        System.out.println(ss5.toLowerCase());
        System.out.println(ss6.toLowerCase());
        System.out.println(ss5.toLowerCase().equals(ss6.toLowerCase()));

        // regionMatches - porównuje konkretne podciągi
        // Przykład:
        // porównać ze sobą 2 i 3 literę stringów ss5 i ss6
        System.out.println(ss5.regionMatches(1, ss6, 1, 2));

        // Przykład 2:
        // Porównać 2 i 3 literę ze Stringa "Kot" z 1 i 2 literą "Ottis"
        // nie zważając na wielkość liter
        System.out.println("Kot".regionMatches(true, 1, "Ottis", 0, 2));

        // alternatywa - stworzenie 2 podciągów, porównanie metodą equals
        // startsWith i endsWith
        System.out.println("Kotwica".startsWith("Kot"));
        System.out.println("Kotwica".endsWith("wica"));

        // compareTo
        // Przykład:
        // Posortować tablicę łancuchów.
        String[] arr = {
                "Nadszedł", "czas", "by", "każdy", "szanujący", "się", "obywatel", "pomógł",
                "swojemu", "krajowi", "jak", "tylko", "potrafi"
        };

        // int compareTo(String str)
        // jeżeli oba stringi są równe to compareTo -> zwraca 0
        // jeżeli wywołany obiekt zawiera łańcuch 'mniejszy' od str -> zwraca wartość mniejszą od 0
        // jeżeli wywołany obiekt zawiera łańcuch 'większy' od str -> zwraca wartość większą od 0

        for(int j = 0; j < arr.length; j++) {
            for(int i = j + 1; i < arr.length; i++) {
                if(arr[i].compareTo(arr[j]) < 0) {
                    String t = arr[j];
                    arr[j] = arr[i];
                    arr[i] = t;
                }
            }
        }

        System.out.println(Arrays.toString(arr));

        // jeżeli nie interesuje nas wielkość liter przy porównaniu

        String[] arr2 = {
                "Nadszedł", "czas", "by", "każdy", "szanujący", "się", "obywatel", "pomógł",
                "swojemu", "krajowi", "jak", "tylko", "potrafi"
        };
        for(int j = 0; j < arr2.length; j++) {
            for(int i = j + 1; i < arr2.length; i++) {
                if(arr2[i].compareToIgnoreCase(arr2[j]) < 0) {
                    String t = arr2[j];
                    arr2[j] = arr2[i];
                    arr2[i] = t;
                }
            }
        }

        System.out.println(Arrays.toString(arr2));

        searching();
        modifying();
    }

    private static void modifying() {
        // UWAGA!!!
        // Stringi są niemutowalne.
        // Co to znaczy, że obiekt jest niemutowalny?
        // To znaczy, że nie jesteśmy w stanie zmodyfikować jego stanu. Możemy jedynie tworzyć nowe
        // w oparciu o niego.

        // String substring(int startIndex, int endIndex)
        String s = "Ala ma kota";
        System.out.println(s.substring(4, 6));
        System.out.println(s.substring(4));

        System.out.println(s.concat(s));
        System.out.println(s + s);

        // replace
        // String replace(char origin, char replacement)
        System.out.println(s.replace('a', 'o')); // zamieniamy wszystkie wystąpienia 'a' na 'o'
        System.out.println(s.replace("Ala", "Bob"));
        System.out.println(s.replaceFirst("a", "an")); // regex - wzorzec regularny
        System.out.println(s.replaceAll("a", "an")); // to samo co replace, ale argument
                                                                    // to regex - wzorzec regularny
        // Usuwanie białych znaków z przodu i z końca stringu - String trim()
        System.out.println("    \t\tAla ma kota           \n\n\n");
        System.out.println("    Ala ma kota           \n\n\n".trim());

        // static valueOf - konwertowanie danych na postać łańcuchową
        System.out.println(
                String.valueOf(4)
        );
        String s3 = String.valueOf(4);
        System.out.println(s3.getClass().getName());

        // static String valueOf(char chars[], int startIndex, int numChars)
        System.out.println(String.valueOf(new char[]{'a', 'b', 'c'}, 1, 2));

        double d = 10e5+0.001;
        String sd = String.valueOf(d);
        System.out.println(sd); // 1000000.001

        // Mamy inną reprezentację niż format inicjalizacji. A zatem, jeżeli potrzebujemy uzyskać reprezentację
        // tekstową używamy metody String.valueOf


        // static join - łączenie łańcuchów ze zdefiniowanym separatorem
        // Przykład:
        // Utworzyć string w oparciu o tablice stringów dodajać separator ", " między wyrazami.
        System.out.println(
                String.join(",", "Ala", "ma", "kota", "oraz", "psa")
        );
        String[] sArr= {"Jabłko", "Banan", "Cytryna"};
        String sTemp = String.join(", ", sArr);
        System.out.println(sTemp);

        // gdybyśmy robili to przy pomocy operatora konkatenacji:
        String result = "";
        for (String str: sArr) {
            result += str + ", "; // taka operacja jest nie efektywana
        }
        int lastIndex = result.lastIndexOf(", ");
        String str = result.substring(0, lastIndex);
        System.out.println(str);

        // Uwaga! Przy każdej iteracji tworzony jest nowy obiekt String.

        // lepszym rozwiązaniem jest użycie MUTOWALNYCH klas:

        // StringBuffer albo StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("ala");
        sb.append("ma");
        sb.append("kota");
//        System.out.println(sb.toString());
        System.out.println(sb);


        StringBuilder sb2 = new StringBuilder();
        for (String str2: sArr) {
            sb2.append(str2);
            sb2.append(", ");
        }
        lastIndex = result.lastIndexOf(", ");
        sb2.delete(lastIndex, lastIndex + ", ".length());
        System.out.println(sb2);

        // Podsumowanie
        // Jeżeli dokonuje operacji modyfikacji dla wielu Stringów - korzystam z obiektów klas mutowalnych
        // takich jak StringBuilder/StringBuffer
        // W przeciwnym wypadku korzystam ze zwyczajnej klasy String

        // StringBuffer jest bezpieczna pod kątem wielowątkowości, więc używamy jej np. w przypadku aplikacji
        // z interfesjem GUI
        // StringBuilder jest wydajniejsza, ale nie bezpieczna pod kątem wielowątkowości.
    }

    private static void searching() {
        String s1 = "Ala ma kota";
        // Przykład:
        // Znaleźć pierwsze wystąpienie literki 'a' w Stringu s1. Podać pozycję na której stoi.
        // indexOf
        System.out.println(s1.indexOf('a'));

        // lastIndexOf
        System.out.println(s1.lastIndexOf('a'));

        // Przykład:
        // Znaleźć pierwsze wystąpienie literki 'a' począwszy od 5 znaku.
        System.out.println(s1.indexOf('a', 5));
        System.out.println(s1.indexOf('a', 6));

        System.out.println(s1.lastIndexOf('a', 10));


        // Wyszukiwanie podciągów
        System.out.println(s1.indexOf("kot"));
        System.out.println(s1.lastIndexOf("kot")); // to samo tylko wyszukujemy od tyłu

        System.out.println(s1.indexOf("pies")); // -1
        // Jeżeli dany znak lub podciąg nie występuje w obrębie stringu wejściowego to indexOf zwraca -1

        System.out.println(s1.indexOf("pies")); // -1


        System.out.println("kot ma kota".indexOf("kot"));
        System.out.println("kot ma kota".lastIndexOf("kot")); // to samo tylko wyszukujemy od tyłu
        System.out.println("kot ma kota".indexOf("kot", 1)); // możemy przekazywać offset
    }
}

class C {
    int f1 = 4;

    @Override
    public String toString() {
        return "{" + "f1: " + f1 + '}';
    }
}

class A {
    static String getInitials(String name, String surname) {
//        return new String(new char[]{name.charAt(0), surname.charAt(0)});
//        return String.valueOf(name.charAt(0)) + String.valueOf(surname.charAt(0));
        return "" + name.charAt(0) + surname.charAt(0);
    }

}
class B {
    String getInvertedInitials(String name, String surname) {
        return "" + name.charAt(name.length()-1) + surname.charAt(surname.length()-1);
    }
}