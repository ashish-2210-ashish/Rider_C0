package entities;

public class Rider {
    private String id; // Unique ID for the rider
    private int x, y; // Rider's current location (coordinates)

    // Constructor to initialize rider details
    public Rider(String id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; } // Returns the rider's X coordinate
    public int getY() { return y; } // Returns the rider's Y coordinate
}
