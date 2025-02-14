import entities.*;
import services.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Driver> drivers = new HashMap<>();
        Map<String, Rider> riders = new HashMap<>();
        Map<String, Ride> rides = new HashMap<>();
        Map<String, List<Driver>> matchedDrivers = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String[] input = scanner.nextLine().split(" ");
            switch (input[0]) {
                case "ADD_DRIVER":
                    AddDriver.execute(drivers, input[1], Integer.parseInt(input[2]), Integer.parseInt(input[3]));
                    break;
                case "ADD_RIDER":
                    AddRider.execute(riders, input[1], Integer.parseInt(input[2]), Integer.parseInt(input[3]));
                    break;
                case "MATCH":
                    matchedDrivers.put(input[1], MatchRider.execute(drivers, riders.get(input[1])));
                    break;
                case "START_RIDE":
                    StartRide.execute(rides, matchedDrivers, riders, input[1], Integer.parseInt(input[2]), input[3]);
                    break;
                case "STOP_RIDE":
                    StopRide.execute(rides, input[1], Integer.parseInt(input[2]), Integer.parseInt(input[3]), Integer.parseInt(input[4]));
                    break;
                case "BILL":
                    BillRide.execute(rides, input[1]);
                    break;
            }
        }
        scanner.close();
    }
}
