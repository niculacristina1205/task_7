public interface DataPackageHandler {
    void setNext(DataPackageHandler next);
    void handle(DataPackage dataPackage);
}
