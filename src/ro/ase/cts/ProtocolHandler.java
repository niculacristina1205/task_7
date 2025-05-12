package ro.ase.cts;

public class ProtocolHandler extends AbstractHandler{
    @Override
    public void handle(DataPackage dataPackage) {
        String protocol = dataPackage.getProtocol().toUpperCase();
        switch (protocol) {
            case "SSH":
            case "HTTPS":
            case "SSL":
                System.out.println("SAFE: Protocol");
                break;
            case "TELNET":
                System.out.println("UNSAFE: Protocol");
                break;
            default:
                passToNext(dataPackage);
        }
    }
}
