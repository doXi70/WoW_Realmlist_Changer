package Application.Menu;

public class MainMenu {
    private boolean printHeader;
    private boolean printLogo;

    public MainMenu() {
        this.printHeader = true;
        this.printLogo = true;
    }

    public MainMenu(boolean printHeader, boolean printLogo) {
        this.printHeader = printHeader;
        this.printLogo = printLogo;
    }

    private static void printHeader() {
        System.out.println("** Welcome to World of warcraft realmlist changer! / ALPHA version / **");
        System.out.println("**  created by Miroslav Petkov - Fensi! All rights reserved©. **");
    }

    private static void printLogo() {

    }

    public void printMenu() {
        if (this.printHeader) {
            printHeader();
        }

        if (this.printLogo) {
            printLogo();
        }

        System.out.println("Choose option by entering the number in front of it and press Enter.");
        printMainOptions();
    }

    private void printMainOptions() {
        System.out.println("**** Main Menu ****");
        System.out.println("1. Auto configure everything for me.");
        System.out.println("2. Log to your off-server.");
        System.out.println("Press any key to log to your main server.");
    }
}
