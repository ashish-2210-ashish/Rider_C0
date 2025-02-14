package services;
import entities.Ride;
import java.util.Map;

public class BillRide {
    public static double execute(Map<String, Ride> rides, String rideId) {
        if (!rides.containsKey(rideId) || !rides.get(rideId).isCompleted()) {
            System.out.println("INVALID_RIDE");
            return -1; // Indicate invalid ride
        }
        Ride ride = rides.get(rideId);
        double fare = ride.calculateFare();
        System.out.printf("BILL %s %s %.2f%n", ride.getRideId(), ride.getDriver().getId(), fare);
        return fare; // ✅ Now returns fare
    }
}
