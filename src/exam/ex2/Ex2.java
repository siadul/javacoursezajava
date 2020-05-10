package exam.ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        File file = new File("literki.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        PrintWriter outHist = null;
        try {
            outHist = new PrintWriter("hist.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        String line = "";
        int[] hist = new int[128];

        // Jakiś tekst
        // a - (char) 97 - 1
        // k - 2
        // t - 2
        // ...

        StringBuilder stringBuilder = new StringBuilder();

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            char[] lineChars = line.toCharArray();
            for(char c: lineChars) {
                if (c > 127) {
                    continue;
                }
                hist[c]++;
            }
            stringBuilder.append(line).append('\n');
        }

        String s = Arrays.toString(hist);
        outHist.println(s);

        outHist.close();
        scanner.close();

        Scanner scanner2 = null;
        PrintWriter outZamiana = null;
        try {
            scanner2 = new Scanner(new File("literki.txt"));
            outZamiana = new PrintWriter("zamiana.txt");
        } catch (FileNotFoundException e) {
            System.exit(-1);
            e.printStackTrace();
        }

        char maxC1 = findMaxChar(hist, (char) 128);
        char maxC2 = findMaxChar(hist, maxC1);
        System.out.println(maxC1);
        System.out.println(maxC2);

        while(scanner2.hasNextLine()) {
            line = scanner2.nextLine();
            char[] lineChars = line.toCharArray();
            for(char c: lineChars) {
                if(c == maxC1) {
                    outZamiana.print(maxC2);
                } else if(c == maxC2) {
                    outZamiana.print(maxC1);
                } else {
                    outZamiana.print(c);
                }
            }

            outZamiana.println();
        }

        outZamiana.close();

        PrintWriter outWspak = null;
        try {
            outWspak = new PrintWriter("wspak.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        outWspak.print(stringBuilder.reverse());

        outWspak.close();
    }

    private static char findMaxChar(int[] hist, char ignoreChar) {
        char maxChar = 0;
        int count = 0;
        for (int i = 0; i<hist.length; i++) {
            if (i != ignoreChar && hist[i] > count) {
                count = hist[i];
                maxChar = (char) i;
            }
        }

        return maxChar;
    }
}
