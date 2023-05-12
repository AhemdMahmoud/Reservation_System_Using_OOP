public class Hotel {
    private String name;
    private ArrayList<Room> rooms;

    public Hotel(String name, ArrayList<Room> rooms) {
        this.name = name;
        this.rooms = rooms;
    }

    public ArrayList<Room> getAvailableRooms(LocalDate checkInDate, LocalDate checkOutDate) {
         ArrayList<Room> availableRooms = new ArrayList<Room>();
        for (Room room : rooms) {
            if (room.isAvailable()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public Reservation reserveRoom(int roomNumber, Customer customer, LocalDate checkInDate, LocalDate checkOutDate) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && room.isAvailable()) {
                room.setAvailable(false);
                Reservation reservation = new Reservation(room, customer, checkInDate, checkOutDate);
                return reservation;
            }
        }
        return null;
    }
}