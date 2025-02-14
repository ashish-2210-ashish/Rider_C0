//No Available Drivers Scenario

package Automated_Test_Cases;

import entities.*;
import services.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class Test2 {
    private Map<String, Driver> drivers;
    private Map<String, Rider> riders;

    @BeforeEach
    void setUp() {
        drivers = new HashMap<>();
        riders = new HashMap<>();


        AddRider.execute(riders, "R1", 2, 3);
    }

    @Test
    void testNoAvailableDrivers() {
        Rider rider = riders.get("R1");
        List<Driver> matched = MatchRider.execute(drivers, rider);

        assertNotNull(matched, "Matched drivers list should not be null");
        assertEquals(0, matched.size(), "No drivers should be available");
    }
}
