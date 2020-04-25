package zajecia8;

import zajecia8.ex3_2.Letter;
import zajecia8.ex3_2.Post;
import zajecia8.ex3_2.Sender;
import zajecia8.ex4_1.Building;
import zajecia8.ex4_1.House;
import zajecia8.ex4_1.Warehouse;
import zajecia8.ex4_2.CanCountVotesInterface;
import zajecia8.ex4_2.CanVoteInterface;
import zajecia8.ex4_2.CorrespondenceElections;
import zajecia8.ex4_2.FakeableInterface;
import zajecia8.ex4_3.Butterfly;
import zajecia8.ex4_3.Caterpillar;
import zajecia8.ex4_3.Egg;
import zajecia8.ex4_4.FtpConnection;
import zajecia8.ex4_4.HttpConnection;
import zajecia8.ex4_4.InputOutputOperable;
import zajecia8.ex_polymorphism.Bat;
import zajecia8.ex_polymorphism2.Game;
import zajecia8.ex_polymorphism2.Playable;
import zajecia8.ex_polymorphism2.Sport;
import zajecia8.games.Ball;
import zajecia8.players.Juggler;

import java.util.ArrayList;
import java.util.Random;

public class Zajecia8 {
    public static void main(String[] args) {
//        ex3_1();
//        ex3_2();
//        ex4_1();
//        ex4_2();
//        ex4_3();
//        ex4_4();
//        ex_polymorphism();
        ex_polymorphism2();
    }

    private static void ex_polymorphism2() {
        ArrayList<Playable> playables = new ArrayList<>();
        playables.add(new Game());
        playables.add(new Sport());

        for (Playable playable: playables) {
            playable.play(); // polimorfizm
        }
    }

    private static void ex_polymorphism() {
        Bat bat = new Bat();
        bat.getHealthState();
        bat.fly();
        bat.getHealthState();
        bat.fly();
        bat.fly();
        bat.fly();
        bat.fly();
        bat.getHealthState();

        bat.restInCave();
    }

    private static void ex4_4() {
        final int size = 10;
        InputOutputOperable[] inputOutputOperables = new InputOutputOperable[size];
        Random random = new Random();
        for(int i=0; i<size; i++) {
            if (0 == random.nextInt(2)) {
                inputOutputOperables[i] = new HttpConnection();
            } else {
                inputOutputOperables[i] = new FtpConnection();
            }
        }

        for(int i=0; i<size; i++) {
            inputOutputOperables[i].read(); // polimorfizm
            inputOutputOperables[i].write("test");  // polimorfizm
            inputOutputOperables[i].operate();  // polimorfizm

//            ((HttpConnection) inputOutputOperables[i]).createHeaders();
//            ((HttpConnection) inputOutputOperables[i]).connect();
        }
    }

    private static void ex4_3() {
//        Caterpillar caterpillar = new Caterpillar(); // nie działa, konstruktor ma dostęp pakietowy

        try {
            Egg egg1 = new Egg("silkworm");
            Caterpillar caterpillar1 = egg1.metamorphose();
//        caterpillar1.species
//        caterpillar1.DNA
            System.out.println(caterpillar1);

            Butterfly butterfly1 = caterpillar1.metamorphose().metamorphose().metamorphose().metamorphose().metamorphose();
            Butterfly butterfly2 = new Egg("silkworm").metamorphose().metamorphose().metamorphose();
            System.out.println(butterfly1);
        } catch(Exception exception) {
            System.out.println("exception during metamorphose");
        }
    }

    private static void ex4_2() {
        CorrespondenceElections elections1 = new CorrespondenceElections();
        System.out.println(elections1.vote());
        System.out.println(elections1.fake());
        System.out.println(elections1.countVotes());


        CanCountVotesInterface elections2 = new CorrespondenceElections();
        System.out.println(elections2.countVotes());
//        System.out.println(elections2.fake());
//        System.out.println(elections2.vote());

        CanVoteInterface elections3 = new CorrespondenceElections();
//        System.out.println(elections3.countVotes());
//        System.out.println(elections3.fake());
        System.out.println(elections3.vote());

        FakeableInterface elections4 = new CorrespondenceElections();
//        System.out.println(elections4.countVotes());
        System.out.println(elections4.fake());
//        System.out.println(elections4.vote());



    }

    private static void ex4_1() {
        new Building("Płowiecka 10", 56.6, 24.0);
        new House("Sadowa 15", 56.6, 24.0, 4);
        new Warehouse("Józefa Piłsudskiego 2147", 56.6, 24.0, 56.0);
    }

    private static void ex3_2() {
        Sender sender = new Sender("Chris", "Black", "Cracow");
//        System.out.println(sender.name); // nie zadziała bo private
        System.out.println(sender);
        new Post().sendLetter(sender, new Letter());
    }

    private static void ex3_1() {
        System.out.println(
                Ball.getVolleyballCounter()
        );

        Ball volleyball1 = new Ball("volleyball");

        System.out.println(
                Ball.getVolleyballCounter()
        );
        Ball volleyball2 = new Ball("volleyball");
        Ball football1 = new Ball("football");
        Ball football2 = new Ball("football");
        Ball football3 = new Ball("football");
        Ball basketball1 = new Ball("basketball");
        Ball handball1 = new Ball("handball");
        Ball tennisball1 = new Ball("tennisball");
        Ball golfball1 = new Ball("golfball");
        Ball rugbyball1 = new Ball("rugbyball");

        Juggler juggler1 = new Juggler();
        Juggler juggler2 = new Juggler();
        Juggler juggler3 = new Juggler();

        juggler1.play(volleyball1, volleyball2, football1,
                football2, football3, basketball1, handball1,
                tennisball1, golfball1, rugbyball1
        );

        juggler2.play(volleyball1, volleyball2, football1,
                football2, football3, basketball1, handball1,
                tennisball1, golfball1, rugbyball1
        );

        juggler3.play(football1, football2, football3);

        Ball.getStatistics();
    }
}
