import java.util.HashMap;

/**
 * UC4: Room Search
 * @version 4.0
 */
public class BookMyStayApp {

    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();

        Room[] rooms = {
                new SingleRoom(),
                new DoubleRoom(),
                new SuiteRoom()
        };

        System.out.println("Available Rooms:");

        for (Room room : rooms) {
            int available = inventory.getAvailability(room.type);

            if (available > 0) {
                room.display();
                System.out.println("Available: " + available);
            }
        }
    }
}

// Inventory
class RoomInventory {
    private HashMap<String, Integer> inventory = new HashMap<>();

    public RoomInventory() {
        inventory.put("Single", 5);
        inventory.put("Double", 3);
        inventory.put("Suite", 2);
    }

    public int getAvailability(String type) {
        return inventory.getOrDefault(type, 0);
    }
}

// Room classes
abstract class Room {
    protected String type;
    protected int price;

    public Room(String type, int price) {
        this.type = type;
        this.price = price;
    }

    public abstract void display();
}

class SingleRoom extends Room {
    public SingleRoom() { super("Single", 1000); }
    public void display() { System.out.println("Single Room - " + price); }
}

class DoubleRoom extends Room {
    public DoubleRoom() { super("Double", 2000); }
    public void display() { System.out.println("Double Room - " + price); }
}

class SuiteRoom extends Room {
    public SuiteRoom() { super("Suite", 5000); }
    public void display() { System.out.println("Suite Room - " + price); }
}