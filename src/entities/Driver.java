package entities;

public class Driver {
    private String id;
    private int x, y;
    private boolean available;

    public Driver(String id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.available = true;
    }

    public String getId() { return id; }
    public int getX() { return x; }
    public int getY() { return y; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    public double distanceTo(int riderX, int riderY) {
        return Math.sqrt(Math.pow(this.x - riderX, 2) + Math.pow(this.y - riderY, 2));
    }
}
