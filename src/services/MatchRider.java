package services;
import entities.Driver;
import entities.Rider;
import java.util.*;

public class MatchRider {
    public static List<Driver> execute(Map<String, Driver> drivers, Rider rider) {
        List<Driver> nearbyDrivers = new ArrayList<>();
        for (Driver driver : drivers.values()) {
            if (driver.isAvailable() && driver.distanceTo(rider.getX(), rider.getY()) <= 5) {
                nearbyDrivers.add(driver);
            }
        }

        if (nearbyDrivers.isEmpty()) {
            System.out.println("NO_DRIVERS_AVAILABLE");
            return new ArrayList<>();  // Return an empty list instead of null
        }

        // Sort by distance
        nearbyDrivers.sort(Comparator.comparingDouble(d -> d.distanceTo(rider.getX(), rider.getY())));

        // Print matched drivers
        System.out.print("DRIVERS_MATCHED");
        for (int i = 0; i < Math.min(5, nearbyDrivers.size()); i++) {
            System.out.print(" " + nearbyDrivers.get(i).getId());
        }
        System.out.println();

        return nearbyDrivers.subList(0, Math.min(5, nearbyDrivers.size()));  // Return the top 5 drivers
    }
}
