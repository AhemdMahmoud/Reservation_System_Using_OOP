import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create some rooms
        Room room1 = new Room("Single", 101, 50.0);
        Room room2 = new Room("Double", 201, 80.0);
        Room room3 = new Room("Suite", 301, 120.0);
        Room room4 = new Room("Single", 102, 50.0);
        Room room5 = new Room("Double", 202, 80.0);

        // Add the rooms to an ArrayList
        ArrayList<Room> rooms = new ArrayList<Room>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room4);
        rooms.add(room5);

        // Create a hotel with the rooms
        Hotel hotel = new Hotel("My Hotel", rooms);

        // Get the reservation details from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your email address: ");
        String email = scanner.nextLine();
        System.out.print("Enter your phone number: ");
        String phone = scanner.nextLine();
        System.out.print("Enter the check-in date (yyyy-mm-dd): ");
        LocalDate checkInDate = LocalDate.parse(scanner.nextLine());
        System.out.print("Enter the check-out date (yyyy-mm-dd): ");
        LocalDate checkOutDate = LocalDate.parse(scanner.nextLine());

        // Display the available rooms for the given date range
        ArrayList<Room> availableRooms = hotel.getAvailableRooms(checkInDate, checkOutDate);
        System.out.println("Available rooms from " + checkInDate + " to " + checkOutDate + ":");
        for (Room room : availableRooms) {
            System.out.println("Room " + room.getRoomNumber() + " (" + room.getRoomType() + ") - $" + room.getPrice() + " per night");
        }

        // Prompt the user to select a room and reserve it
        System.out.print("Enter the room number to reserve: ");
        int roomNumber = scanner.nextInt();
        Customer customer = new Customer(name, email, phone);
        Reservation reservation = hotel.reserveRoom(roomNumber, customer, checkInDate, checkOutDate);
        if (reservation != null) {
            System.out.println("Reservation successful! Total cost: $" + reservation.getTotalCost());
        } else {
            System.out.println("Reservation failed. Room not available.");
        }
    }
}
