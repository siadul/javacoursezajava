package zajecia8.ex_polymorphism;

import java.util.ArrayList;
import java.util.Random;

public class Bat {
    private ArrayList<Attackable> attackables = new ArrayList<>();
    private double health = 1.;

    public void fly() {
        Random random = new Random();
        if(random.nextInt(2) == 0) {
            attackables.add(new CoronaVirus());
        } else {
            attackables.add(new FlueVirus());
        }
    }

    public void getHealthState() {
        System.out.println("getHealthState()");
        for (Attackable attackable: attackables) {
            System.out.println(attackable);
        }
    }

    public void restInCave() {
        System.out.println("restInCave()");
        for (Attackable attackable: attackables) {
            System.out.println(attackable);
            double attack = attackable.attack();
            health -= attack;

            if (health <= 0) {
                System.out.println("The bat is dead");

                return;
            } else {
                System.out.println("The bat health: " + health);
            }
        }
    }
}
