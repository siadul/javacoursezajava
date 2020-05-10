package zajecia11.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MyException extends Exception {
    public static void main(String... args) {
        exceptions();
    }

    public MyException(String message) {
        super(message);
    }

    private static void exceptions() {
        try {
            if (0 > 0) {
                throw new FileNotFoundException(); // Nie jest potomkiem RuntimeException, więc musze dodać obsługe wyjątku
            } else if (20 > 511) {
                throw new ArithmeticException(); // RuntimeException
            } else if (5 > 11) {
                throw new ArrayIndexOutOfBoundsException();  // RuntimeException
            } else if (8 > 19) {
                throw new IOException();
            } else {
                throw new MyException("Something went wrong!");
            }
        } catch (FileNotFoundException e) {
            System.out.println("I'm in FileNotFoundException catch block!");
            e.printStackTrace();
        } catch (IOException | MyException e) {
            e.printStackTrace();
        } finally {
//            // niezaleznie od tego czy wystąpi wyjątek obsłużony w bloku catch, czy wystąpi wyjątek nieobsłużony w bloku catch,
//            // czy też nie wystąpi wyjątek, mamy gwarancję, że instrukcje z tego bloku zostaną wykonane
            System.out.println("I'm in finally block!");
        }

        // Uwaga
        // Nie mam obowiązku przechwytywania wyjątków RuntimeException.
        // Jeżeli nie przechwyce RuntimeException to zostanie wykonana domyślna obsługa błędów na poziomie metody głównej
    }
}
