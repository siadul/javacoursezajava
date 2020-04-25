package zajecia8.ex4_3;

import java.util.Random;

public class Egg {
    private boolean isAlive = true;
    private String species;
    protected double DNA;

    public Egg(String species) {
        this.species = species;
        Random random = new Random();
        this.DNA = random.nextDouble();
        System.out.println("egg DNA: " + this.DNA);
    }

    public Caterpillar metamorphose() throws Exception {
        if (isAlive) {
            die();
            return new Caterpillar(species);
        } else {
            throw new Exception("This egg is dead");
        }
    }

    public String getSpecies() {
        return species;
    }

    public void die() {
        isAlive = false;
    }

    public boolean isAlive() {
        return isAlive;
    }
}
