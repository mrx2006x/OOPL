import java.util.Scanner;

public class HotelBooking {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 2D Array for hotel rooms
        int rooms[][] = new int[3][5];

        int choice;

        do {

            System.out.println("\n===== HOTEL ROOM BOOKING SYSTEM =====");
            System.out.println("1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch(choice) {

                case 1:

                    System.out.println("\nRoom Status:");
                    System.out.println("0 = Available");
                    System.out.println("1 = Booked\n");

                    for(int i = 0; i < rooms.length; i++) {

                        System.out.println("Floor " + (i + 1) + ":");

                        for(int j = 0; j < rooms[i].length; j++) {

                            System.out.print("Room " + (j + 1) + " : " + rooms[i][j] + "   ");
                        }

                        System.out.println("\n");
                    }

                    break;

                case 2:

                    System.out.print("Enter Floor Number (1-3): ");
                    int floor = sc.nextInt();

                    System.out.print("Enter Room Number (1-5): ");
                    int room = sc.nextInt();

                    // Check booking
                    if(rooms[floor - 1][room - 1] == 0) {

                        rooms[floor - 1][room - 1] = 1;

                        System.out.println("Room Booked Successfully.");
                    }

                    else {

                        System.out.println("Room Already Booked.");
                    }

                    break;

                case 3:

                    System.out.println("Exiting System...");
                    break;

                default:

                    System.out.println("Invalid Choice!");
            }

        } while(choice != 3);

        sc.close();
    }
}