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