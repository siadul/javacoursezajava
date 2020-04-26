package zajecia9;

import java.util.*;

public class Sets {
    public static void main(String[] args) {

        // Set - zbiory
        // w zbiorze wartości nie mogą się powtarzać
        // "A", "B", "A" - List
        // "A", "B" - Set

        // Jakie klasy implementują Set?
        // HashSet - Set z funkcją hashującą
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("D");
        hashSet1.add("F");
        hashSet1.add("G");
        hashSet1.add("Z");
        hashSet1.add("A");
        hashSet1.add("D"); // nie odniesie skutku, ponieważ "D" już występuje

        System.out.println(hashSet1);
        // Spostrzeżenie
        // Kolejność elementów w zbiorze nie jest zgodna z kolejnością wstawiania
        // Elementy w zbiorze nie powtarzają się.


        // Co jeżeli chciałbym, aby kolejność wstawiania była zachowana?
        // LinkedHashSet
        LinkedHashSet<String> linkedHashSet1 = new LinkedHashSet<>();
        linkedHashSet1.add("D");
        linkedHashSet1.add("F");
        linkedHashSet1.add("G");
        linkedHashSet1.add("Z");
        linkedHashSet1.add("A");
        linkedHashSet1.add("D");

        System.out.println(linkedHashSet1);

        // Wniosek
        // Jeżeli chcemy mieć strukturę, w której wartości nie mogą się powtarzać, a jednocześnie
        // dbamy o to by kolejność elementów w tej strukturze była zgodna z kolejnością
        // wstawiania to wówczas korzystamy z klasy LinkedHashSet


        // TreeSet - przechowywanie elementów w zbiorze w uporządkowany sposób
        TreeSet<String> treeSet1 = new TreeSet<>();
        treeSet1.add("D");
        treeSet1.add("F");
        treeSet1.add("G");
        treeSet1.add("Z");
        treeSet1.add("A");
        treeSet1.add("D");


        // Uwaga!
        // W przypadku HashSet również mieliśmy posortowane elementy, natomiast klasa nam tego
        // nie gwarantuje! Po operacjach na takim zbiorze może się okazać, że elementy wcale nie
        // będą uporządkowane.

        // Natomiast TreeSet zawsze dba o to by elementy były posortowane.

        System.out.println(treeSet1);

        // W jaki sposób określić własny porzadek w zbiorze TreeSet?

        // Przykład
        // Uporządkować elementy wg długości Stringów
        // Korzystamy z odpowiedniej wersji konstuktora.
        class MyComparator implements Comparator<String> {
            @Override
            public int compare(String s1, String s2) {
//                 return s1.length() > s2.length() ? 1 : s1.length() < s2.length() ? -1 :-1; // porównaj
//                   return s1.length() > s2.length() ? 1 : s1.length() < s2.length() ? -1 : (s1.equals(s2) ? 0 : -1); // porównaj
                return s1.length() > s2.length() ? 1 : s1.length() < s2.length() ? -1 : (s1.equals(s2) ? 0 : -1); // porównaj
//                 return s1.length() > s2.length() ? 1 : s1.length() < s2.length() ? -1 :0; // porównaj
//                return Integer.compare(s1.length(), s2.length());
            }
        }
        // [C, B, A, AB, AC, DC, DB, DBA, DBB, DBC, EBA, ABA, AAAZ] // 1
        // [A, B, C, DB, DC, AC, AB, ABA, EBA, DBC, DBB, DBA, AAAZ] // -1

        TreeSet<String> treeSet2 = new TreeSet<>(new MyComparator());
        treeSet2.add("C");
        treeSet2.add("B");
        treeSet2.add("A");
        treeSet2.add("AB");
        treeSet2.add("AB");
        treeSet2.add("AB");
        treeSet2.add("AC");
        treeSet2.add("DC");
        treeSet2.add("DB");
        treeSet2.add("DBA");
        treeSet2.add("DBB");
        treeSet2.add("DBC");
        treeSet2.add("EBA");
        treeSet2.add("ABA");
        treeSet2.add("AAAZ");

        System.out.println(treeSet2);

        // Spostrzeżenie
        // Jeżeli zdefiniowałem komparator w taki sposób, że wartość 0 jest zwracana w przypadku
        // gdy długość stringów jest równa to wówczas do kolekcji nie zostały umieszczone
        // kolejne stringi o tej samej długości.

        // Jeżeli chcę zachować wszystkie elementy dodawane do zbioru to muszę zdefiniować
        // komparator, który nie zwraca 0, ale wówczas zatracę właściwość Set czyli
        // brak powtarzania elementów w zbiorze.


        // podzbiory
        Set<String> subset1 = treeSet1.subSet("B", "G");
        Set<String> subset2 = treeSet2.subSet("AB", "AAAZ");

        System.out.println(treeSet1); // [A, D, F, G, Z]
        System.out.println(treeSet2); // [A, B, C, DB, DC, AC, AB, ABA, EBA, DBC, DBB, DBA, AAAZ]

        System.out.println(subset1); // [D, F]
        System.out.println(subset2); // [DB, DC, AC, AB, ABA, EBA, DBC, DBB, DBA]

        // pozostałe najważniejsze metody:
//        subset2.size() // analogicznie jak w List
//        subset2.addAll() // analogicznie jak w List
//        subset2.clear(); // analogicznie jak w List
//        subset2.remove(); // analogicznie jak w List
//        subset2.removeAll(Collection); // analogicznie jak w List
//        subset2.retainAll(Collection); // analogicznie jak w List
//        subset2.contains(); // analogicznie jak w List
//        subset2.containsAll(Collection); // analogicznie jak w List


        // Zadanie domowe:
        // Przetestować użycie tych metod, wyświetlić zbiór po każdej takiej operacji
        // na zbiorach TreeSet, HashSet i LinkedHashSet


        // PriorityQueue - kolejka priorytetowa - to samo co Queue natomiast możemy określać "pierwszeństwo"
        // Zadanie domowe dla ambitnych:
        // Stworzyć kolejkę priorytetową i sprawdzić jej działanie
    }
}
