package services;
import entities.*;
import java.util.*;

public class StartRide {
    public static void execute(Map<String, Ride> rides, Map<String, List<Driver>> matchedDrivers, Map<String, Rider> riders,
                               String rideId, int driverNumber, String riderId) {
        List<Driver> nearbyDrivers = matchedDrivers.get(riderId);

        if (nearbyDrivers == null || driverNumber < 1 || driverNumber > nearbyDrivers.size() || !riders.containsKey(riderId)) {
            System.out.println("INVALID_RIDE");
            return;
        }

        Driver driver = nearbyDrivers.get(driverNumber - 1);
        driver.setAvailable(false);
        rides.put(rideId, new Ride(rideId, riders.get(riderId), driver));

        System.out.println("RIDE_STARTED " + rideId);
    }
}
