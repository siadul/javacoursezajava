package zajecia6;

import java.util.Random;

public class Interfaces {
    public static void main(String[] args) {
        Student student1 = new Student();
        System.out.println(
                student1.read()
        );
        System.out.println(
                student1.write()
        );

        // Jakie są korzyści z używania interfejsów?
        // Odpowiedź: polimorfizm
        System.out.println("Interfaces CanRead and CanWrite:");
        CanRead ableToRead1 = new Student(); // rzutowanie w górę
        CanWrite ableToWrite1 = new Student(); // rzutowanie w górę
        ableToRead1.read(); // polimorfizm
        ableToWrite1.write(); // polimorfizm


        Exam exam = new Exam();
        int mark = exam.startVerbal(student1);
        System.out.println(mark);

        BetterStudent betterStudent1 = new BetterStudent();
        mark = exam.startVerbal(betterStudent1);
        System.out.println(mark);

//        mark = exam.startWritten(ableToRead1); // nie zadziała
//        mark = exam.startWritten(ableToWrite1); // nie zadziała
//        mark = exam.startWritten(betterStudent1); // nie zadziała
        mark = exam.startWritten(student1);
        // Uwaga! powyższe wywołanie nie zadziała o ile student1
        // nie będzie obiektem klasy, która implementuje interfejs CanReadAndWrite,
        // nawet jeżeli ta klasa implementuje interfejsy wszystkie interfejsy, które
        // rozszerza CanReadAndWrite
        System.out.println(mark);

        System.out.println(CanRead.READ_ALL);
        System.out.println(CanRead.READ_FRAGMENT);
        CanRead.doSomething();
    }
}

class Exam {
    int startVerbal(CanRead canRead) {
        System.out.println("Verbal exam has started.");
        Random random = new Random();
        System.out.println(canRead.read());

        return random.nextInt(3) + 1;
    }

    int startWritten(CanReadAndWrite canReadAndWrite) {
        System.out.println("Written exam has started.");
        Random random = new Random();
        System.out.println(canReadAndWrite.read());
        System.out.println(canReadAndWrite.write());

        return random.nextInt(3) + 1;
    }
}

// Co to są interfejsy?
// Interfejsy to coś podobnego do klasy lecz zawiera wyłacznie abstrakcyjne metody
interface CanRead {
    static int READ_ALL = 1;
    int READ_FRAGMENT = 2; // pola w interfejsach muszą byc statyczne, mogę więc pominąć
    // modyfikator static

    static void doSomething() {
        System.out.println(READ_ALL);
        System.out.println(READ_FRAGMENT);
    }

    public abstract String read();
}

interface CanWrite {
    String write();

    // Uwaga! ponieważ interfejs posiada same abstrakcyjne metody to nie jest konieczne
    // używanie modyfikatora abstract.
    // Wszystkie metody publiczne w interfejsach są publiczne, więc również modyfikator
    // public mogę pominąć.
}

interface CanReadAndWrite extends CanRead, CanWrite {}
// Uwaga! interfejsy mogą dziedziczyć/rozszerzać inne interfejsy. Również
// dopuszczalne jest dziedziczenie/rozszerzanie wielokrotne

class Student implements CanReadAndWrite {
    // UWAGA! jeżeli klasa implementuje interfejs to muszę zaimplementować wszystkie
    // jego metody (niestatyczne), chyba że tą klasą implementującą jest klasa abstrakcyjna

    // Implementowanie metody oznacza przesłonięcie jej wersji abstrakcyjnej.
    @Override
    public String read() {
        System.out.println("reading...");

        return "blah blah blah";
    }

    @Override
    public String write() {
        System.out.println("writing...");

        return "ok";
    }
}

class BetterStudent implements CanRead {
    @Override
    public String read() {
        System.out.println("smart reading...");

        return "Thinking...";
    }
}

// Składnia
// interface NAZWA_INTERFEJSU {}

// Wykorzystanie interfejsów
// class NAZWA_KLASY implements NAZWA_INTERFEJSU