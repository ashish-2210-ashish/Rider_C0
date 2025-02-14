//Ride Cancellation Before Start

package Automated_Test_Cases;

import entities.*;
import services.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class Test4 {
    private Map<String, Driver> drivers;
    private Map<String, Rider> riders;
    private Map<String, Ride> rides;
    private Map<String, List<Driver>> matchedDrivers;

    @BeforeEach
    void setUp() {
        drivers = new HashMap<>();
        riders = new HashMap<>();
        rides = new HashMap<>();
        matchedDrivers = new HashMap<>();

        // Add drivers
        AddDriver.execute(drivers, "D1", 3, 4);
        AddDriver.execute(drivers, "D2", 1, 2);
        AddDriver.execute(drivers, "D3", 5, 6);

        // Add rider
        AddRider.execute(riders, "R1", 2, 3);
    }

    @Test
    void testCancelRideBeforeStart() {
        Rider rider = riders.get("R1");
        List<Driver> matched = MatchRider.execute(drivers, rider);
        matchedDrivers.put("R1", matched);

        boolean canceled = CancelRide.execute(rides, "RIDE1");
        assertFalse(canceled, "Ride should not be canceled because it hasn't started yet");
    }
}
