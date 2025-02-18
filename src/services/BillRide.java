package services;
import entities.Ride;
import java.util.Map;

public class BillRide {
    // Calculates the fare for a completed ride and prints the bill
    public static double execute(Map<String, Ride> rides, String rideId) {
        // Check if the ride exists and is completed
        if (!rides.containsKey(rideId) || !rides.get(rideId).isCompleted()) {
            System.out.println("INVALID_RIDE"); // Error message if ride is invalid
            return -1;
        }

        Ride ride = rides.get(rideId);
        double fare = ride.calculateFare();

        // Print the bill in the format: BILL <rideId> <driverId> <fare>
        System.out.printf("BILL %s %s %.2f%n", ride.getRideId(), ride.getDriver().getId(), fare);

        return fare;
    }
}
