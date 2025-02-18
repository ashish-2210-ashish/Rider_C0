package services;

import entities.Ride;
import java.util.Map;

public class CancelRide {
    // Cancels the ride by removing it from the map
    public static boolean execute(Map<String, Ride> rides, String rideId) {
        // Check if the ride exists before trying to cancel it
        if (!rides.containsKey(rideId)) {
            return false; // Return false if the ride doesn't exist
        }
        rides.remove(rideId); // Remove the ride from the map
        return true; // Return true to indicate the ride was successfully canceled
    }
}
