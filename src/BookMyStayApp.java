import java.util.*;

/**
 * UC11: Concurrency
 */
public class BookMyStayApp {

    public static void main(String[] args) {

        BookingService service = new BookingService();

        Runnable task = () -> service.book();

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();
    }
}

class BookingService {

    int rooms = 1;

    synchronized void book() {
        if (rooms > 0) {
            System.out.println(Thread.currentThread().getName() + " booked");
            rooms--;
        } else {
            System.out.println("No rooms left");
        }
    }
}