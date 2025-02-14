package services;

import entities.Ride;
import java.util.Map;

public class CancelRide {
    public static boolean execute(Map<String, Ride> rides, String rideId) {
        if (!rides.containsKey(rideId)) {
            return false; // Ride does not exist, so it cannot be canceled.
        }
        rides.remove(rideId); // Remove the ride
        return true; // Ride successfully canceled
    }
}
