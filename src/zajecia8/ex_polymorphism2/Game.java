package zajecia8.ex_polymorphism2;

public class Game implements Playable {
    @Override
    public int play() {
        System.out.println("game.play()");
        return 0;
    }
}
