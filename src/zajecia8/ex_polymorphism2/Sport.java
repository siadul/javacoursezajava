package zajecia8.ex_polymorphism2;

public class Sport implements Playable {
    @Override
    public int play() {
        System.out.println("sport.play()");
        return 0;
    }
}
