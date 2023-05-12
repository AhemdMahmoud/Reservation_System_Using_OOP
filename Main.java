import java.time.LocalDate;
import java.util.ArrayList;

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

        // Display the available rooms for a certain date range
        LocalDate checkInDate = LocalDate.of(2023, 5, 15);
        LocalDate checkOutDate = LocalDate.of(2023, 5, 20);
         ArrayList<Room> availableRooms = hotel.getAvailableRooms(checkInDate, checkOutDate);
        System.out.println("Available rooms from " + checkInDate + " to " + checkOutDate + ":");
        for (Room room : availableRooms) {
            System.out.println("Room " + room.getRoomNumber() + " (" + room.getRoomType() + ") - $" + room.getPrice() + " per night");
        }

        // Reserve a room
        Customer customer = new Customer("John Smith", "john@example.com", "555-1234");
        int roomNumber = 201;
        Reservation reservation = hotel.reserveRoom(roomNumber, customer, checkInDate, checkOutDate);
        if (reservation != null) {
            System.out.println("Reservation successful! Total cost: $" + reservation.getTotalCost());
        } else {
            System.out.println("Reservation failed. Room not available.");
        }
    }
}
