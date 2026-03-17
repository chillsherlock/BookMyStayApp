import java.util.*;

/**
 * UC5: Booking Queue (FIFO)
 * @version 5.0
 */
public class BookMyStayApp {

    public static void main(String[] args) {

        BookingQueue queue = new BookingQueue();

        queue.addRequest(new Reservation("Alice", "Single"));
        queue.addRequest(new Reservation("Bob", "Double"));

        System.out.println("Booking Requests:");

        queue.displayQueue();
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

    void displayQueue() {
        for (Reservation r : queue) {
            System.out.println(r.name + " -> " + r.roomType);
        }
    }
}