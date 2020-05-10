package exam.ex1;

public class Trojkat extends Ksztalt2D {
    public Punkt A;
    public Punkt B;
    public Punkt C;

    private double a;
    private double b;
    private double c;

    public Trojkat() {
        A = new Punkt();
        A.x = 0;
        A.y = 0;
        B = new Punkt();
        B.x = 2;
        B.y = -2;
        C = new Punkt();
        C.x = 2;
        C.y = 2;
        boki(); // 4?

        //   C
        //
        // A
        //
        //   B
        // a = |BC| = 4
        // b = |AC| = 2 + hak = 2 * sqrt(2) ~ 2 * 1.41 ~ 2.83
        // c = |AB| = 2 + hak = 2 * sqrt(2) ~ 2 * 1.41 ~ 2.83
    }

    public Trojkat(Punkt A, Punkt B, Punkt C) {
        this.A = A;
        this.B = B;
        this.C = C;
        boki();
    }

    public Trojkat(double Ax, double Ay, double Bx, double By, double Cx, double Cy) {
        A = new Punkt();
        A.x = Ax;
        A.y = Ay;
        B = new Punkt();
        B.x = Bx;
        B.y = By;
        C = new Punkt();
        C.x = Cx;
        C.y = Cy;
        boki();
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public void setA(Punkt a) {
        A = a;
        boki();
    }

    public void setB(Punkt b) {
        B = b;
        boki();
    }

    public void setC(Punkt c) {
        C = c;
        boki();
    }

    private void boki() {
        a = Math.sqrt((B.x - C.x)*(B.x - C.x) + (B.y - C.y)*(B.y - C.y)); // |(B;C)|
        b = Math.sqrt((A.x - C.x)*(A.x - C.x) + (A.y - C.y)*(A.y - C.y)); // |(A;C)|
        c = Math.sqrt((B.x - A.x)*(B.x - A.x) + (B.y - A.y)*(B.y - A.y)); // |(A;B)|
    }

    @Override
    double obwod() {
        return a + b + c;
    }
}
