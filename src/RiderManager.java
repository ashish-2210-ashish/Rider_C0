import java.util.HashMap;
import java.util.Map;

public class RiderManager {
    Map<String, Rider> riders = new HashMap<>();

    public void addRider(String id, int x, int y) {
        riders.put(id, new Rider(id, x, y));
    }
}
