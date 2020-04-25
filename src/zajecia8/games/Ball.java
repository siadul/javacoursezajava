package zajecia8.games;

public class Ball {
    private final String type;
    private static int footballCounter;
    private static int volleyballCounter;
    private static int otherballCounter;

    public Ball(String type) {
        switch (type) {
            case "football":
                footballCounter++;
                break;
            case "volleyball":
                volleyballCounter++;
                break;
            default:
                otherballCounter++;
        }
        this.type = type;
    }

    public static int getFootballCounter() {
        return footballCounter;
    }

    public static int getVolleyballCounter() {
        return volleyballCounter;
    }

    public static int getOtherballCounter() {
        return otherballCounter;
    }

    public static void setFootballCounter(int footballCounter) {
//        this.footballCounter = footballCounter;
        // Uwaga! nie zadziała, ponieważ
        // this nie istnieje w kontekście statycznym
        Ball.footballCounter = footballCounter;
    }

    public static void setVolleyballCounter(int volleyballCounter) {
        Ball.volleyballCounter = volleyballCounter;
    }

    public static void setOtherballCounter(int otherballCounter) {
        Ball.otherballCounter = otherballCounter;
    }

    public static void getStatistics() {
        System.out.println("footballs: " + footballCounter);
        System.out.println("volleyballs: " + volleyballCounter);
        System.out.println("otherballs: " + otherballCounter);
        System.out.println("all: " + (footballCounter
                + otherballCounter + volleyballCounter));
    }

    public String toString() {
        return "Ball type: " + type;
    }
}
