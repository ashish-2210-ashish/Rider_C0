public class Ride {
    String rideId;
    Rider rider;
    Driver driver;
    boolean active;

    public Ride(String rideId, Rider rider, Driver driver) {
        this.rideId = rideId;
        this.rider = rider;
        this.driver = driver;
        this.active = true;
        driver.available = false;
        rider.hasActiveRide = true;
    }
}
