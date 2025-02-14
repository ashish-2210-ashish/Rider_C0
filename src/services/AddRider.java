package services;
import entities.Rider;
import java.util.Map;

public class AddRider {
    public static void execute(Map<String, Rider> riders, String id, int x, int y) {
        riders.put(id, new Rider(id, x, y));
    }
}
