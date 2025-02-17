//Attempting to Stop a Non-Existent Ride

package Automated_Test_Cases;

import entities.*;
import services.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class Test5 {
    private Map<String, Ride> rides;

    @BeforeEach
    void setUp() {
        rides = new HashMap<>();
    }

    @Test
    void testStopNonExistentRide() {
        boolean result = StopRide.execute(rides, "RIDE1", 10, 10, 15);
        assertFalse(result, "Should not stop a ride that does not exist");
    }
}
