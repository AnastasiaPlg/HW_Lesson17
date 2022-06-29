package task1;

public class MainClass {
    public static void main(String[] args) {
        IPAddress ipAddress = new IPAddress("255.12.158.36");
        Controller.controlIP(ipAddress);
    }
}
