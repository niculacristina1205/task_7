public class DataPackage {
    private String sourceIp;
    private String destIp;
    private String protocol;
    private int destPort;
    private boolean isPlainText;

    public DataPackage(String sourceIp, String destIp, String protocol, int destPort, boolean isPlainText) {
        this.sourceIp = sourceIp;
        this.destIp = destIp;
        this.protocol = protocol;
        this.destPort = destPort;
        this.isPlainText = isPlainText;
    }

    public String getSourceIp() {
        return sourceIp;
    }

    public void setSourceIp(String sourceIp) {
        this.sourceIp = sourceIp;
    }

    public String getDestIp() {
        return destIp;
    }

    public void setDestIp(String destIp) {
        this.destIp = destIp;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public int getDestPort() {
        return destPort;
    }

    public void setDestPort(int destPort) {
        this.destPort = destPort;
    }

    public boolean isPlainText() {
        return isPlainText;
    }

    public void setPlainText(boolean plainText) {
        isPlainText = plainText;
    }
}
