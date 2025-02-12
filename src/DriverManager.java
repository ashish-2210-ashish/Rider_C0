import java.util.HashMap;
import java.util.Map;

public class DriverManager {
    Map<String, Driver> drivers = new HashMap<>();

    public void addDriver(String id, int x, int y) {
        drivers.put(id, new Driver(id, x, y));
    }
}
