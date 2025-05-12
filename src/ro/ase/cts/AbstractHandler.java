package ro.ase.cts;

public abstract class AbstractHandler implements  DataPackageHandler {
    protected DataPackageHandler next;

    @Override
    public void setNext(DataPackageHandler next) {
        this.next = next;
    }

    protected void passToNext(DataPackage dataPackage) {
        if (next != null) {
            next.handle(dataPackage);
        } else {
            throw new UnknownDataPackageException("Could not determine safety of package");
        }
    }
}
