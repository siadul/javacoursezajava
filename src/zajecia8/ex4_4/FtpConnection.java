package zajecia8.ex4_4;

public class FtpConnection extends Connection {
    public void createHeaders() {
        System.out.println("some ftp headers...");
    }

    @Override
    public void connect() {
        System.out.println("connect ftp...");

    }

    @Override
    public void operate() {
        System.out.println("operate ftp...");

    }

    @Override
    public String read() {
        System.out.println("read ftp...");

        return "test ftp data reading";
    }

    @Override
    public void write(String content) {
        System.out.println("write ftp...");
    }
}
