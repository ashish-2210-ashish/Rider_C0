package entities;

public class Driver {
    private String id;  // Unique ID for the driver
    private int x, y;   // Driver's current location
    private boolean available; // Availability status of the driver

    // Constructor to initialize driver details
    public Driver(String id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.available = true; // By default, driver is available
    }

    public String getId() { return id; } // Returns the driver ID

    public boolean isAvailable() { return available; } // Checks if driver is available
    public void setAvailable(boolean available) { this.available = available; } // Updates availability status

    // Calculates distance from the driver to a rider's location using the Euclidean formula
    public double distanceTo(int riderX, int riderY) {
        return Math.sqrt(Math.pow(this.x - riderX, 2) + Math.pow(this.y - riderY, 2));
    }
}
