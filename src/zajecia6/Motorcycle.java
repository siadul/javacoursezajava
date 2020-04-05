package zajecia6;

class Vehicle {
    private double power;
    private String color;
    private int wheels;

    Vehicle() {
        System.out.println("Vehicle constructor is running...");
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }
}

public class Motorcycle extends Vehicle {
    private String throttleGrip;

    public static void main(String[] args) {
        Superbike superbike1 = new Superbike();

        superbike1.setFairigns("Yamaha fairings");
        superbike1.setImu("Yamaha IMU");
        superbike1.setThrottleGrip("AliExpress throttle grip");
        superbike1.setColor("Yamaha blue");
        superbike1.setPower(200.0);
        superbike1.setWheels(2);

        // Wniosek
        // W przypadku dziedziecznia wielopoziomowego klasa znajdująca się najniżej
        // w hierarchi posiada dostęp do WSZYSTKICH nieprywatnych pól i metod z klas
        // stojących wyżej w tej hierarchii

    }

//    Motorcycle() {
//        System.out.println("Motorcycle constructor is running...");
//    }

    Motorcycle(int a) {
        System.out.println("Motorcycle constructor is running..." + a);
    }

    Motorcycle(int a, int b) {
        System.out.println("Motorcycle constructor is running..." + a + " " + b);
    }

    public String getThrottleGrip() {
        return throttleGrip;
    }

    public void setThrottleGrip(String throttleGrip) {
        this.throttleGrip = throttleGrip;
    }
}

class Superbike extends Motorcycle {
    private String fairigns;
    private String imu; // inertial measurement unit

    Superbike() {
//        super(); // występuje niejawnie
//        super(5);
        super(5, 10); // ponieważ istnieją wyłacznie sparametryzowane konstrutory
        // w klasie bazowej to muszę jawnie wywołać ten konstruktor za pomocą słowa "super"
        System.out.println("Superbike constructor is running...");
    }

    public String getFairigns() {
        return fairigns;
    }

    public void setFairigns(String fairigns) {
        this.fairigns = fairigns;
    }

    public String getImu() {
        return imu;
    }

    public void setImu(String imu) {
        this.imu = imu;
    }
}