/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelprogram;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Rahim
 */
public class HotelProgram {

    private static boolean MainMenu = true;
    private static boolean SubMenu = true;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        Room[] myHotel = new Room[10];
        myHotel[0] = new Room();
        myHotel[1] = new Room();
        myHotel[2] = new Room();
        myHotel[3] = new Room();
        myHotel[4] = new Room();
        myHotel[5] = new Room();
        myHotel[6] = new Room();
        myHotel[7] = new Room();
        myHotel[8] = new Room();
        myHotel[9] = new Room();
        int roomNum = 0;
        initialise(myHotel);
        while (MainMenu) {
            while (SubMenu) {
                System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
                System.out.println("Hello and Welcome to our Hotel Program\nPlease keep hands and feet in the vehicle at all time.");
                System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                System.out.println("Please select one of the options.");
                System.out.println("A: Book A New Room.");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("E: Display Empty Rooms.");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("V: View all Rooms.");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("D: Delete customer from room.");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("F: Find room from customer name.");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("S: Store program data in to file.");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("L: Load program data from file.");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("O: View rooms Ordered alphabetically by name.");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
                String Selection = input.next();
                Selection = Selection.toUpperCase();
                switch (Selection) {
                    case "A":
                        BookARoom(myHotel, roomNum);
                        break;
                    case "E":
                        CheckIfEmpty(myHotel);
                        break;
                    case "V":
                        ViewAllRooms(myHotel);
                        break;
                    case "D":
                        DeleteCustomerFromRoom(myHotel, roomNum);
                        break;
                    case "F":
                        FindRoomFromCustomerName(myHotel);
                        break;
                    case "S":
                        StoreProgramDataInToFile(myHotel);
                        break;
                    case "L":
                        LoadProgramDataFromFile(myHotel);
                        break;
                    case "O":
                        ViewRoomsOrderedAlphabeticallyByName(myHotel);
                        break;
                    default:
                        System.out.println("Invalid Selection");
                        break;
                }
                System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
                System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                System.out.println("Would you like to Select another Option\n1 ) Yes\n2 ) No");
                System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
                System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                if (input.nextInt() == 1) {
                    SubMenu = true;
                } else {
                    SubMenu = false;
                }
            }
            SubMenu = true;
            System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            System.out.println("Would You Like To Continue With The Program\n1 ) Yes\n2 ) No");
            System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            if (input.nextInt() == 1) {
                MainMenu = true;
            } else {
                System.out.println("");
                System.exit(0);

            }
        }

    }

    private static void initialise(Room[] myHotel) {
        for (int x = 0; x < myHotel.length; x++) {
            myHotel[x].setName("nobody");
        }
    }

    private static void CheckIfEmpty(Room[] myHotel) {
        for (int x = 0; x < myHotel.length; x++) {
            if (myHotel[x].getName().equals("nobody")) {
                System.out.println("room " + (x + 1) + " is empty");
            }
        }
    }

    private static void BookARoom(Room[] myHotel, int roomNum) {
        String roomName;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter room number (1-10):");
        roomNum = input.nextInt() - 1;
        System.out.println("Enter name for room " + (roomNum + 1) + " :");
        roomName = input.next();
        myHotel[roomNum].setName(roomName);
    }

    private static void ViewAllRooms(Room[] myHotel) {
        for (int x = 0; x < myHotel.length; x++) {
            System.out.println("room " + (x + 1) + " occupied by " + myHotel[x].getName());
        }
    }

    private static void DeleteCustomerFromRoom(Room[] myHotel, int roomNum) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter room number to delete(1-10):");
        roomNum = input.nextInt() - 1;
        myHotel[roomNum].setName("nobody");
        System.out.println("Entery Deleted :)");
    }

    private static void FindRoomFromCustomerName(Room[] myHotel) {
        Scanner input = new Scanner(System.in);
        String roomName;
        System.out.println("Enter name to Search for:");
        roomName = input.next();
        int x;
        boolean Checker = false;
        for (x = 0; x < myHotel.length; x++) {
            if (roomName.equals(myHotel[x].getName())) {
                System.out.println("The Account That Matches That name is Account number " + x);
                Checker = true;
            }
        }
        if (Checker == false) {
            System.out.println("There are no Rooms Booked with that name\n(make sure you've used the correct CAP's)");
        }
    }

    private static void StoreProgramDataInToFile(Room[] myHotel) throws IOException {
        try (PrintWriter out = new PrintWriter(new FileWriter("/home/unix/student12/w1387769/outputfile.txt"))) {
            int x;
            for (x = 0; x < myHotel.length; x++) {
                out.println("Name and Room number is: " + myHotel[x].getName() + "at: " + x);
            }

        }
        System.out.println("All Room Names have been Saved.");
    }

    private static void LoadProgramDataFromFile(Room[] myHotel) throws IOException {
        FileInputStream fs = new FileInputStream("/home/unix/student12/w1387769/inputfile.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fs));
        for (int i = 0; i < myHotel.length; i++) {
            myHotel[i].setName(br.readLine());
        }
    }

    private static void ViewRoomsOrderedAlphabeticallyByName(Room[] myHotel) {
        String[] myStrArray = new String[myHotel.length];
        for (int i = 0; i < myHotel.length; i++) {
            myStrArray[i] = myHotel[1].getName();
        }

        Arrays.sort(myStrArray);
        for (int a = 0; a < myStrArray.length; a++) {
            System.out.println(myStrArray[a]);
        }

    }

    public static class Room {

        //protected String mainName;
        private String mainName;
        int guestsInRoom;

        public Room() {
            mainName = "k";

        }

        public void setName(String aName) {
            //  System.out.println("add name class method ");
            mainName = aName;
        }

        public String getName() {
            return mainName;
        }
    }
}