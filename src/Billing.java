public class Billing {
    public static void generateBill(String rideId, RideManager rideManager) {
        if (!rideManager.rides.containsKey(rideId) || rideManager.rides.get(rideId).active) {
            System.out.println("INVALID_RIDE");
            return;
        }

        Ride ride = rideManager.rides.get(rideId);
        double distance = Math.sqrt(Math.pow(ride.rider.x - ride.driver.x, 2) + Math.pow(ride.rider.y - ride.driver.y, 2));
        double amount = 50 + (6.5 * distance) + (2 * distance);
        amount += 0.2 * amount;

        System.out.printf("BILL %s %s %.2f%n", rideId, ride.driver.driverId, amount);
    }
}
