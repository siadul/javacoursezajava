package zajecia8.ex4_4;

public class HttpConnection extends Connection {
    public void createHeaders() {
        System.out.println("some http headers...");
    }

    @Override
    public void connect() {
        System.out.println("connect http...");

    }

    @Override
    public void operate() {
        System.out.println("operate http...");

    }

    @Override
    public String read() {
        System.out.println("read http...");

        return "test http data reading";
    }

    @Override
    public void write(String content) {
        System.out.println("write http...");
    }
}
