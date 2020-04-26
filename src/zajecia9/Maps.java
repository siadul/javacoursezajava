package zajecia9;

import java.util.*;

public class Maps {
    public static void main(String[] args) {
        // Mapy - Klasy pozwalające przechowywać pary klucz-wartość
        Map<String, String> map1 = new HashMap<>();
        map1.put("key3", "value3");
        map1.put("key2", "value2");
        map1.put("key5", "value2");
        map1.put("key1", "value1");
        map1.put("key3", "value14");

        System.out.println(map1);
        map1.remove("key1");
        System.out.println(map1);

        map1.put("key1", "new value1");

        Set keySet1 = map1.keySet();
        System.out.println(keySet1);

        String value3 = map1.get("key3");
        System.out.println(value3);

        Collection collection = map1.values();
        System.out.println(collection);

        // Spostrzeżenie
        // Klucze i wartości przechowywane w mapach musza być obiektami.
        // Klucze w mapach muszą być unikalne, wartości nie.



        // HashMap - szybki dostęp do przechowywanych elementów

        // LinkedHashMap - zapewnia kolejność wstawiania
        LinkedHashMap<String, Integer> linkedHashMap1 = new LinkedHashMap<>();
        linkedHashMap1.put("hundred", 100);
        linkedHashMap1.put("one", 1);
        linkedHashMap1.put("three", 3);
        linkedHashMap1.put("two", 2);

        System.out.println(linkedHashMap1);


        // TreeMap - pozwala przechowywać pary klucz-wartość w uporządkowany sposób
        TreeMap<Double, Integer> treeMap1 = new TreeMap<>();
        treeMap1.put(4.5, 5);
        treeMap1.put(4.4, 4);
        treeMap1.put(4.6, 5);
        treeMap1.put(4.1, 50);

        System.out.println(treeMap1);


        // Przykład
        // Stworzyć mapę, która będzie posiadała klucze będące liczbami zmiennoprzecinkowymi
        // uporządkowanymi malejąco.

        // komparator przy użyciu klasy wewnętrznej (w obrębie metody)
        class MyMapComparator implements Comparator<Double> {
            @Override
            public int compare(Double d1, Double d2) {
//                return (int) (d1 - d2); rzutowanie różnicy na inta powoduje, że tracimy niektóre pary
//                return d1 > d2 ? -1: d1 < d2 ? 1 : 0;
                return Double.compare(d2, d1);
            }
        }

        // komparator przy użyciu anonimowych klas
//        TreeMap<Double, Integer> treeMap2 = new TreeMap<>(new Comparator<Double>(){
//            @Override
//            public int compare(Double d1, Double d2) {
////                return (int) (d1 - d2); rzutowanie różnicy na inta powoduje, że tracimy niektóre pary
////                return d1 > d2 ? -1: d1 < d2 ? 1 : 0;
//                return Double.compare(d2, d1);
//            }
//        });

        // komparator przy użyciu lamby () -> {} - v1
//        TreeMap<Double, Integer> treeMap2 = new TreeMap<>((d1, d2) -> {
//            return Double.compare(d2, d1);
//        });

        // komparator przy użyciu lamby () - v2
        TreeMap<Double, Integer> treeMap2 = new TreeMap<>(
                (d1, d2) -> Double.compare(d2, d1)
        );

        // komparator przy użyciu metody statycznej compareTo
//        TreeMap<Double, Integer> treeMap2 = new TreeMap<>(Double::compareTo);


        // Zadanie domowe
        // Stworzyć mapę uporządkowaną TreeMap z własnym comparatorem przy użyciu lambdy.


        treeMap2.put(0.2, 3);
        treeMap2.put(0.21, 2);
        treeMap2.put(0.23, 1);
        treeMap2.put(1.23, 0);
        treeMap2.put(-0.1, 4);

        System.out.println(treeMap2);

        // jak przeglądać (iterować) elementy (Entry) w mapie?
        Set<Double> set = treeMap2.keySet();
        for (Double key: set) {
            System.out.println("Key: " + key);
            int value = treeMap2.get(key);
            System.out.println("Value: " + value);
        }

        // iteratory - obiekty służące do iterowania po elementach w kontenerze
        System.out.println("Iteratory: ");
        Iterator<Double> iterator = treeMap2.keySet().iterator();

        while(iterator.hasNext()) {
            Double key = iterator.next(); // next przesuwa wskaźnik do następnego
            System.out.println("Key: " + key);
            int value = treeMap2.get(key);
            System.out.println("Value: " + value);
        }

        System.out.println("Iteratory EntrySet: ");
        Iterator<Map.Entry<Double, Integer>> iterator2 = treeMap2.entrySet().iterator();
        while(iterator2.hasNext()) {
            Map.Entry<Double, Integer> entry = iterator2.next(); // next przesuwa wskaźnik do następnego
            System.out.println("Key: " + entry.getKey());
            System.out.println("Value: " + entry.getValue());
        }
    }
}
