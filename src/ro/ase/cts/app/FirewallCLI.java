package ro.ase.cts.app;

import ro.ase.cts.exceptions.UnknownDataPackageException;
import ro.ase.cts.interfaces.DataPackageHandler;
import ro.ase.cts.interfaces.Firewallable;
import ro.ase.cts.models.DataPackage;
import ro.ase.cts.models.adapter.FirewallAdapter;
import ro.ase.cts.models.chain.*;

import java.util.Scanner;

public class FirewallCLI {
    private final Scanner scanner = new Scanner(System.in);
    private Firewallable firewall;

    public void run() {
        setupFirewall();
        printWelcome();

        while (true) {
            DataPackage pkg = readUserInput();

            try {
                firewall.checkIfThisThingWillBlowUpOurComputers(pkg);
            } catch (UnknownDataPackageException e) {
                System.out.println("Verdict: " + e.getMessage());
            }

            if (!askRepeat()) {
                break;
            }
        }

        System.out.println("Exiting CLI");
        scanner.close();
    }

    private void setupFirewall() {
        DataPackageHandler h1 = new SourceIpHandler();
        DataPackageHandler h2 = new DestIpHandler();
        DataPackageHandler h3 = new ProtocolHandler();
        DataPackageHandler h4 = new DestPortHandler();
        DataPackageHandler h5 = new PlainTextHandler();

        h1.setNext(h2);
        h2.setNext(h3);
        h3.setNext(h4);
        h4.setNext(h5);

        this.firewall = new FirewallAdapter(h1);
    }

    private void printWelcome() {
        System.out.println("=== Firewall CLI ===");
    }

    private DataPackage readUserInput() {
        System.out.print("Source IP: ");
        String srcIp = scanner.nextLine();

        System.out.print("Destination IP: ");
        String destIp = scanner.nextLine();

        System.out.print("Protocol: ");
        String protocol = scanner.nextLine();

        System.out.print("Destination Port: ");
        int port = Integer.parseInt(scanner.nextLine());

        System.out.print("Is Plain Text? (true/false): ");
        boolean isPlain = Boolean.parseBoolean(scanner.nextLine());

        return new DataPackage(srcIp, destIp, protocol, port, isPlain);
    }

    private boolean askRepeat() {
        System.out.print("Analyze another packet? (yes/no): ");
        return scanner.nextLine().trim().equalsIgnoreCase("yes");
    }
}
