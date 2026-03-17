import java.util.*;

/**
 * UC8: Booking History
 */
public class BookMyStayApp {

    public static void main(String[] args) {

        BookingHistory history = new BookingHistory();

        history.add(new Reservation("Alice", "Single"));
        history.add(new Reservation("Bob", "Double"));

        history.showHistory();
    }
}

class Reservation {
    String name;
    String roomType;

    Reservation(String name, String roomType) {
        this.name = name;
        this.roomType = roomType;
    }
}

class BookingHistory {

    List<Reservation> list = new ArrayList<>();

    void add(Reservation r) {
        list.add(r);
    }

    void showHistory() {
        System.out.println("Booking History:");

        for (Reservation r : list) {
            System.out.println(r.name + " -> " + r.roomType);
        }
    }
}