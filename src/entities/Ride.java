package entities;

public class Ride {
    private String rideId;
    private Rider rider;
    private Driver driver;
    private int startX, startY; // 🔹 Added start location
    private int destinationX, destinationY, timeTaken;
    private boolean isCompleted;

    public Ride(String rideId, Rider rider, Driver driver) {
        this.rideId = rideId;
        this.rider = rider;
        this.driver = driver;
        this.startX = rider.getX(); // 🔹 Initialize start location
        this.startY = rider.getY();
        this.isCompleted = false;
    }
    public double getFare() {
        return calculateFare();
    }


    public String getRideId() { return rideId; }
    public Driver getDriver() { return driver; }
    public boolean isCompleted() { return isCompleted; }

    public int getEndX() { return destinationX; }
    public int getEndY() { return destinationY; }
    public int getTime() { return timeTaken; }

    public void stopRide(int x, int y, int time) {
        this.destinationX = x;  // ✅ Fixed variable names
        this.destinationY = y;
        this.timeTaken = time;
        this.isCompleted = true;  // ✅ Fixed incorrect `completed` variable

        // 🔍 Debugging: Print ride details after stopping
        System.out.println("Ride Stopped: " +
                "\nEnd Location: (" + x + ", " + y + ")" +
                "\nTime Taken: " + time);
    }

    public double calculateDistance() {
        double distance = Math.sqrt(Math.pow(destinationX - startX, 2) + Math.pow(destinationY - startY, 2));

        // 🔍 Debugging: Print distance calculation
        System.out.println("Distance Calculation: " +
                "\nStart: (" + startX + ", " + startY + ")" +
                "\nEnd: (" + destinationX + ", " + destinationY + ")" +
                "\nCalculated Distance: " + distance);

        return distance;
    }

    public double calculateFare() {
        double baseFare = 50;
        double distance = calculateDistance();
        double timeFare = 2 * timeTaken;
        double distanceFare = 6.5 * distance;

        double fare = baseFare + distanceFare + timeFare;
        double totalFare = fare + (fare * 0.2); // Add 20% tax

        // 🔍 Debugging: Print fare details
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
