public class Rider {
    String riderId;
    int x, y;
    boolean hasActiveRide;

    public Rider(String riderId, int x, int y) {
        this.riderId = riderId;
        this.x = x;
        this.y = y;
        this.hasActiveRide = false;
    }
}
