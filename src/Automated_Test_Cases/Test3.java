//Multiple Riders Requesting Ride

package Automated_Test_Cases;

import entities.*;
import services.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class Test3 {
    private Map<String, Driver> drivers;
    private Map<String, Rider> riders;
    private Map<String, List<Driver>> matchedDrivers;

    @BeforeEach
    void setUp() {
        drivers = new HashMap<>();
        riders = new HashMap<>();
        matchedDrivers = new HashMap<>();


        AddDriver.execute(drivers, "D1", 3, 4);
        AddDriver.execute(drivers, "D2", 1, 2);
        AddDriver.execute(drivers, "D3", 5, 6);


        AddRider.execute(riders, "R1", 2, 3);
        AddRider.execute(riders, "R2", 4, 5);
        AddRider.execute(riders, "R3", 1, 1);
    }

    @Test
    void testMultipleRidersRequestRides() {
        for (String riderId : riders.keySet()) {
            List<Driver> matched = MatchRider.execute(drivers, riders.get(riderId));
            assertNotNull(matched, "Matched drivers list should not be null");
            assertFalse(matched.isEmpty(), "Each rider should have at least one driver available");
            matchedDrivers.put(riderId, matched);
        }

        assertEquals(3, matchedDrivers.size(), "All three riders should have matched drivers");
    }
}
