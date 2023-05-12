import java.time.LocalDate;
import java.util.ArrayList;

// Room class
public class Room {
    private String roomType;
    private int roomNumber;
    private double price;
    private boolean available;

    public Room(String roomType, int roomNumber, double price) {
        this.roomType = roomType;
        this.roomNumber = roomNumber;
        this.price = price;
        this.available = true;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}