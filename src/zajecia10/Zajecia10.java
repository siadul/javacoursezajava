package zajecia10;

import java.util.Date;
import java.util.Scanner;

public class Zajecia10 {
    public static void main(String[] args) {
//        stringFormat();
        moreStringFormat();
    }

    private static void moreStringFormat() {
        // %e - scientific notation
        System.out.println(
                String.format("%e", 40009.7632)
        );


        // %t{FLAGS} - date/time ex. tA - Saturday
        System.out.println(
                String.format("%tA", new Date())
        );

        System.out.println(
                String.format("%ta", new Date())
        );

        System.out.println(
                String.format("%tB", new Date())
        );

        System.out.println(
                String.format("%tb", new Date())
        );


        // %D - %tm/%td/%ty
        // %d - day of month
        System.out.println(
                String.format("%tA %tB %tD %tT %tZ %tY", new Date(), new Date(), new Date(), new Date(), new Date(), new Date())
        );

        // %1$t argument index
        System.out.println(
                String.format("%1$tA %1$tB %1$tD %1$tT %1$tZ %1$tY", new Date())
        );


        // Przykład
        // wyświelić najpierw 20 potem 10, lista argumentów: 10, 20
        System.out.println(
                String.format("%2$d %1$d", 10, 20)
        );


        // Przykład
        // wyświelić liczbę na 10 miejscach
        System.out.println(
                String.format("%10d", 6)
        );
        System.out.println(
                String.format("|%+10d|", 6)
        );

        System.out.println(
                String.format("%10o", 9)
        );

        System.out.println(
                String.format("%10h", 30)
        );

        // zadanie domowe
        // - justify
        // %-30s

        // string length
        // %30s
    }

    private static void stringFormat() {
        // String format
        // Przykład wyświetlić tekst "Hello {name} {surname}". Name i surname pobierane są
        // z klawiatury. Nie chcemy używać konkatenacji.

        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = scanner.nextLine();

        System.out.println("What is your surname?");
        String surname = scanner.nextLine();

//        System.out.println("Hello " + name + " " + surname);
        System.out.println(String.format("Hello %s %s", name, surname));

        System.out.println("How old are you?");
        int age = 0;
//        age = scanner.nextInt(); // albo0
        try {
            age = Integer.parseInt(scanner.nextLine());
        } catch(NumberFormatException e) {
            System.out.println("incorrect age");
            System.exit(0);
        }
        // parseInt rzuca wyjątek NumberFormatException. Powinniśmy go obsłużyć, natomiast nie musimy
        // program się skompiluje tak czy siak. Dzieję się tak ponieważ NumberFormatException
        // ma w swojej hierarchii RuntimeException jako przodka.

        System.out.println(String.format("Your %d", age));

        System.out.println(String.format("Your initials %c.%c.", name.charAt(0), surname.charAt(0)));

        // %c - podstaw char

        System.out.println(
                String.format("Are you woman? %b", false)
        );

        // %b - podstaw boolean
    }
}
