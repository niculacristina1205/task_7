package ro.ase.cts.app;

import ro.ase.cts.interfaces.DataPackageHandler;
import ro.ase.cts.interfaces.Firewallable;
import ro.ase.cts.models.DataPackage;
import ro.ase.cts.models.adapter.FirewallAdapter;
import ro.ase.cts.models.chain.*;

public class Main {
    public static void main(String[] args) {
        DataPackageHandler h1 = new SourceIpHandler();
        DataPackageHandler h2 = new DestIpHandler();
        DataPackageHandler h3 = new ProtocolHandler();
        DataPackageHandler h4 = new DestPortHandler();
        DataPackageHandler h5 = new PlainTextHandler();

        h1.setNext(h2);
        h2.setNext(h3);
        h3.setNext(h4);
        h4.setNext(h5);

        Firewallable firewall = new FirewallAdapter(h1);

        DataPackage pkg = new DataPackage("192.168.1.5", "192.168.0.1", "HTTPS", 443, true);
        firewall.checkIfThisThingWillBlowUpOurComputers(pkg);
    }
}