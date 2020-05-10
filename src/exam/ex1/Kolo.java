package exam.ex1;

public class Kolo extends Ksztalt2D {
    public Punkt Sr;
    public double r;

    @Override
    double obwod() {
        return 2 * Math.PI * r;
    }
}
