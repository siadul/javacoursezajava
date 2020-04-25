package zajecia8.ex_polymorphism;

public class FlueVirus extends AbstractVirus {
    FlueVirus() {
        super(0.005);
    }

    @Override
    public double mutate() {
        System.out.println("before mutate(), power: " + getPower());
        setPower(getPower() * getPower());
        System.out.println("after mutate(), power: " + getPower());

        return getPower();
    }

    @Override
    public double attack() {
        double attack = super.attack();

        return Double.compare(attack, 0.005);
    }
}
