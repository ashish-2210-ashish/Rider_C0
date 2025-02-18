package services;

import entities.Ride;
import java.util.Map;

public class StopRide {
    // Stops the ride, updates its details with the end location and time
    public static boolean execute(Map<String, Ride> rides, String rideId, int x, int y, int time) {
        // Check if the ride exists in the map
        if (!rides.containsKey(rideId)) {
            return false; // Return false if the ride doesn't exist
        }
        // Stop the ride and update the end location and time
        rides.get(rideId).stopRide(x, y, time);
        return true; // Return true to indicate the ride was successfully stopped
    }
}
