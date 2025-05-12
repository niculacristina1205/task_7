package ro.ase.cts.models.adapter;

import ro.ase.cts.interfaces.DataPackageHandler;
import ro.ase.cts.interfaces.Firewallable;
import ro.ase.cts.models.DataPackage;

public class FirewallAdapter implements Firewallable {
    private final DataPackageHandler entryHandler;

    public FirewallAdapter(DataPackageHandler entryHandler) {
        this.entryHandler = entryHandler;
    }

    @Override
    public void checkIfThisThingWillBlowUpOurComputers(Object something) {
        if (!(something instanceof DataPackage)) {
            throw new IllegalArgumentException("Expected a DataPackage");
        }
        DataPackage pkg = (DataPackage) something;
        entryHandler.handle(pkg);
    }
}

