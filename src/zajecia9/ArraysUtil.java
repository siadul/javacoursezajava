package zajecia9;

import java.util.Arrays;

public class ArraysUtil {
    public static void main(String[] args) {

        // szybkie wypełnianie tablic
        char[] chars = new char[10];
        System.out.println(Arrays.toString(chars));

        Arrays.fill(chars, 'z');
        Arrays.fill(chars, 5, 7, 'a');

        System.out.println(Arrays.toString(chars));

        // sortowanie:
        // Arrays.sort
        // Zadanie domowe posortować tablice w oparciu własny komparator zdefiniowany za pomocą lambdy


        // Arrays.binarySearch - pozwala wyszukiwać element w tablicy w bardzo szybki sposób
        int c = Arrays.binarySearch(chars, 'z');
        System.out.println(c);

        // Uwaga!
        // Binary search działa prawidłowo wtedy gdy mamy posortowaną tablicę.
        Arrays.sort(chars);
        c = Arrays.binarySearch(chars, 'z');
        System.out.println(Arrays.toString(chars));
        System.out.println(c);

        int[] ints = {31, 6, 7, 1, 49, -5, 10, 33};
        System.out.println(Arrays.toString(ints));
        Arrays.sort(ints);
        System.out.println(Arrays.toString(ints));
        int i = Arrays.binarySearch(ints, 49);
        System.out.println(i);
        // Jeżeli element nie występuje w tablicy to zwracana jest wartość ujemna

        // kopiowanie tablic
        int[] ints2 = ints; // czy ja w ten sposób kopiuje tablicę?
        // NIE! w ten sposób przypisuje WYŁĄCZNIE REFERENCJE
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(ints2));
        ints[1] = 666;
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(ints2));

        // jak w takim razie skopiować tablicę?
        // skorzystać z gotowych metod copyOf, copyOfRange, System.arraycopy
        // albo skorzystać z pętli
        ints2 = new int[ints.length];
        for (int j=0; j<ints.length; j++) {
            ints2[j] = ints[j];
        }
        ints[1] = 333;
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(ints2));

        // Uwaga na tablice obiektów
        Sun[] suns = {new Sun(), new Sun(), new Sun(), new Sun(), new Sun(), new Sun()};
        Sun[] suns2;

        suns2 = Arrays.copyOf(suns, suns.length);
        System.out.println(Arrays.toString(suns));
        System.out.println(Arrays.toString(suns2));
        suns[1].id = 777;
        System.out.println(Arrays.toString(suns));
        System.out.println(Arrays.toString(suns2));

        System.out.println(Arrays.equals(suns, suns2));

        // Wniosek
        // Kopiowane są tylko referencje do obiektów Sun

        // A co jeżeli chce mieć w nowej tablicy nowe obiekty czyli zrobić tzw. "głęboką kopię"?
        for (int j=0; j<suns.length; j++) {
            suns2[j] = new Sun();
            // ... skopiuj stan obiektu suns2[j] tzn. przepisz wszystkie pola do nowego obiektu
        }

        // porównywanie tablic
        System.out.println(Arrays.equals(suns, suns2));

        System.out.println(
                Arrays.equals(suns, 1, 4, suns2, 2, 5)
        ); // porównywanie wybranych zakresów elementów

        Sun[] suns3 = Arrays.copyOfRange(suns, 1, 4);
        System.out.println(Arrays.toString(suns3));
    }
}

class Sun {
    private static int nr = 0;

    {
        id = nr++;
    }

    // private final
    int id;

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
