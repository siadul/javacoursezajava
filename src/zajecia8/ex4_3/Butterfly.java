package zajecia8.ex4_3;

public class Butterfly extends Nymph {
    Butterfly(String species) {
        super(species);
        System.out.println("Butterfly DNA: " + this.DNA); // protected
        this.DNA = this.DNA * this.DNA;
        System.out.println("Buterfly modified DNA: " + this.DNA); // protected
    }

    @Override
    public Butterfly metamorphose() throws Exception {
        throw new Exception("Butterfly can't metamorphose");
    }
}
