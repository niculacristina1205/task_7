package ro.ase.cts;

public class PlainTextHandler extends AbstractHandler{
    @Override
    public void handle(DataPackage dataPackage) {
        if (dataPackage.isPlainText()) {
            System.out.println("SAFE: Plaintext is allowed");
        } else {
            throw new UnknownDataPackageException("UNKNOWN: Cannot determine encryption state");
        }
    }
}
