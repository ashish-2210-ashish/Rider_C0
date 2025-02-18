package services;
import entities.*;
import java.util.*;

public class StartRide {
    // Starts a ride with the selected driver and rider
    public static void execute(Map<String, Ride> rides, Map<String, List<Driver>> matchedDrivers, Map<String, Rider> riders,
                               String rideId, int driverNumber, String riderId) {
        List<Driver> nearbyDrivers = matchedDrivers.get(riderId);

        // Check if the ride details are valid (driver exists, valid driver number, rider exists)
        if (nearbyDrivers == null || driverNumber < 1 || driverNumber > nearbyDrivers.size() || !riders.containsKey(riderId)) {
            System.out.println("INVALID_RIDE"); // Invalid ride details
            return;
        }

        Driver driver = nearbyDrivers.get(driverNumber - 1); // Get the selected driver
        driver.setAvailable(false); // Mark the driver as unavailable
        rides.put(rideId, new Ride(rideId, riders.get(riderId), driver)); // Start the ride and add it to the map

        System.out.println("RIDE_STARTED " + rideId); // Notify that the ride has started
    }
}
