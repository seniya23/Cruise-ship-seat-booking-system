import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Cabin {
    Main main = new Main();
    Passenger passenger = new Passenger();
    int m = 0;
    static Passenger[][] ships = new Passenger[12][3];
    String[][] line = new String[10][3];

    //object creating method ---------------------------
    public void obj() {
        Passenger Emp = new Passenger();
        for (int p = 0; p < 12; ++p) {
            for (int y = 0; y < 3; ++y) {
                ships[p][y] = new Passenger();
                ships[p][y].f_name = "Empty";
               

            }
        }
    }

    //view full cabin details------------------------
    static void viewCabins() {
        for (int v = 0; v < 12; ++v) {
            for (int w = 0; w < 3; ++w)
                if(ships[v][w].f_name.equals("Empty")){
                    System.out.println(" Cabin " + v + " is " + ships[v][w].f_name);
                }
                else {
                    System.out.println("Cabin " + v + " occupied by " + ships[v][w].f_name);
                }
        }

    }
    static void viewEmptyCabins(){
        for (int v = 0; v < 12; ++v) {
            for (int w = 0; w < 3; ++w)
                if(ships[v][w].f_name.equals("Empty")){
                    System.out.println(" Cabin " + v + " is " + ships[v][w].f_name);
                }

        }


    }

    Scanner scanner = new Scanner(System.in);
    int A_count = 0;

    //add customers to cabin ------------------------------------------------------------
    public void addCustomers() {
        System.out.println("Enter a cabin number (0-11):");
        int numb = scanner.nextInt();
        int val = 0;
        int family = 0;
        for (int x = 0; x < 12; ++x) {
            for (int y = 0; y < 3; ++y) {
                if (!(ships[x][y].f_name.equals("Empty"))) {
                    val = val + 1;

                } else {
                    continue;

                }
            }
            if (val != 0) {
                family = family + 1;
                val = 0;

            }

        }
        if (family != 12) {
            for (int i = 0; i < 3; ++i) {
                int count;
                if (ships[numb][i].f_name.equals("Empty")) {

                    System.out.println(numb + ":" + (i + 1) + " " + "is empty , you can add a customer");
                    Scanner sc = new Scanner(System.in);
                    System.out.println("firstname");
                    passenger.f_name = sc.nextLine();
                    System.out.println("lastname");
                    passenger.l_name = sc.nextLine();
                    System.out.println("Expenses");
                    passenger.expenses = sc.nextDouble();
                    ships[numb][i].expenses = passenger.expenses;
                    ships[numb][i].l_name = passenger.l_name;
                    ships[numb][i].f_name = passenger.f_name;
                    System.out.println("Successfully added the customer");
                    break;
                } else {
                    count = 0;
                    count = count + 1;
                }
                if (count == 3) {
                    System.out.println("Cabin no " + numb + " " + "is totally full");
                }

            }

        } else {
            System.out.println("All the cabins are full.Stay in the queue");
            add_queue();

        }

    }


    //add passengers into queue ---------------------------------------------------------
    public void add_queue() {
        for (int que_no = 0; que_no < 10; ++que_no) {
            if (line[que_no][0].equals("Empty")) {
                System.out.println(que_no);
                Scanner sc = new Scanner(System.in);
                System.out.print("firstname: ");
                passenger.f_name = sc.nextLine();
                System.out.print("lastname: ");
                passenger.l_name = sc.nextLine();
                System.out.print("Expenses: ");
                passenger.expenses = sc.nextDouble();

                line[que_no][0] = passenger.f_name;
                line[que_no][1] = passenger.l_name;
                line[que_no][2] = String.valueOf(passenger.expenses);
                System.out.println("Successfully added to the queue");
                break;

            } else {
                A_count = A_count + 1;
                continue;
            }
        }
        if (A_count == 10) {
            System.out.println("Queue is also totally full ");

        }

    }

    //add passengers from queue-----------------------
    public String del_queue() {

        for (int j = 0; j < 10; ++j) {
            if (!(line[j][0].equals("Empty"))) {
                String nxt_name = (line[j][0]);
                line[j][0] = "Empty";
                return nxt_name;
            }


        }
        return "return";
    }

    public void viewCustomersOder() {
        String[] sort = new String[36];
        for (int p = 0; p < 12; ++p) {
            for (int y = 0; y < 3; ++y) {
                sort[(3 * p) + y] = ships[p][y].f_name;
            }
        }
        for (int i = 0; i < sort.length; ++i) {
            for (int j = i + 1; j < sort.length; ++j) {
                if (sort[i].compareToIgnoreCase(sort[j]) > 0) {
                    String pre = sort[i];
                    sort[i] = sort[j];
                    sort[j] = pre;
                }

            }
        }
        System.out.println("After sorting ---------------------");
        for (int i = 0; i < 36; ++i) {
            System.out.println(sort[i]);
        }

    }


    //delete passenger by name.----------------------------------------------------
    public  void removeCustomers(){
        int value=0;
        System.out.print("Enter the cabin number you'd want to remove. ");
        int del_numb = scanner.nextInt();
        scanner.nextLine();
        System.out.println("del name");
        passenger.f_name=scanner.nextLine();

        for (int i=0;i<3;++i){
            if (ships[del_numb][i].f_name.equals(passenger.f_name) ){
                ships[del_numb][i].f_name="Empty";
                ships[del_numb][i].expenses=00.00;

                System.out.println("Successfully removed"+" "+passenger.f_name+" "+"from cabin no :"+" "+del_numb);
                String x= del_queue();
                if (!(x.equals("return"))){
                    ships[del_numb][i].f_name=x;
                    System.out.println("The queue has been successfully added.");
                    break;

                }else{
                    break;
                }
            }else {
                value=value+1;
                continue;
            }
        }if (value == 3) {
            System.out.println("There isn't a match.");
        }

    }
    //find cabin by passenger name------------------------------------------------------------------
    public void findCabin(){
        System.out.println("Fill in the name of the customer.");
        passenger.f_name=scanner.next();
        scanner.nextLine();
        System.out.println(passenger.f_name);
        for (int N=0;N<12;++N){
            for (int M = 0; M<3; ++M){
                if (ships[N][M].f_name.equals(passenger.f_name)){
                    System.out.println("cabin no :"+" "+N);
                    break;
                }
                else {
                    m=m+1;
                    continue;


                }

            }


        }
        if (m==36) {
            System.out.println("Not a valid customer");
        }

    }

    //calculate expenses of passengers-------------------------------------------
    public void expenses(){
        double total=0;
        for (int i=0;i<12;++i){
            for (int j=0;j<3;++j){
                System.out.println(ships[i][j].f_name +": "+ ships[i][j].expenses);
                total= (total +Double.parseDouble(String.valueOf(ships[i][j].expenses)));
            }
        }
        System.out.println("total expenses: "+total);
    }

    static void storeProgramData() {
        try {
            File myObj = new File("text.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        //file writing
        try {
            FileWriter myWriter = new FileWriter("text.txt");
            for (int i=0;i<12;++i){
                for (int j=0;j<3;++j){
                    myWriter.write(String.valueOf(ships[i][j].f_name)+" ");
                }
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    static void loadProgramData(){
        try {

            File file = new File("text.txt");
            if (!Desktop.isDesktopSupported())
            //check if Desktop is supported by Platform or not
            {
                System.out.println("not supported");
                return;
            }
            Desktop desktop = Desktop.getDesktop();
            if (file.exists()) //checks file exists or not
                desktop.open(file); //opens the specified file
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void exit() {
        System.out.println("Exit");
        // Terminate JVM
        System.exit(0);
    }


}

