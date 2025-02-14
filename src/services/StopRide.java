package services;

import entities.Ride;
import java.util.Map;

public class StopRide {
    public static boolean execute(Map<String, Ride> rides, String rideId, int x, int y, int time) {
        if (!rides.containsKey(rideId)) {
            return false;
        }
        rides.get(rideId).stopRide(x, y, time);
        return true;
    }
}
