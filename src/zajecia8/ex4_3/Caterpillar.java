package zajecia8.ex4_3;

public class Caterpillar extends Egg {
    Caterpillar(String species) {
        super(species);
//        this.species = species; // private
        System.out.println("caterpillar DNA: " + this.DNA); // protected
        this.DNA = this.DNA * this.DNA;
        System.out.println("caterpillar modified DNA: " + this.DNA); // protected
    }

    @Override
    public Nymph metamorphose() throws Exception {
        if (isAlive()) {
            die();
            return new Nymph(super.getSpecies());
        } else {
            throw new Exception("This caterpillar is dead");
        }
    }

    @Override
    public String toString() {
        return super.getSpecies() + ": " + this.DNA;
    }
}

