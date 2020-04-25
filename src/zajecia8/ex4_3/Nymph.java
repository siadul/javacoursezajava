package zajecia8.ex4_3;

public class Nymph extends Caterpillar {
    Nymph(String species) {
        super(species);
        System.out.println("Nymph DNA: " + this.DNA); // protected
        this.DNA = this.DNA * this.DNA;
        System.out.println("Nymph modified DNA: " + this.DNA); // protected
    }

    @Override
    public Butterfly metamorphose() throws Exception {
        if (isAlive()) {
            die();
            return new Butterfly(super.getSpecies());
        } else {
            throw new Exception("This nymph is dead");
        }
    }
}
