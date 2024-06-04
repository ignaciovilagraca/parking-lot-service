package assessment.parkinglot;

import assessment.parkinglot.domain.ParkingLot;
import assessment.parkinglot.domain.spot.CompactCarSpot;
import assessment.parkinglot.domain.spot.MotorcycleSpot;
import assessment.parkinglot.domain.spot.RegularSpot;
import assessment.parkinglot.domain.vehicle.Car;
import assessment.parkinglot.domain.vehicle.Motorcycle;
import assessment.parkinglot.domain.vehicle.Van;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ParkingLotServiceTest {

    private ParkingLot parkingLot;

    @BeforeEach
    void setUp() {
        //TODO I reduced the amount of spots to make testing edge cases easier
        parkingLot = new ParkingLot(
                new MotorcycleSpot(1, true),
                new CompactCarSpot(1, true),
                new RegularSpot(1, true), new RegularSpot(2, true), new RegularSpot(3, true)
        );
    }

    @Test
    void parkMotorcycle() {
        assertEquals(List.of(new MotorcycleSpot(1, false)), parkingLot.park(new Motorcycle(1)));
        assertEquals(List.of(), parkingLot.park(new Motorcycle(2)));
    }

    @Test
    void parkCar() {
        assertEquals(List.of(new CompactCarSpot(1, false)), parkingLot.park(new Car(1)));
        assertEquals(List.of(new RegularSpot(1, false)), parkingLot.park(new Car(2)));
        assertEquals(List.of(new RegularSpot(2, false)), parkingLot.park(new Car(3)));
        assertEquals(List.of(new RegularSpot(3, false)), parkingLot.park(new Car(4)));
        assertEquals(List.of(), parkingLot.park(new Car(5)));
    }

    @Test
    void parkVan() {
        assertEquals(List.of(new RegularSpot(1, false), new RegularSpot(2, false), new RegularSpot(3, false)), parkingLot.park(new Van(1)));
        assertEquals(List.of(), parkingLot.park(new Van(2)));
    }

    @Test
    void motorcycleLeavesParkingLot() {
        Motorcycle motorcycle = new Motorcycle(1);
        assertEquals(List.of(new MotorcycleSpot(1, false)), parkingLot.park(motorcycle));
        assertEquals(List.of(new MotorcycleSpot(1, true)), parkingLot.leave(motorcycle));
    }

    @Test
    void carLeavesParkingLot() {
        Car car = new Car(1);
        assertEquals(List.of(new CompactCarSpot(1, false)), parkingLot.park(car));
        assertEquals(List.of(new CompactCarSpot(1, true)), parkingLot.leave(car));
    }

    @Test
    void vanLeavesParkingLot() {
        Van van = new Van(1);
        assertEquals(List.of(new RegularSpot(1, false), new RegularSpot(2, false), new RegularSpot(3, false)), parkingLot.park(van));
        assertEquals(List.of(new RegularSpot(1, true), new RegularSpot(2, true), new RegularSpot(3, true)), parkingLot.leave(van));
    }

    @Test
    void returnRemainingSpots() {
        assertEquals(5, parkingLot.remainingSpots());
        parkingLot.park(new Motorcycle(1));
        assertEquals(4, parkingLot.remainingSpots());
    }

    @Test
    void isThereSpaceForGivenType() {
        Motorcycle motorcycle = new Motorcycle(1);
        Car car = new Car(1);
        Van van = new Van(1);
        assertTrue(parkingLot.check(motorcycle));
        assertTrue(parkingLot.check(car));
        assertTrue(parkingLot.check(van));
    }
}
