package task1;

public class IPAddress {
    private String ipAddress;

    public IPAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public String toString() {
        return "ipAddress '" + ipAddress + '\'';
    }
}
