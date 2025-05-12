package ro.ase.cts.models.chain;

import ro.ase.cts.models.DataPackage;

public class DestPortHandler extends AbstractHandler {

    @Override
    public void handle(DataPackage dataPackage) {
        int port = dataPackage.getDestPort();
        if ((port >= 0 && port <= 1023)) {
            System.out.println("SAFE: Destination port");
        } else if (port >= 49152 && port <= 65535) {
            System.out.println("UNSAFE: Destination port");
        } else {
            passToNext(dataPackage);
        }
    }
}
