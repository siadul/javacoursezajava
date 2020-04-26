package zajecia9;

import java.util.*;

public class LinkedLists {
    public static void main(String[] args) {
        // ArrayList
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("array list test1");
        arrayList.add("array list test2");

        System.out.println(arrayList);

        // LinkedList
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("linked list test1");
        linkedList.add("linked list test2");

        System.out.println(linkedList);

        // Wniosek
        // ArrayList i LinkedList implementują ten sam interfejs - List

        List<String> list = new ArrayList<>();
        list.add("list test1");
        list.add("list test2");

        System.out.println(list);

        // String[] stringArray = new String[10];
        // W jaki sposób działa wstawianie elementu do ArrayList?
        // wstawiam na 5 pozycji nowy element
        // musze stworzyć nową tablicę
        // skopiować elementy ze starej tablicy do nowej od 0 do 5
        // wstawiam nowy element na pozycję 5
        // kopiuję elementy ze starej tablicy od 6 do 10

        // W jaki sposób działa wstawianie elementu do LinkedList?
        // znajduję 2 elementy (Node) między które wstawiam nowy element, setuje im odpowiednio pola
        // prev i next

        // Wniosek
        // Dzięki korzystaniu z interfejsu List zamiast konkretnej klasy np. ArrayList i LinkedList
        // uniezależniam mój program operujący na kolekcjach od wewnętrznej implementacji struktur.
        // Jest to istotne ponieważ od wewnętrznej implementacji struktur zależy wydajność naszego
        // programu np. operacja wstawiania jest bardziej wydajna w przypadku LinkedList, operacja
        // odczytu jest bardziej wydajna w przypadku ArrayList


        // Spostrzeżenie
        // ArrayList implementuje dodatkowo RandomAccess, natomiast LinkedList implementuje
        // dodatkowo Deque (który rozszerza Queue)
        // Wniosek możemy implementować strukturę kolejki za pomocą LinkedList

        // Czym są kolejki?
        // FIFO - first in first out, np. kolejka do kasy/bankomatu
        // LIFO - last in first out, inaczej stos, np. naczynia w zlewie, rzeczy w plecaku

        // Uwaga!
        // Interfejs Deque implementowany przez LinkedList rozszerza interfejs Queue.
        // Queue pozwala nam implementować kolejkę FIFO a Deque dodaje metody umożliwiające
        // implementowanie kolejki LIFO

        // Wniosek
        // Możemy implementować stos bądź kolejkę FIFO przy użyciu LinkedList
        LinkedList<String> linkedList1 = new LinkedList<>();
        linkedList1.add("F");
        linkedList1.add("B");
        linkedList1.add("D");
        linkedList1.add("E");
        linkedList1.add("C");
        linkedList1.addLast("Z");
        linkedList1.addFirst("A");

        linkedList1.add(1, "A2");

        System.out.println(linkedList1);

        linkedList1.remove("F"); // wariant z wartością
        linkedList1.remove(2); // wariant z indeksem

        System.out.println(linkedList1);

        // pobieranie i ustawienie wartości
        String val = linkedList1.get(2);
        linkedList1.set(2, val + " changed");

        System.out.println(linkedList1);
    }
}
