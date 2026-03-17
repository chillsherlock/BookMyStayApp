import java.util.*;

/**
 * UC7: Add-On Services
 * @version 7.0
 */
public class BookMyStayApp {

    public static void main(String[] args) {

        String reservationId = "R1";

        AddOnService wifi = new AddOnService("WiFi", 200);
        AddOnService breakfast = new AddOnService("Breakfast", 300);

        AddOnServiceManager manager = new AddOnServiceManager();

        manager.addService(reservationId, wifi);
        manager.addService(reservationId, breakfast);

        manager.displayServices(reservationId);
    }
}

// Service
class AddOnService {
    String name;
    int cost;

    AddOnService(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }
}

// Manager
class AddOnServiceManager {

    Map<String, List<AddOnService>> map = new HashMap<>();

    void addService(String reservationId, AddOnService service) {
        map.putIfAbsent(reservationId, new ArrayList<>());
        map.get(reservationId).add(service);
    }

    void displayServices(String reservationId) {
        int total = 0;

        System.out.println("Services for " + reservationId);

        for (AddOnService s : map.get(reservationId)) {
            System.out.println(s.name + " - " + s.cost);
            total += s.cost;
        }

        System.out.println("Total Add-On Cost: " + total);
    }
}