package zajecia7;

public class Cat {
    private int paws;
    private int heads;

    public Cat() {
        this.heads = 1;
        this.paws = 4;
    }

    public Cat(int heads, int paws) {
        this.heads = heads;
        this.paws = paws;
    }

    public int getPaws() {
        return paws;
    }

    public void setPaws(int paws) {
        this.paws = paws;
    }

    @Override
    public String toString() {
        return "Heads: " + heads + ", Paws: " + paws;
    }

    public int getHeads() {
        return heads;
    }

    public void setHeads(int heads) {
        this.heads = heads;
    }
}
