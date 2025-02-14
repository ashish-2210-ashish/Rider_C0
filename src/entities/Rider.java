package entities;

public class Rider {
    private String id;
    private int x, y;

    public Rider(String id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public String getId() { return id; }
    public int getX() { return x; }
    public int getY() { return y; }
}
