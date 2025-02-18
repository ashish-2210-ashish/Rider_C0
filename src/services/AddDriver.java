package services;
import entities.Driver;
import java.util.Map;

public class AddDriver {
    // Adds a new driver to the drivers map with the given ID and location
    public static void execute(Map<String, Driver> drivers, String id, int x, int y) {
        drivers.put(id, new Driver(id, x, y));
    }
}
