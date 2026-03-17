import java.io.*;
import java.util.*;

/**
 * UC12: Persistence
 */
public class BookMyStayApp {

    public static void main(String[] args) {

        List<String> data = Arrays.asList("Booking1", "Booking2");

        try {
            // Save
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream("data.ser"));
            out.writeObject(data);
            out.close();

            // Load
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream("data.ser"));
            List<String> loaded = (List<String>) in.readObject();
            in.close();

            System.out.println("Recovered Data: " + loaded);

        } catch (Exception e) {
            System.out.println("Error in persistence");
        }
    }
}