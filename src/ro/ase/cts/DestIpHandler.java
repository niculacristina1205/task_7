package ro.ase.cts;

public class DestIpHandler extends AbstractHandler{
    @Override
    public void handle(DataPackage dataPackage) {
        String destIp = dataPackage.getDestIp();
        if ("192.168.0.1".equals(destIp)) {
            System.out.println("SAFE: Destination IP");
        } else if (destIp != null) {
            passToNext(dataPackage);
        } else {
            throw new UnknownDataPackageException("Destination IP is null or invalid.");
        }
    }
}
