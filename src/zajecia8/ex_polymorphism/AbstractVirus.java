package zajecia8.ex_polymorphism;

import java.util.Random;

public abstract class AbstractVirus implements Attackable {
    private double power;

    public abstract double mutate();

    AbstractVirus(double power) {
        this.power = power;
    }

    public double attack() {
        Random random = new Random();
        double attack = random.nextDouble() * power;
        System.out.println(attack);

        return attack;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return getClass().getName() + ", power: " + getPower();
    }
}
