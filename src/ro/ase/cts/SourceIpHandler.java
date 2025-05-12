package ro.ase.cts;

public class SourceIpHandler  extends AbstractHandler{
    @Override
    public void handle(DataPackage dataPackage) {
        String ip = dataPackage.getSourceIp();
        if (ip.startsWith("192.168.")) {
            System.out.println("SAFE: Source IP");
        } else if (ip.startsWith("27.")) {
            System.out.println("UNSAFE: Source IP");
        } else {
            passToNext(dataPackage);
        }
    }
}
