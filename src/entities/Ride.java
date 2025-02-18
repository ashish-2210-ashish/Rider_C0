package entities;

public class Ride {
    private String rideId; // Unique ID for the ride
    private Rider rider; // The rider who booked the ride
    private Driver driver; // The driver assigned to the ride
    private int startX, startY; // Starting coordinates of the ride
    private int destinationX, destinationY, timeTaken; // Destination and time taken for ride completion
    private boolean isCompleted; // Tracks whether the ride is finished

    // Constructor initializes a ride with the given rider and driver
    public Ride(String rideId, Rider rider, Driver driver) {
        this.rideId = rideId;
        this.rider = rider;
        this.driver = driver;
        this.startX = rider.getX();
        this.startY = rider.getY();
        this.isCompleted = false; // Ride starts as incomplete
    }

    // Getter methods for ride details
    public String getRideId() { return rideId; }
    public Driver getDriver() { return driver; }
    public boolean isCompleted() { return isCompleted; }

    public int getEndX() { return destinationX; }
    public int getEndY() { return destinationY; }
    public int getTime() { return timeTaken; }

    // Stops the ride and records final details
    public void stopRide(int x, int y, int time) {
        this.destinationX = x;
        this.destinationY = y;
        this.timeTaken = time;
        this.isCompleted = true;

        // Log ride completion details
        System.out.println("Ride Stopped: " +
                "\nEnd Location: (" + x + ", " + y + ")" +
                "\nTime Taken: " + time);
    }

    // Calculates distance traveled using the Euclidean formula
    public double calculateDistance() {
        double distance = Math.sqrt(Math.pow(destinationX - startX, 2) + Math.pow(destinationY - startY, 2));

        // Debugging: Print distance calculation details
        System.out.println("Distance Calculation: " +
                "\nStart: (" + startX + ", " + startY + ")" +
                "\nEnd: (" + destinationX + ", " + destinationY + ")" +
                "\nCalculated Distance: " + distance);

        return distance;
    }

    // Calculates fare based on distance, time, and a base fare
    public double calculateFare() {
        double baseFare = 50;
        double distance = calculateDistance();
        double timeFare = 2 * timeTaken; // Fare per unit of time
        double distanceFare = 6.5 * distance; // Fare per unit of distance

        double fare = baseFare + distanceFare + timeFare;
        double totalFare = fare + (fare * 0.2); // Adding 20% service charge

        // Debugging: Print fare breakdown
        System.out.println("Fare Calculation: " +
                "\nDistance: " + distance +
                "\nTime Taken: " + timeTaken +
                "\nBase Fare: 50" +
                "\nDistance Fare: " + distanceFare +
                "\nTime Fare: " + timeFare +
                "\nTotal Fare: " + totalFare);

        return totalFare;
    }
}
