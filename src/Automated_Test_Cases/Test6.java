//Invalid Ride Start (Non-Matching Rider ID)

package Automated_Test_Cases;

import entities.*;
import services.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class Test6 {
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

        AddDriver.execute(drivers, "D1", 3, 4);
        AddRider.execute(riders, "R1", 2, 3);
    }

    @Test
    void testInvalidRideStart() {
        List<Driver> matched = MatchRider.execute(drivers, riders.get("R1"));
        matchedDrivers.put("R1", matched);

        StartRide.execute(rides, matchedDrivers, riders, "RIDE1", 1, "R2");

        assertFalse(rides.containsKey("RIDE1"), "Ride should not start with an invalid rider ID");
    }
}
