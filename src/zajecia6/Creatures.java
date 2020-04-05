package zajecia6;

public class Creatures {
    public static void main(String[] args) {
        // Zadanie
        // stworzyć instancje klas Fish, Cat, Swift
        Fish fish1 = new Fish(1);
        Cat cat1 = new Cat(0.9);
        Swift swift1 = new Swift(3);

        Creature[] creatures = new Creature[3];
        creatures[0] = fish1;
        creatures[1] = cat1;
        creatures[2] = swift1;

        start(creatures);
    }

    public static void start(Creature[] creatures) {
        for(Creature creature: creatures) {
            System.out.println(creature.getClass().getName() + ": " + creature.getSpeed());
        }
    }
}

abstract class Creature {
    private boolean isAlive = true;
    private double speed;

    Creature(double speed) {
        setSpeed(speed);
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}

interface CanSwim {
    double swim(int time);
}

interface CanRun {
    double run(int time);
}

interface CanFly {
    double fly(int time);
}

abstract class WaterCreature extends Creature implements CanSwim {
    WaterCreature(double speed) {
        super(speed);
    }
}
abstract class LandCreature extends Creature implements CanRun {
    LandCreature(double speed) {
        super(speed);
    }
}
abstract class FlyingCreature extends Creature implements CanFly {
    FlyingCreature(double speed) {
        super(speed);
    }
}

class Fish extends WaterCreature {
    public Fish(double speed) {
        super(speed);
    }

    @Override
    public double swim(int time) {
        System.out.println(this.getClass().getName()  + ".swim()");

        return getSpeed() * time;
    }
}

class Cat extends LandCreature {
    public Cat(double speed) {
        super(speed);
    }

    @Override
    public double run(int time) {
        System.out.println(this.getClass().getName()  + ".run()");

        return getSpeed() * time;
    }
}

class Swift extends FlyingCreature {
    public Swift(double speed) {
        super(speed);
    }

    @Override
    public double fly(int time) {
        System.out.println(this.getClass().getName()  + ".fly()");

        return getSpeed() * time;
    }
}

