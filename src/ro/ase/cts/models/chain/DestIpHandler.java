package ro.ase.cts.models.chain;

import ro.ase.cts.exceptions.UnknownDataPackageException;
import ro.ase.cts.models.DataPackage;

public class DestIpHandler extends AbstractHandler {
    @Override
    public void handle(DataPackage dataPackage) {
        String destIp = dataPackage.getDestIp();
        if (destIp.equals("192.168.0.1")) {
            System.out.println("SAFE: Destination IP");
        } else {
            System.out.println("UNKNOWN: Destination IP");
            passToNext(dataPackage);
        }
    }
}
