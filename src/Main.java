import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DriverManager driverManager = new DriverManager();
        RiderManager riderManager = new RiderManager();
        RideManager rideManager = new RideManager();

        while (scanner.hasNext()) {
            String[] input = scanner.nextLine().split(" ");
            switch (input[0]) {
                case "ADD_DRIVER":
                    driverManager.addDriver(input[1], Integer.parseInt(input[2]), Integer.parseInt(input[3]));
                    break;
                case "ADD_RIDER":
                    riderManager.addRider(input[1], Integer.parseInt(input[2]), Integer.parseInt(input[3]));
                    break;
                case "MATCH":
                    rideManager.matchRider(input[1], driverManager, riderManager);
                    break;
                case "START":
                    rideManager.startRide(input[1], Integer.parseInt(input[2]), input[3], driverManager, riderManager);
                    break;
                case "STOP":
                    rideManager.stopRide(input[1], Integer.parseInt(input[2]), Integer.parseInt(input[3]), Integer.parseInt(input[4]));
                    break;
                case "BILL":
                    Billing.generateBill(input[1], rideManager);
                    break;
                default:
                    System.out.println("INVALID_COMMAND");
            }
        }
        scanner.close();
    }
}
