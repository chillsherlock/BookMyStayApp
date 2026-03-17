import java.util.*;

/**
 * UC9: Error Handling
 */
public class BookMyStayApp {

    public static void main(String[] args) {

        try {
            validate("InvalidRoom");
        } catch (InvalidBookingException e) {
            System.out.println(e.getMessage());
        }
    }

    static void validate(String roomType) throws InvalidBookingException {
        List<String> valid = Arrays.asList("Single", "Double", "Suite");

        if (!valid.contains(roomType)) {
            throw new InvalidBookingException("Invalid Room Type!");
        }
    }
}

// Custom Exception
class InvalidBookingException extends Exception {
    InvalidBookingException(String msg) {
        super(msg);
    }
}