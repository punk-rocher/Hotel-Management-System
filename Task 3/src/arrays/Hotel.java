package arrays;

import java.io.*;
import java.util.Scanner;  //Import Scanner

public class Hotel {

    public static int roomNum;             // Use the global variable for 'roomNum'
    public static String roomName;         // Use the global variable for 'roomName'
    public static String firstName;        // Use the global variable for "first name" as a "firstName"
    public static String lastName;         // Use the global variable for "Sure name" as a "lastName"
    public static String cdNumber;         // Use the global variable for "Credit card number" as a "cdNumber"
    public static int numGuest;            // Use the global variable for "Number of guests" as a "numGuest"

    public static Room[] hotel=new Room[8];             // Use the global array for 'Hotel'
    public static Person[] hotel1= new Person[8];       // Make hotel 1 array length is 8

    public static void main(String[] args) {
        hotel[0] = new Room();
        hotel[1] = new Room();                          //Hotel classes 1 st element equal to new room().
        hotel[2] = new Room();
        hotel[3] = new Room();
        hotel[4] = new Room();
        hotel[5] = new Room();
        hotel[6] = new Room();
        hotel[7] = new Room();

        hotel1[0]=new Person();
        hotel1[1]=new Person();                       //Hotel classes 1st element  equal to new person;
        hotel1[2]=new Person();
        hotel1[3]=new Person();
        hotel1[4]=new Person();
        hotel1[5]=new Person();
        hotel1[6]=new Person();
        hotel1[7]=new Person();

        initialise();
        menu();
    }

    private static void menu() {

        while (true) {

            System.out.println("<<<<<<<<  -     Hotel Program     -  >>>>>>>>");
            System.out.println("<<<<<<<<     -----     >>>>>>>>");
            System.out.println("A: Add customer rooms" + ".");
            System.out.println("V: View all Rooms.");
            System.out.println("E: Display Empty Rooms.");
            System.out.println("D: Delete customer from room.");
            System.out.println("F: Find room from customer name.");
            System.out.println("S: Store program data in to file.");
            System.out.println("L: Load program data from file.");
            System.out.println("O: View guests Ordered alphabetically by name.");
            System.out.println("<<<<<<<<     -----     >>>>>>>>");

            Scanner scan = new Scanner(System.in);          //Make the object scan
            System.out.println("Enter to Get stared -: ");

            char menu = scan.next().charAt(0);

            switch (menu) {               // Use the switch method
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

    private static void addRooms() {       //Make the add room method

        Scanner input = new Scanner(System.in);
        System.out.println("Enter room number (0-7) or 8 to stop: ");
        roomNum = input.nextInt();

        System.out.println("Enter name for room " + roomNum + " : ");
        roomName = input.next();
        hotel[roomNum].setName(roomName);

        Scanner input1 = new Scanner(System.in);
        System.out.println("Enter your first name : ");
        firstName =input1.next();
        hotel1[roomNum].setFirstName(firstName);

        System.out.println("Enter your sure name : ");
        lastName = input1.next();
        hotel1[roomNum].setLastName(lastName);

        System.out.println("Number of guests : ");
        numGuest = input1.nextInt();
        hotel1[roomNum].setNumGuest(numGuest);

        System.out.println("Enter your Credit Card number : ");
        cdNumber = input1.next();
        hotel1[roomNum].setCdNumber(cdNumber);


        if (roomNum==8){
            System.exit(0);
        }
    }

    private static void viewAll() {        //Make the view all method

        for (int x = 0; x < 8; x++) {

            System.out.println();
            System.out.println("room " + x + " Reserved by : " + hotel[x].getName());
            System.out.println("room " + x + " First Name : " + hotel1[x].getFirstName());
            System.out.println("room " + x + " Sure Name : " + hotel1[x].getLastName());
            System.out.println("room " + x + " Number of guests : " + hotel1[x].getNumGuest());
            System.out.println("room " + x + " Credit Card Number : " + hotel1[x].getCdNumber());
            System.out.println();
        }
    }

    private static void initialise() {

        for (int x = 0; x < 8; x++) hotel[x].setName("");
        for (int x = 0; x < 8; x++) hotel1[x].setFirstName("");
        for (int x = 0; x < 8; x++) hotel1[x].setLastName("");
        for (int x = 0; x < 8; x++) hotel1[x].setNumGuest(numGuest);
        for (int x = 0; x < 8; x++) hotel1[x].setCdNumber("");               //initialise
    }

    private static void empty() {                 //Make the empty method

        for (int x = 0; x < 8; x++) {
            if (hotel[x].getName().equals("")) System.out.println("room " + x + " is empty");
        }
    }

    private static void DeleteRoom() {             //Make the delete method
        Scanner input = new Scanner(System.in);
        System.out.println("Enter room number to delete(1-8):");
        int delRoom = input.nextInt();
        hotel[delRoom].setName("");
        hotel1[delRoom].setFirstName("");
        hotel1[delRoom].setLastName("");
        hotel1[delRoom].setNumGuest(0);
        hotel1[delRoom].setCdNumber("");
        System.out.println("Room Deleted");
    }

    private static void RoomFromCustomerName() {          //Make the Find room customer  method

        Scanner input = new Scanner(System.in);
        String roomName;
        System.out.println("Enter name to find that room :");
        roomName = input.next();
        int x;
        boolean examining = false;
        for (x = 0; x < hotel.length; x++) {
            if (roomName.equals(hotel[x].getName())) {

                System.out.println(" Resident room number " + x);
                examining = true;
            }
        }
        if (!examining) {
            System.out.println("There are no resident on that name \n Please enter the correct name again !");
        }
    }

    private static void StoreProgram() {         //Make the Find room Store Programme  method

        try (PrintWriter out = new PrintWriter(new FileWriter("E:\\1st year\\2 nd sem\\4COSC010C.2 Software Development II\\w1809768 SD CW\\Task 3\\Store Data.txt"))) {
            int x;
            for (x = 0; x < hotel.length; x++) {

                out.println("Name and Room number is: " + hotel[x].getName() + "at: " + x);
                out.println("First Name is :" + hotel1[x].getFirstName());
                out.println("Sure Name is : " + hotel1[x].getLastName());
                out.println("Number of guests : " + hotel1[x].getNumGuest());
                out.println("Reserves credit card number : " + hotel1[x].getCdNumber());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("All Room Names have been Saved.");
    }

    private static void LoadProgramDataFromFile() {         //Make the Load data method

        try {
            File myObj = new File("E:\\1st year\\2 nd sem\\4COSC010C.2 Software Development II\\w1809768 SD CW\\Task 3\\Store Data.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println(" Error .");
            e.printStackTrace();
        }
    }

    private static void AlphabeticallyByName() {         //Make the alphabetically method

        String[] hotelRef = new String[hotel.length];       // Create the array "getary" equal  to hotel length
        for (int k = 0; k < hotel.length; k++) {
            hotelRef[k] = hotel[k].getName();               // Equal the getary "z" to hotel "z"
        }
        for (int i = 0; i < 8; i++) {

            for (int j = i + 1; j < 8; j++) {

                if (hotelRef[i].compareTo(hotelRef[j]) > 0) {         // Compare the i and j make them alphabetically order

                    String temp = hotelRef[i];                       // to compare one string with other strings
                    hotelRef[i] = hotelRef[j];
                    hotelRef[j] = temp;
                }
            }
        }

        for (int i=0; i<hotelRef.length; i++){
            System.out.println(hotelRef[i]+ " ");
        }
        System.out.println();
    }
}
