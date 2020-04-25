package zajecia8.ex_polymorphism;

public class CoronaVirus extends AbstractVirus {
    CoronaVirus() {
        super(0.01);
    }

    @Override
    public double mutate() {
        System.out.println("before mutate(), power: " + getPower());
        setPower(getPower() + 0.1);
        System.out.println("after mutate(), power: " + getPower());

        return getPower();
    }

    @Override
    public double attack() {
        double attack = super.attack();

        if (attack < 0.005) {
            return attack();
        } else {
//        return attack > 0.5 ? 1 : attack < 0.5 ? -1 : 0;
            return Double.compare(attack, 0.005); // szybciej
        }
    }
}
