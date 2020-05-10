package exam.ex1;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Ex1 {
    private final static String RESULT_TEMPLATE = "Długości boków wynoszą: a = %.2f, b = %.2f, c = %.2f";

    public static void main(String[] args) {
        Trojkat trojkat = new Trojkat();
        String result1 = String.format(RESULT_TEMPLATE, trojkat.getA(), trojkat.getB(), trojkat.getC());
        System.out.println(result1);
        Punkt A = new Punkt();
        A.x = -1;
        A.y = 0.3;
        Punkt B = new Punkt();
        B.x = -1;
        B.y = 2.3;
        Punkt C = new Punkt();
        C.x = 3;
        C.y = 1.3;
        trojkat.setA(A);
        trojkat.setB(B);
        trojkat.setC(C);
        String result2 = String.format(RESULT_TEMPLATE, trojkat.getA(), trojkat.getB(), trojkat.getC());
        System.out.println(result2);

        PrintWriter out = null;
        try {
            out = new PrintWriter("wyniki.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Nie udało się stworzyć pliku wyniki.txt");
            System.exit(0);
        }

        out.println(result1);
        out.println(result2);
        out.close();

        Kolo k = new Kolo();
        k.r = 1;
        k.Sr = new Punkt();
        k.Sr.x = 0;
        k.Sr.y = 0;
        A.x = 0;
        A.y = 0;
        B.x = 1;
        B.y = 1;
        C.x = -1;
        C.y = 1;
        Trojkat tr = new Trojkat(A, B, C);
        k.show();
        tr.show();
    }
}
