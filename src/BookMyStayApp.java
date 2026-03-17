import java.util.*;

/**
 * UC10: Cancellation
 */
public class BookMyStayApp {

    public static void main(String[] args) {

        CancellationService service = new CancellationService();

        service.book("Single-1");
        service.cancel();
    }
}

class CancellationService {

    Stack<String> stack = new Stack<>();

    void book(String roomId) {
        stack.push(roomId);
        System.out.println("Booked: " + roomId);
    }

    void cancel() {
        if (!stack.isEmpty()) {
            System.out.println("Cancelled: " + stack.pop());
        }
    }
}