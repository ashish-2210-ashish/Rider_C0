package services;
import entities.Driver;
import entities.Rider;
import java.util.*;

public class MatchRider {
    // Matches a rider with available drivers within 5 units of distance
    public static List<Driver> execute(Map<String, Driver> drivers, Rider rider) {
        List<Driver> nearbyDrivers = new ArrayList<>();

        // Loop through all drivers and find those within 5 units and available
        for (Driver driver : drivers.values()) {
            if (driver.isAvailable() && driver.distanceTo(rider.getX(), rider.getY()) <= 5) {
                nearbyDrivers.add(driver);
            }
        }

        // If no drivers are found within the criteria, print a message and return an empty list
        if (nearbyDrivers.isEmpty()) {
            System.out.println("NO_DRIVERS_AVAILABLE");
            return new ArrayList<>();
        }

        // Sort the drivers by their distance to the rider, closest first
        nearbyDrivers.sort(Comparator.comparingDouble(d -> d.distanceTo(rider.getX(), rider.getY())));

        // Print the IDs of the top 5 matched drivers
        System.out.print("DRIVERS_MATCHED");
        for (int i = 0; i < Math.min(5, nearbyDrivers.size()); i++) {
            System.out.print(" " + nearbyDrivers.get(i).getId());
        }
        System.out.println();

        // Return the top 5 closest drivers (or fewer if less than 5 are available)
        return nearbyDrivers.subList(0, Math.min(5, nearbyDrivers.size()));
    }
}
