import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



public class CruiseShipBoarding {
    static Scanner myscan = new Scanner(System.in);
    static String reply;
    static int TotcabinNum = 12;
    static String[] cabins = new String[12];
    static ArrayList<String> CustomersNames = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome !\n");

        do {
            System.out.println("\nEnter V to view all cabins\n" +
                    "Enter E to display empty cabins\n" +
                    "Enter A to add customers to cabins\n" +
                    "Enter D to delete customers from cabin\n" +
                    "Enter O to view passengers order alphabetically by name\n" +
                    "Enter S to store passengers data into files\n" +
                    "Enter L to load passengers data from files\n" +
                    "Enter F to find cabin number by passenger name\n" +
                    "Enter EX to Exit the Program\n");
            System.out.print("Enter the suitable keynumber or keyword according to your need : ");
            reply = myscan.nextLine();
            switch (reply){
                case "V":
                    viewCabins();
                    break;
                case "E" :
                    viewEmptyCabins();
                    break;
                case "A" :
                    addCustomers();
                    break;
                case "D" :
                    removeCustomers();
                    break;
                case "O" :
                    viewCustomersOder();
                    break;
                case "S" :
                    storeProgramData();
                    break;
                case "L" :
                    loadProgramData();
                    break;

                case "F" :
                    findCabin();
                    break;
                case "EX" :
                    exit();
                    break;




            }


        }
        while (true);
    }

    static void viewCabins(){
        for (int x = 0; x <12; x++) {
            if (cabins[x] == (null)) {
                System.out.println("Cabin " + (x) + " is empty");
            } else {
                System.out.println("Cabin " + (x) + " occupied by " + cabins[x]);
            }
        }
    }


    public static void viewEmptyCabins(){
        for (int x = 0; x < 12; x++) {
            if (cabins[x] == (null)) {
                System.out.println("Cabin " + (x) + " is empty");
            }
        }
    }


    public static void addCustomers(){
        System.out.print("Enter Customer name : ");
        String name = myscan.nextLine();
        int cabinNum;
        do {
            System.out.print("Enter Cabin number (0-11): ");
            cabinNum = myscan.nextInt();
        }
        while ((0 > cabinNum) || (cabinNum > 12));
        myscan.nextLine();
        if(cabins[cabinNum-0] == (null)) {
            cabins[cabinNum - 0] = name;
            CustomersNames.add(name);
            TotcabinNum--;

        }

    }


    public static void removeCustomers(){
        System.out.print("Enter the passenger Cabin number to be removed :");
        int num = myscan.nextInt();
        myscan.nextLine();
        cabins[num] = null;
    }

    public static void viewCustomersOder(){
        for(int j=0;j<CustomersNames.size();j++) {
            for (int i = j + 1; i < CustomersNames.size(); i++) {
                if ((CustomersNames.get(i)).compareToIgnoreCase(CustomersNames.get(j)) < 0) {
                    String t = CustomersNames.get(j);
                    CustomersNames.set(j, CustomersNames.get(i));
                    CustomersNames.set(i, t);
                }
            }
        }
        System.out.println(CustomersNames);
    }

    public static void storeProgramData() throws IOException {
        File myObj = new File("filename.txt");
        myObj.createNewFile();
        System.out.println("File created: " + myObj.getName());

        FileWriter myWriter = new FileWriter("filename.txt");
        for(int i = 0 ; i< CustomersNames.size(); i++){
            myWriter.write(CustomersNames.get(i)+"\n");
        }
        myWriter.close();
        System.out.println("Successfully wrote to the file.");

    }

    public static void loadProgramData() throws IOException{
        File obj1 = new File("filename.txt");
        if(obj1.exists()){
            System.out.println("exsist");
            Scanner myReader = new Scanner(obj1);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        }
        else {
            System.out.println("mentioned file doesn't exsist");
        }

    }

    public static void findCabin(){
        int i;
        ArrayList<String> s=CustomersNames;


        System.out.print("Enter passenger name: ");
        String inName = myscan.nextLine();

        for (i = 0; i < 12; i++) {
            if (inName.equals(s.get(i))) {
                System.out.println("passenger occupied in cabin number: [" + (i) + "]");
                break;

            }
        }

    }

    public static void exit() {
        System.out.println("Exit");
        // Terminate JVM
        System.exit(0);
    }



}

