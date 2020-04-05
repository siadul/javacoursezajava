package zajecia6;

public class Finals {
    public static void main(String[] args) {
        // błąd kompilacji
//        B1 b1 = new B1();
//        b1.show();
    }
}

class A1 {
    private int a = 4;

    public final void show() {
        System.out.println("A1.show() " + getA());
    }

    public int getA() {
        return a;
    }

}

// poniższe klasy się nie skompilują
//final class B1 extends A1 {
//    public void show() { // Uwaga! Jeżeli metoda w klasie bazowej jest oznaczona jako final
//        // to wówczas nie mam możliwości jej przesłonięcia
//        System.out.println("B1.show() " + getA());
//    }
//}
//
//class C1 extends B1 {} // Uwaga! Jeżeli klasa oznaczona jest jako final
//    // to wówczas nie mam możliwości dziedziczenia po niej
