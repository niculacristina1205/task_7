package ro.ase.cts;

public class FirawallAdapter implements Firewallable {
    private final DataPackageHandler entryHandler;

    public FirawallAdapter(DataPackageHandler entryHandler) {
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

