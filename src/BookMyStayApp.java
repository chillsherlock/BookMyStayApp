/**
 * Book My Stay App
 * UC1: Entry Point
 * @version 1.0
 */
public class BookMyStayApp {

    public static void main(String[] args) {
        System.out.println("==================================");
        System.out.println(" Welcome to Book My Stay App ");
        System.out.println(" Version: 1.0 ");
        System.out.println("==================================");
    }
}

/**
 * Book My Stay App
 * UC2: Room Modeling
 * @version 2.0
 */
public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Book My Stay App - v2.0");

        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

        single.display();
        System.out.println("Available: " + singleAvailable);

        doubleRoom.display();
        System.out.println("Available: " + doubleAvailable);

        suite.display();
        System.out.println("Available: " + suiteAvailable);
    }
}

// Abstract class
abstract class Room {
    protected String type;
    protected int price;

    public Room(String type, int price) {
        this.type = type;
        this.price = price;
    }

    public abstract void display();
}

// Child classes
class SingleRoom extends Room {
    public SingleRoom() {
        super("Single", 1000);
    }

    public void display() {
        System.out.println("Single Room - Price: " + price);
    }
}

class DoubleRoom extends Room {
    public DoubleRoom() {
        super("Double", 2000);
    }

    public void display() {
        System.out.println("Double Room - Price: " + price);
    }
}

class SuiteRoom extends Room {
    public SuiteRoom() {
        super("Suite", 5000);
    }

    public void display() {
        System.out.println("Suite Room - Price: " + price);
    }
}

import java.util.HashMap;

/**
 * Book My Stay App
 * UC3: Inventory Management
 * @version 3.0
 */
public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Book My Stay App - v3.0");

        RoomInventory inventory = new RoomInventory();
        inventory.displayInventory();
    }
}

// Inventory class
class RoomInventory {

    private HashMap<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();
        inventory.put("Single", 5);
        inventory.put("Double", 3);
        inventory.put("Suite", 2);
    }

    public int getAvailability(String type) {
        return inventory.getOrDefault(type, 0);
    }

    public void displayInventory() {
        for (String key : inventory.keySet()) {
            System.out.println(key + " -> " + inventory.get(key));
        }
    }
}