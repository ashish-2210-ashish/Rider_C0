package Automated_Test_Cases;

import entities.*;
import services.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class Test1 {
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
        AddDriver.execute(drivers, "D4", 2, 1);
        AddDriver.execute(drivers, "D5", 8, 8);

        // Add rider
        AddRider.execute(riders, "R1", 2, 3);
    }

    @Test
    void testMatchRider() {
        Rider rider = riders.get("R1");
        List<Driver> matched = MatchRider.execute(drivers, rider);

        assertNotNull(matched, "Matched drivers list should not be null");
        assertEquals(4, matched.size(), "There should be 4 matched drivers");
        assertEquals("D1", matched.get(0).getId(), "Closest driver should be D1");
        assertEquals("D2", matched.get(1).getId(), "Second closest driver should be D2");
        assertEquals("D4", matched.get(2).getId(), "Third closest driver should be D4");
        assertEquals("D3", matched.get(3).getId(), "Fourth closest driver should be D3");

        matchedDrivers.put("R1", matched);
    }

    @Test
    void testStartRide() {
        testMatchRider(); // Ensure riders are matched first

        StartRide.execute(rides, matchedDrivers, riders, "RIDE1", 1, "R1");

        assertTrue(rides.containsKey("RIDE1"), "Ride should be started");
        assertEquals("D1", rides.get("RIDE1").getDriver().getId(), "Ride should be assigned to D1");
    }

    @Test
    void testStopRide() {
        testStartRide(); // Ensure ride is started

        StopRide.execute(rides, "RIDE1", 10, 10, 15);

        Ride ride = rides.get("RIDE1");
        assertEquals(10, ride.getEndX(), "End X coordinate should be 10");
        assertEquals(10, ride.getEndY(), "End Y coordinate should be 10");
        assertEquals(15, ride.getTime(), "Time taken should be 15 minutes");
    }

    @Test
    void testBillRide() {
        testStopRide(); // Ensure ride is stopped

        double billAmount = BillRide.execute(rides, "RIDE1");

        assertEquals(178.92, billAmount, 0.1, "Bill should be 178.92");
    }

}
