package zajecia6;

public class Access {
    public static void access() {
        B subOb = new B();
        subOb.setij(10, 12);

        subOb.sum();
        System.out.println("Suma: " + subOb.total);
    }
}

class A {
    int i;
    private int j; // pól prywatnych nie dziedziczymy

    void setij(int x, int y) {
        i = x;
        j = y;
    }

    public int getJ() {
        return j;
    }
}

class B extends A {
    int total;

    void sum() {
        total = i + getJ(); // muszę użyć gettera getJ, ponieważ j jest prywatne
    }
}

