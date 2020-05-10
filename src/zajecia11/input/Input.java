package zajecia11.input;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
//        input1();
//        input1ex1();
        input2();
    }

    private static void input2() {
        // Odczyt z pliku Path + Files.readAllLines - dostajemy List<String>
        Path path = Path.of("text1.txt");
        try {
            List<String> lines = Files.readAllLines(path); // nie musimy się martwić zamykaniem pliku
            System.out.println(lines);
        } catch (IOException e) {
            System.out.println("IOException! :(");
            e.printStackTrace();
        }
    }

    private static void input1() {
        // W jaki sposób odczytywać dane z pliku tekstowego?
        // klasa File oraz Scanner

        // Przykład
        // Mamy plik text1.txt zawierający przykładową dowolną treść. Wczytywać linia po linii i wypisywać
        // na standardowym wyjściu.
        File file = new File("text1.txt");
        try {
            Scanner scanner = new Scanner(file);
            String line;
            while (scanner.hasNext()) {
                line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close(); // pamiętamy o zamknięciu pliku
        } catch (FileNotFoundException e) {
            System.out.println("Cannot open the file :(");
        }
    }

    private static void input1ex1() {
        try {
            URL url = new URL("http://wezmoto.pl");
            InputStream inputStream = url.openStream();
//            Path path = Path.of(url.toURI()); // // java.nio.file.FileSystemNotFoundException: Provider "http" not installed

            Scanner scanner = new Scanner(inputStream);
            String line;
            while (scanner.hasNext()) {
                line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("IOException");
            e.printStackTrace();
        }
    }
}
