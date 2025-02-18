import entities.*;
import services.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create maps to store drivers, riders, rides, and matched drivers
        Map<String, Driver> drivers = new HashMap<>();
        Map<String, Rider> riders = new HashMap<>();
        Map<String, Ride> rides = new HashMap<>();
        Map<String, List<Driver>> matchedDrivers = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        // Continuously read user input and process commands
        while (scanner.hasNextLine()) {
            String[] input = scanner.nextLine().split(" ");

            // Switch statement to handle different commands based on input
            switch (input[0]) {
                case "ADD_DRIVER":
                    // Add a new driver to the system
                    AddDriver.execute(drivers, input[1], Integer.parseInt(input[2]), Integer.parseInt(input[3]));
                    break;
                case "ADD_RIDER":
                    // Add a new rider to the system
                    AddRider.execute(riders, input[1], Integer.parseInt(input[2]), Integer.parseInt(input[3]));
                    break;
                case "MATCH":
                    // Find and match available drivers for a rider
                    matchedDrivers.put(input[1], MatchRider.execute(drivers, riders.get(input[1])));
                    break;
                case "START_RIDE":
                    // Start a ride with a selected driver and rider
                    StartRide.execute(rides, matchedDrivers, riders, input[1], Integer.parseInt(input[2]), input[3]);
                    break;
                case "STOP_RIDE":
                    // Stop the ride, update its location and time
                    StopRide.execute(rides, input[1], Integer.parseInt(input[2]), Integer.parseInt(input[3]), Integer.parseInt(input[4]));
                    break;
                case "BILL":
                    // Generate the bill for the completed ride
                    BillRide.execute(rides, input[1]);
                    break;
            }
        }
        scanner.close(); // Close the scanner after processing all commands
    }
}
