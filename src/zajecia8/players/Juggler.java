package zajecia8.players;

import zajecia8.games.Ball;

import java.util.Arrays;

public class Juggler {
    public void play(Ball... balls) {
        // W jaki sposób odwoływać się do poszczególnych argumentów?
        // Balls jest tablicą obiektów klasy Ball (Ball[])
        System.out.println(Arrays.toString(balls));
    }
}
