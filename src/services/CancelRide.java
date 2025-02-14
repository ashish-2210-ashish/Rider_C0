package services;

import entities.Ride;
import java.util.Map;

public class CancelRide {
    public static boolean execute(Map<String, Ride> rides, String rideId) {
        if (!rides.containsKey(rideId)) {
            return false;
        }
        rides.remove(rideId);
        return true;
    }
}
