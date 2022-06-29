package task1;

public class Controller {

    public static void controlIP(IPAddress ipAddress) {
        if (ipAddress.getIpAddress().matches("((1?[0-9]?[0-9]|2[0-5][0-5])\\.){3}(1?[0-9]?[0-9]|2[0-5][0-5])")) {
            System.out.println(ipAddress.toString() + " is valid");
        } else {
            System.out.println(ipAddress.toString() + " is not valid");
        }
    }

}
