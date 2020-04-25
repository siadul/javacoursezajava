package zajecia7;

import java.util.*;

public class Zajecia7 {
    public static void main(String[] args) {
//        arrayList();
//        arraysVsCollections();
        arrayListOperations();
        arrayListSort();
    }

    private static void arrayListSort() {
        // Przykład:
        // Stworzyć kolekcję klasy Cat.
        // Posortować elementy tej kolekcji po polach head oraz paws,
        // w taki sposób, że jeżeli egzemplarze mają taką samą wartość pola head to
        // wówczas sortować po polu paws.
        ArrayList<Cat> arrayList = new ArrayList<>();
        arrayList.add(new Cat(1, 4)); // 6
        arrayList.add(new Cat(1, 2)); // 5
        arrayList.add(new Cat(1, 3)); // 4
        arrayList.add(new Cat(1, 1)); // 3
        arrayList.add(new Cat(0, 4)); // 2
        arrayList.add(new Cat(0, 3)); // 1
        arrayList.add(new Cat(2, 6)); // 8
        arrayList.add(new Cat(2, 5)); // 7
        System.out.println(arrayList);

        arrayList.sort((a, b) -> {
            // wyrażenia warunkowe
//            warunek ? wartość jeżeli warunek : jest prawdziwy wartość jeżeli
//                    warunek jest fałszywy;

            return a.getHeads() == b.getHeads() ?
                    a.getPaws() - b.getPaws() : a.getHeads() - b.getHeads();

//            if (a.getHeads() > b.getHeads()) {
//                return 1;
//            }
//            if (a.getHeads() < b.getHeads()) {
//                return -1;
//            }
//            if (a.getPaws() > b.getPaws()) {
//                return 1;
//            }
//            if (a.getPaws() < b.getPaws()) {
//                return -1;
//            }
//
//            return 0;
        });
        System.out.println(arrayList);
    }

    private static void arrayListOperations() {
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(1);
        arrayList1.add(-10);
        arrayList1.add(3);
        System.out.println(arrayList1);
        arrayList1.add(1, 4);
//        arrayList1.add(1, 4);
        System.out.println(arrayList1);
        // Wniosek:
        // add - wstawia nowy element do kolekcji na wybraną pozycję (domyślnie na koniec)

//        arrayList1.add(10, 6); // IndexOutOfBoundsException

        arrayList1.set(2, 5);
//        arrayList1.set(20, 55); // IndexOutOfBoundsException
        System.out.println(arrayList1);
        // set - podmienia element kolekcji na nowy podany jako argument

        System.out.println(arrayList1.size());

        arrayList1.clear();
        System.out.println(arrayList1.size());

        arrayList1.add(1);
        arrayList1.add(2);
        arrayList1.add(3);
        arrayList1.add(4);
        arrayList1.add(5);
        arrayList1.remove(2);
        System.out.println(arrayList1); // [1, 2, 4, 5]

        ArrayList<Integer> arrayList2 = new ArrayList<>();
        arrayList2.add(1);
        arrayList2.add(5);
        arrayList1.removeAll(arrayList2);
        System.out.println(arrayList1); // [2, 4]

        // contains - zwraca informację o tym czy dany element występuje w kolekcji
        System.out.println(arrayList1.contains(5));
        System.out.println(arrayList1.contains(4));

        arrayList1.add(8);
        arrayList1.add(6);
        System.out.println(arrayList1); // [2, 4, 8, 6]
        List<Integer> arrayList3 = arrayList1.subList(1, 3);
        // Uwaga! subList nie zwraca ArrayList, lecz List
        System.out.println(arrayList3); // [4, 8]

        arrayList3.remove(1);
        System.out.println(arrayList3); // [4]

        System.out.println(arrayList1); // [2, 4, 6]
        System.out.println(arrayList1.indexOf(4)); // 1
        System.out.println(arrayList1.indexOf(40)); // -1

        System.out.println(arrayList1.isEmpty()); // false

        ArrayList<Integer> arrayList4 = new ArrayList<Integer>();
        arrayList4.add(4);
        arrayList4.add(6);
        arrayList4.add(8);
        System.out.println(arrayList1); // [2, 4, 6]
        System.out.println(arrayList4); // [4, 6, 8]
        arrayList1.retainAll(arrayList4);
        System.out.println(arrayList1); // [4, 6]
        // retainAll - usuwa z kolekcji wszystkie elementy, które nie występują
        // w kolekcji podanej jako argument

        arrayList4.add(4);
        System.out.println(arrayList4); // [4, 6, 8, 4]
        System.out.println(
                arrayList4.lastIndexOf(4)
        );

        System.out.println(arrayList1); // [4, 6]
        System.out.println(arrayList4); // [4, 6, 8, 4]
        arrayList4.addAll(arrayList1);
        arrayList4.addAll(arrayList4);
        System.out.println(arrayList4); // [4, 6, 8, 4, 4, 6, 4, 6, 8, 4, 4, 6]

        // toArray - pozwala konwertować kolekcje do tablic
        // I sposób
        Object[] array4 = arrayList4.toArray();
        // Uwaga! mechanizm automatycznej konwersji typów podstawowych nie działa
        // dla tablic
        System.out.println(array4);
        System.out.println(Arrays.toString(array4));
        int[] array4b = new int[array4.length];
        for(int i=0; i< array4.length; i++) {
            array4b[i] = (int) array4[i];
        }
        System.out.println(array4b);
        System.out.println(Arrays.toString(array4b));

        // II sposób
        Integer[] array5 = arrayList4.toArray(new Integer[arrayList4.size()]);
        System.out.println(array5);
        System.out.println(Arrays.toString(array5));

//        arrayConversion(array5); nie zadziała, ponieważ mechanizm automatycznej konwersji nie działa dla tablic

        // Jak skonwertować Integer[] na int[]
        // I sposób - za pomocą pętli
        // II sposób - Collection.stream()
        int[] array = arrayList4.stream().mapToInt(i->i).toArray();
        System.out.println(Arrays.toString(array));

        arrayList4.ensureCapacity(1000); // możemy modyfikować rozmiar wewnętrznej tablicy

        ArrayList<Integer> arrayList6 = new ArrayList<>();
        arrayList6.add(1);
        arrayList6.add(2);
        arrayList6.add(3);
        arrayList6.add(4);
        arrayList6.add(5);

        ArrayList<Integer> arrayList7;
        arrayList7 = (ArrayList<Integer>) arrayList6.clone();
        System.out.println(arrayList6);
        System.out.println(arrayList7);
        Integer i = arrayList7.get(2);
        i++;
        arrayList7.set(2, i);
//        arrayList7.set(i);
        System.out.println(arrayList6);
        System.out.println(arrayList7);



        ArrayList<Cat> arrayList8 = new ArrayList<>();
        arrayList8.add(new Cat());
        arrayList8.add(new Cat());

        ArrayList<Cat> arrayList9;
        arrayList9 = (ArrayList<Cat>) arrayList8.clone();
//        System.out.println(arrayList8); // bez przeciążenia toString: [zajecia7.Cat@58372a00, zajecia7.Cat@4dd8dc3]
//        System.out.println(arrayList9); // bez przeciążenia toString: [zajecia7.Cat@58372a00, zajecia7.Cat@4dd8dc3]
        System.out.println(arrayList8);
        System.out.println(arrayList9);
        arrayList8.get(0).setPaws(3);
        System.out.println(arrayList8);
        System.out.println(arrayList9);

        // Obserwacja
        // Ucięcie łapy jednemu kotu w pierwszej kolekcji powoduje, że
        // w drugiej kolekcji pierwszy kot również posiada o 1 łapę mniej.

        // Wniosek!
        // Metoda clone dostarcza kopię kolekcji, nowa kolekcja posiada skopiowane referencje.


        // Sortowanie - List.sort
        // Przykład
        // Posortować koty po liczbie łap
        Cat catWithoutPaws = new Cat();
        catWithoutPaws.setPaws(0);
        Cat catFromCzarnobyl = new Cat();
        catFromCzarnobyl.setPaws(5);

        arrayList9.add(catWithoutPaws);
        arrayList9.add(catFromCzarnobyl);
        System.out.println(arrayList9);

        arrayList9.sort((a, b) -> (a.getPaws()  > b.getPaws() ? -10 : a.getPaws() < b.getPaws() ? 10 : 0));
        System.out.println(arrayList9);

        // sortowanie po więcej niż 1 polu
    }

    private static void arrayConversion(int[] x) {}

    private static void arrayList() {
        // Kolekcje mogą przechowywać tylko obiekty!
        // bez typów sparametryzowanych
        ArrayList arrayList = new ArrayList();

        arrayList.add(3);
        arrayList.add(3.9);
        arrayList.add("cos");
        arrayList.add(false);
        arrayList.add('d');

        double[] array = new double[2];
        System.out.println(array);
        System.out.println(Arrays.toString(array));
        System.out.println(arrayList);
        // Wniosek - kolekcji w odróżnieniu od tablic nie musimy opakowywać
        // w metodą pomocniczą aby w ładny sposób wypisać zawartość

        // mechanizm automatycznej konwersji typów podstawowych
        x(3);

        // co w przypadku pobierania elementów z kolekcji?
//        Object x1 = arrayList.get(0);
//        Integer x1 = (Integer) arrayList.get(0);
        int x1 = (Integer) arrayList.get(0); // drugi aspekt mechanizmu automatycznej konwersji - wypakowywanie
        double x2 = (Double) arrayList.get(1);
        String x3 = (String) arrayList.get(2);
        boolean x4 = (Boolean) arrayList.get(3);
        char x5 = (Character) arrayList.get(4);

        // arrayList.size() - rozmiar kolekcji = liczba przechowywanych elementów

        // przypomnienie:
        // array.length
        // x3.length()

        // dla kolekcji:
        // arrayList.size()

        try {
            for (int i = 0; i < arrayList.size(); i++) {
                int v = (Integer) arrayList.get(i);
                System.out.println(v * v);
            }
        } catch (ClassCastException e) {
            System.out.println("Ooops ClassCastException!");
        }

        System.out.println(x1 + x1);

        // Uwaga! Wyjątek 'ClassCastException' odnośnie niewłaściwego typu umieszczonego w kolekcji jest
        // wyrzucony dopiero w czasie wykonywania program (RUNTIME).
        // Jest to bardzo niekorzystna sytuacja, chcielibyśmy uchronić się przed
        // umieszczeniem elementu niewłaściwego typu do kolekcji.

        // Do tego służą typy sparametryzowane.
        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
        arrayList2.add(3);
//        arrayList2.add(5.0);
//        arrayList2.add(false);
//        arrayList2.add("test");
        arrayList2.add(55);
        for (int i = 0; i < arrayList2.size(); i++) {
//            int v = (Integer) arrayList2.get(i);
            int v = arrayList2.get(i); // druga zaleta używania typów sparametryzowanych
            // nie muszę rzutować, ponieważ typ przechowywanych elementów jest znany
            // na etapie kompilacji

            System.out.println(v*v);
        }

        // Wniosek:
        // Dzięki typom sparametryzowanym nasz kod jest bezpieczniejszy oraz
        // prostszy w zapisie.



    }

    private static void x(Integer i) {
        System.out.println(i);
        System.out.println(i + i);
        System.out.println(i / i);
    }

    private static void arraysVsCollections() {
        // Kolekcje
        // Arrays

        // Przykład:
        // Wczytywać dane z klawiatury. Po wpisaniu "exit" będzie kończyć działanie
        // programu i wypisywać sumę uporzadkowanych rosnąco liczb
        // (wraz z całym działaniem arytmetycznym).

        // IN:
        // 3
        // 1
        // 2
        // exit

        // 1.0 + 2.0 + 3.0 = 6.0

//        arraysVsCollections1Arrays();
        arraysVsCollections2Collections();
    }

    private static void arraysVsCollections2Collections() {
//        ArrayList<Double> operations = new ArrayList<Double>(); // domyślnie 10
        ArrayList<Double> operations = new ArrayList<>(15);
        // System.gc(); // ręczne wywołanie garbage collectora

        // Uwaga
        // Jeżeli spodziewam się ile mniej więcej kolekcja może przechowywać elementów
        // warto skorzystać z konstruktora z parametrem initialCapacity, dzięki czemu
        // nasz program może działać w sposób wydajniejszy ze względu na mniejszą
        // liczbę operacji kopiowania tablic

        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            input = scanner.nextLine();
            try {
                double x = Double.parseDouble(input);
                operations.add(x);
            } catch(NumberFormatException e) {
                if (!input.equals("exit")) {
                    continue;
                }
                break;
            }
        } while (true);

//        Arrays.sort(operations); // Arrays.sort nie działa z kolekcjami!
        Collections.sort(operations);

        System.out.println(operations);

        String result = "";

        // W jaki sposób wygenerować wyrażenie 1 + 2 + ...
        // na podstawie tablicy (1, 2, ...) bez użycia pętli
        String s = operations.toString();

        // I sposób
//        String[] strings = s.substring(1, s.length() - 1).split(", ");
//        result += String.join(" + ", strings);

        // II sposób String.replace
        result += s.replace(", ", " + ");
        result = result.replaceAll("[\\[\\]]", "");


        // suma
        double sum = 0;
        for (double operation: operations) {
            sum += operation;
        }
        result += " = " + sum;

        System.out.println(result);

        // Zmieniliśmy strukturę, która przechowuje liczby podane przez użytkownika,
        // pozbyliśmy się mechanizmu powiększania rozmiaru tablicy, jak również wywaliliśmy
        // zmienną i, gdyż nie musimy się martwić o indeksy tej kolekcji.
        // Musiliśmy zmienić metodę, która sortuje (z Arrays.sort na Collections.sort)
        // Generowanie Stringów zmieniliśmy z Arrays.toString na Collection.toString

        // Dzięki temu zabiegowi nasz program jest czytelniejszy oraz efektywniejszy.
    }

    private static void arraysVsCollections1Arrays() {
        double[] operations = new double[3];
        Scanner scanner = new Scanner(System.in);
        String input;
        int i = 0;
        do {
            input = scanner.nextLine();
            try {
                double x = Double.parseDouble(input);
                if (i == operations.length) {
                    // ArrayIndexOutOfBoundsException!
                    double[] operations2 = new double[i+1];
                    for (int j=0; j<operations.length; j++) {
                        operations2[j] = operations[j];
                    }
                    operations = operations2;
                }
                operations[i] = x;
            } catch(NumberFormatException e) {
                if (!input.equals("exit")) {
                    continue;
                }
                break;
            }
            i++;
        } while (true);

        Arrays.sort(operations);

        System.out.println(
                Arrays.toString(operations)
        );

        String result = "";

        // W jaki sposób wygenerować wyrażenie 1 + 2 + ...
        // na podstawie tablicy (1, 2, ...) bez użycia pętli
        String s = Arrays.toString(operations);

        // I sposób
//        String[] strings = s.substring(1, s.length() - 1).split(", ");
//        result += String.join(" + ", strings);

        // II sposób String.replace
        result += s.replace(", ", " + ");
        result = result.replaceAll("[\\[\\]]", "");


        // suma
        double sum = 0;
        for (double operation: operations) {
            sum += operation;
        }
        result += " = " + sum;

        System.out.println(result);
    }
}
