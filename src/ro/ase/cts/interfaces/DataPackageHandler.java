package ro.ase.cts.interfaces;

import ro.ase.cts.models.DataPackage;

public interface DataPackageHandler {
    void setNext(DataPackageHandler next);
    void handle(DataPackage dataPackage);
}
