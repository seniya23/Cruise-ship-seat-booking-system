import java.util.Locale;
import java.util.Scanner;
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Cabin room = new Cabin();

    public static void main(String[] args) {
        System.out.println("Welcome !\n");

        room.obj();

        for (int k = 0; k < 10; ++k) {
            room.line[k][0] = "Empty";
        }
        System.out.println("\nEnter V to view all cabins\n" +
                "Enter E to display empty cabins\n" +
                "Enter A to add customers to cabins\n" +
                "Enter D to delete customers from cabin\n" +
                "Enter O to view passengers order alphabetically by name\n" +
                "Enter S to store passengers data into files\n" +
                "Enter L to load passengers data from files\n" +
                "Enter F to find cabin number by passenger name\n" +
                "Enter EX to Exit the Program\n");

        int x = 0;
        while (true) {
            System.out.print("Enter the suitable keyword according to your need : ");
            String reply = scanner.next().toUpperCase(Locale.ROOT);
            switch (reply) {
                case "V":
                    room.viewCabins();
                    break;
                case "A":
                    room.addCustomers();
                    break;
                case "D":
                    room.removeCustomers();
                    break;
                case "E":
                    room.viewEmptyCabins();
                    break;
                case "F":
                    room.findCabin();
                    break;
                case "S":
                    room.storeProgramData();
                    break;
                case "L":
                    room.loadProgramData();
                    break;
                case "O":
                    room.viewCustomersOder();
                    break;
                case "T":
                    room.expenses();
                    break;
                case "EX" :
                    room.exit();
                    break;
            }

        }
    }
}


