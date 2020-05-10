package zajecia11.output;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static java.nio.file.StandardOpenOption.APPEND;

public class Output {
    public static void main(String[] args) throws IOException {
//        output1();
//        output2(); // append
//        output3(); //  Files.write print whole List<String>
//        output3ex2(); // dodawanie unikalnych danych do pliku
//        output3ex3(); // dodawanie unikalnych danych posortowanych
        output3ex4(); // dodawanie unikalnych danych w kolejności występowania w pliku wejściowym
    }

    private static void output3ex4() throws IOException {
        // Przykład
        // Zapisywać do nowe pliku wyłącznie unikalne linie z pliku wejściowego w kolejności posortowanej metodą słownikową.
        Path pathIn = Path.of("text5a.txt");
        Path pathOut = Path.of("text5b.txt");
        List<String> list = Files.readAllLines(pathIn);
        // w jaki sposób utworzyć set za pomocą list?
        Set<String> set = new LinkedHashSet<>(list); // albo addAll // albo foreach - efekt jest identyczny
        set.add("test1");
        set.add("test1");
        set.add("test1");
        set.add("test1");
        set.add("test2137");
        Files.write(pathOut, set);

        // Spostrzeżenie
        // Wystarczyło zmienić strukturę z HashSet na LinkedHashSet
    }

    private static void output3ex3() throws IOException {
        // Przykład
        // Zapisywać do nowe pliku wyłącznie unikalne linie z pliku wejściowego w kolejności posortowanej metodą słownikową.
        Path pathIn = Path.of("text5a.txt");
        Path pathOut = Path.of("text5b.txt");
        List<String> list = Files.readAllLines(pathIn);
        // w jaki sposób utworzyć set za pomocą list?
        Set<String> set = new TreeSet<>(); // albo sparametryzowany konstruktor // albo foreach - efekt jest identyczny
        set.addAll(list);
        set.add("test1");
        set.add("test1");
        set.add("test1");
        set.add("test1");
        set.add("test2137");
        Files.write(pathOut, set);

        // Spostrzeżenie
        // Wystarczyło zmienić strukturę z HashSet na TreeSet
        // Jeżeli chce nadać inny porządek to wówczas implementuje Comparator
    }

    private static void output3ex2() throws IOException {
        // Przykład
        // Zapisywać do nowe pliku wyłącznie unikalne linie z pliku wejściowego oraz nowe linie.
        Path pathIn = Path.of("text5a.txt");
        Path pathOut = Path.of("text5b.txt");
        List<String> list = Files.readAllLines(pathIn);
        // w jaki sposób utworzyć set za pomocą list?
        Set<String> set = new HashSet<>();  // albo addAll // albo foreach - efekt jest identyczny
        for (String element: list) {
            set.add(element);
        }
        set.add("test1");
        set.add("test1");
        set.add("test1");
        set.add("test1");
        set.add("test2137");
        Files.write(pathOut, set);
    }

    private static void output3() throws IOException {
        Path path = Path.of("text4.txt");
        ArrayList<String> lines = new ArrayList<>();
        lines.add("l1");
        lines.add("l2");
        lines.add("l3");
        lines.add("l4");
        Files.write(path, lines); // nie muszę pamiętać o zamykaniu pliku, Files.write zrobi to za nas
//        Files.write(path, lines, APPEND); // jeżeli chcę dopisywać do pliku to dodaję 3 argument java.nio.file.StandardOpenOption.APPEND
    }

    private static void output2() throws IOException {
        // W jaki sposób dopisywać dane do pliku tekstowego?
        // PrintWriter
        FileWriter fileWriter = new FileWriter("text3.txt", true);
        PrintWriter out = new PrintWriter(fileWriter);
        out.println("line1");
        out.println("line2");
        out.println("line3");
        Random random = new Random();
        out.print(random.nextInt(1000));
        out.println("line5");

        out.close();
    }

    private static void output1() throws FileNotFoundException {
        // W jaki sposób zapisywać dane do pliku tekstowego?
        // PrintWriter
        PrintWriter out = new PrintWriter("text2.txt");
        out.format("|%-10s| |%5s| %.3f", "test1", "t2", 3.1415678); // analogicznie jak String.format
        out.println("PrintedLine1");
        out.print("Printed1");

        out.close(); // Uwaga! Pamiętamy o zamknięciu pliku!
    }
}
