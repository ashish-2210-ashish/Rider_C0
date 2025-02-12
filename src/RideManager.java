import java.util.*;

public class RideManager {
    Map<String, Ride> rides = new HashMap<>();

    private double calculateDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public void matchRider(String riderId, DriverManager driverManager, RiderManager riderManager) {
        if (!riderManager.riders.containsKey(riderId)) return;
        Rider rider = riderManager.riders.get(riderId);

        List<Driver> nearbyDrivers = new ArrayList<>();
        for (Driver driver : driverManager.drivers.values()) {
            if (driver.available && calculateDistance(rider.x, rider.y, driver.x, driver.y) <= 5) {
                nearbyDrivers.add(driver);
            }
        }

        if (nearbyDrivers.isEmpty()) {
            System.out.println("NO_DRIVERS_AVAILABLE");
            return;
        }

        nearbyDrivers.sort(Comparator.comparingDouble((Driver d) -> calculateDistance(rider.x, rider.y, d.x, d.y))
                .thenComparing(d -> d.driverId));

        System.out.print("DRIVERS_MATCHED");
        for (int i = 0; i < Math.min(5, nearbyDrivers.size()); i++) {
            System.out.print(" " + nearbyDrivers.get(i).driverId);
        }
        System.out.println();
    }

    public void startRide(String rideId, int n, String riderId, DriverManager driverManager, RiderManager riderManager) {
        if (!riderManager.riders.containsKey(riderId) || riderManager.riders.get(riderId).hasActiveRide) {
            System.out.println("INVALID_RIDE");
            return;
        }

        List<Driver> availableDrivers = new ArrayList<>();
        for (Driver driver : driverManager.drivers.values()) {
            if (driver.available && calculateDistance(riderManager.riders.get(riderId).x, riderManager.riders.get(riderId).y, driver.x, driver.y) <= 5) {
                availableDrivers.add(driver);
            }
        }

        availableDrivers.sort(Comparator.comparingDouble((Driver d) -> calculateDistance(riderManager.riders.get(riderId).x, riderManager.riders.get(riderId).y, d.x, d.y))
                .thenComparing(d -> d.driverId));

        if (n > availableDrivers.size() || rides.containsKey(rideId)) {
            System.out.println("INVALID_RIDE");
            return;
        }

        Driver chosenDriver = availableDrivers.get(n - 1);
        rides.put(rideId, new Ride(rideId, riderManager.riders.get(riderId), chosenDriver));
        System.out.println("RIDE_STARTED " + rideId);
    }

    public void stopRide(String rideId, int destX, int destY, int time) {
        if (!rides.containsKey(rideId) || !rides.get(rideId).active) {
            System.out.println("INVALID_RIDE");
            return;
        }

        Ride ride = rides.get(rideId);
        ride.active = false;
        ride.driver.available = true;
        ride.rider.hasActiveRide = false;

        System.out.println("RIDE_STOPPED " + rideId);
    }
}
