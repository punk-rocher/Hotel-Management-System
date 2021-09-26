package arrays;

import java.util.Scanner;                       //Import Scanner
import java.io.FileWriter;                      //Import File Writer
import java.io.IOException;                     //Import checked exception
import java.io.PrintWriter;                     //Import Print Writer
import java.io.File;                            // Import the File class
import java.io.FileNotFoundException;           // Import this class to handle errors


public class Hotel2 {

    public static int roomNum;                                     // Global Variables
    public static String roomName;                                 // Global Variables

    public static String[] hotel = new String[8];                  // Use the global array for 'Hotel'
    public static String[] firstName = new String[8];              // Use the global array for 'first name'
    public static String[] lastName = new String[8];               // Use the global array for 'sure  name'
    public static Integer[] numGuest= new Integer[8];              // Use the global array for 'number of guests'
    public static String[] cdNumber = new String[8];               // Use the global array for 'credit card number '


    public static String firstname;                               // Use the global variable for "first name" as a "firstname"
    public static String lastname;                                // Use the global variable for "sure name" as a "lastname"
    public static int numguest;                                   // Use the global variable for "number of guest " as a "numguest"
    public static String cdnumber;                                // Use the global variable for "credit card number// " as a  "cdnumber"


    public static void main(String[] args) {        // Run the Main

        initialise();                //Run the initialise method for first
        menu();                      // Run the menu method for second
    }

    private static void menu() {      // Starts the Menu function

        while (true) {                // create a while loop for menu

            System.out.println("<<<<<<<<- Hotel Program ->>>>>>>>");
            System.out.println("<<<<<<<< ----- >>>>>>>>");
            System.out.println("A: Add customer rooms" + ".");
            System.out.println("V: View all Rooms.");
            System.out.println("E: Display Empty Rooms.");
            System.out.println("D: Delete customer from room.");
            System.out.println("F: Find room from customer name.");
            System.out.println("S: Store program data in to file.");
            System.out.println("L: Load program data from file.");
            System.out.println("O: View guests Ordered alphabetically by name.");
            System.out.println("<<<<<<<< ----- >>>>>>>>");

            Scanner scan = new Scanner(System.in);            // Create a object scan
            System.out.println("Enter to Get stared -: ");

            char menu = scan.next().charAt(0);                // Getting  Input

            switch (menu) {                                   //using the  Switch method for menu
                case 'A':
                case 'a':
                    addRooms();
                    break;
                case 'V':
                case 'v':
                    viewAll();
                    break;
                case 'E':
                case 'e':
                    empty();
                    break;
                case 'D':
                case 'd':
                    DeleteRoom();
                    break;
                case 'F':
                case 'f':
                    RoomFromCustomerName();
                    break;
                case 'S':
                case 's':
                    StoreProgram();
                    break;
                case 'L':
                case 'l':
                    LoadProgramDataFromFile();
                    break;
                case 'O':
                case 'o':
                    AlphabeticallyByName();
                    break;
                default:
                    System.out.println(" Invalid Character ");
                    break;
            }
        }
    }

    private static void addRooms() {               //Make a  addroom method for add the users

        Scanner input = new Scanner(System.in);

        System.out.println("Enter room number (0-7) or 8 to stop:");
        roomNum = input.nextInt();
        System.out.println("Enter name for room " + roomNum + " :");
        roomName = input.next();
        System.out.println("Enter your first name  :");
        firstname = input.next();
        System.out.println("Enter your sure name  :");
        lastname= input.next();
        System.out.println("Number of guests :");
        numguest= input.nextInt();
        System.out.println("Enter your credit card number  :");
        cdnumber = input.next();


        hotel[roomNum] = roomName;            //hotel array roomNum index equal to room name
        firstName[roomNum]=firstname;
        lastName[roomNum] =lastname;
        numGuest[roomNum] =numguest;
        cdNumber[roomNum] =cdnumber;

        if (roomNum==8){
            System.exit(0);
        }
    }

    private static void viewAll() {          //Make a view all method

        for (int x = 0; x < 8; x++) {

            System.out.println("room " + x + " reserved by " + hotel[x] + "\n First Name :" + firstName[x] + "\n Surname: "+ lastName[x]+ "\n Number of guests: " + numGuest[x]+ "\nCredit card number: "+ cdNumber[x]+"\n");
        }
    }

    private static void initialise() {                                  // Make a initialise method

        for (int x = 0; x < 8; x++) {
            hotel[x] = ""; //initialise
            firstName[x] = " ";
            lastName[x]=" ";
            cdNumber[x] = "";
            numGuest[x] = 0;
            initialise(hotel);                                         //better to initialise in a procedure
        }
    }

    private static void initialise(String[] hotelRef) {

        for (int x = 0; x < 8; x++) {

            hotelRef[x] = "";
            firstName[x] = " ";
            lastName[x] = " ";
            cdNumber[x] = "";
            numGuest[x] = 0;
        }
    }

    private static void empty() {                                              // Make a empty room  method

        for (int x = 0; x < 8; x++) {
            if (hotel[x].equals(""))
                System.out.println("room " + x + " is empty");
        }
    }

    private static void DeleteRoom() {                                        // Make a delete method

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter room number to delete(1-8):");
        int delRoom = scan.nextInt();
        hotel[delRoom] = "";
        firstName[delRoom] = "";
        lastName[delRoom]="";
        cdNumber[delRoom] = "";
        numGuest[delRoom] = 0;
        System.out.println("Room number " + delRoom + "customer details deleted");          // If hotel array index equal to delRoom get equals to ""
        System.out.println(" All Deleted");
    }

    private static void RoomFromCustomerName() {                              // Make a customer  method

        Scanner scan = new Scanner(System.in);
        String roomName;
        System.out.println("Enter name to find that room :");
        roomName = scan.next();
        int x;
        boolean examining = false;
        for (x = 0; x < hotel.length; x++) {
            if (roomName.equals(hotel[x])) {
                System.out.println(" Resident room number " + x);
                examining = true;
            }
        }
        if (!examining) {
            System.out.println("There are no resident on that name \n Please enter the correct name again !");
        }
    }

    private static void StoreProgram() {                                 // Make a Store Program method

        try (PrintWriter out = new PrintWriter(new FileWriter("E:\\1st year\\2 nd sem\\4COSC010C.2 Software Development II\\w1809768 SD CW\\Task 3 part 2\\Store Data.txt"))) {    //Save the path for store
            int x;
            for (x = 0; x < hotel.length; x++) {

                out.println("Name and Room number is : " + hotel[x] + " at: " + x);
                out.println("First name is : " + firstName[x]);
                out.println("Sure name is : " + lastName[x]);
                out.println("Number of guests : " + numGuest[x]);
                out.println("Reserves credit card number : "+ cdNumber[x]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("All Room Names have been Saved.");
    }

    private static void LoadProgramDataFromFile() {                     // Make a Load the program data from file method

        try {

            File myObj = new File("E:\\1st year\\2 nd sem\\4COSC010C.2 Software Development II\\w1809768 SD CW\\Task 3 part 2\\Store Data.txt");         // Save the path to load
            Scanner scan = new Scanner(myObj);
            while (scan.hasNextLine()) {
                String data = scan.nextLine();
                System.out.println(data);
            }
            scan.close();
        }
        catch (FileNotFoundException e) {

            System.out.println(" Error .");
            e.printStackTrace();
        }
    }

    private static void AlphabeticallyByName() {                       // Make a alphabetically method

        String[] getary = new String[hotel.length];                    // Create the array "getary" equal  to hotel length
        for (int z = 0; z < hotel.length; z++) {
            getary[z] = hotel[z];                                      // Equal the getary "z" to hotel "z"
        }
        for (int i = 0; i < 8; i++) {

            for (int j = i + 1; j < 8; j++) {

                if (getary[i].compareTo(getary[j]) > 0) {              // Compare the i and j make them alphabetically order

                    String temp = getary[i];
                    getary[i] = getary[j];
                    getary[j] = temp;
                }
            }

        }
        for (int i=0; i<getary.length; i++){

            System.out.println(getary[i]+ " ");                         //Print the Alphabetically order
        }
        System.out.println();
    }
}
