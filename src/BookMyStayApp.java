import java.util.*;

/**
 * UC6: Room Allocation
 * @version 6.0
 */
public class BookMyStayApp {

    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();
        BookingQueue queue = new BookingQueue();

        queue.addRequest(new Reservation("Alice", "Single"));
        queue.addRequest(new Reservation("Bob", "Single"));

        BookingService service = new BookingService(inventory);

        Reservation r;
        while ((r = queue.getNext()) != null) {
            service.allocate(r);
        }
    }
}

// Inventory
class RoomInventory {
    HashMap<String, Integer> inventory = new HashMap<>();

    public RoomInventory() {
        inventory.put("Single", 2);
    }

    int getAvailability(String type) {
        return inventory.getOrDefault(type, 0);
    }

    void update(String type, int count) {
        inventory.put(type, count);
    }
}

// Reservation
class Reservation {
    String name;
    String roomType;

    Reservation(String name, String roomType) {
        this.name = name;
        this.roomType = roomType;
    }
}

// Queue
class BookingQueue {
    Queue<Reservation> queue = new LinkedList<>();

    void addRequest(Reservation r) {
        queue.add(r);
    }

    Reservation getNext() {
        return queue.poll();
    }
}

// Booking Service
class BookingService {

    RoomInventory inventory;
    HashMap<String, Set<String>> allocated = new HashMap<>();

    BookingService(RoomInventory inventory) {
        this.inventory = inventory;
    }

    void allocate(Reservation r) {

        int available = inventory.getAvailability(r.roomType);

        if (available <= 0) {
            System.out.println("No rooms available");
            return;
        }

        String roomId = r.roomType + "-" + available;

        allocated.putIfAbsent(r.roomType, new HashSet<>());
        allocated.get(r.roomType).add(roomId);

        inventory.update(r.roomType, available - 1);

        System.out.println("Booked: " + r.name + " -> " + roomId);
    }
}