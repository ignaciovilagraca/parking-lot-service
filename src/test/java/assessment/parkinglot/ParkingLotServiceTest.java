package assessment.parkinglot;

import assessment.parkinglot.domain.spot.CompactCarSpot;
import assessment.parkinglot.domain.spot.MotorcycleSpot;
import assessment.parkinglot.domain.spot.RegularSpot;
import assessment.parkinglot.domain.vehicle.Car;
import assessment.parkinglot.domain.vehicle.Motorcycle;
import assessment.parkinglot.domain.vehicle.Van;
import assessment.parkinglot.usecases.ParkingLot;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ParkingLotServiceTest {

    private ParkingLot parkingLot;

    @BeforeEach
    void setUp() {
        parkingLot = new ParkingLot();
    }

    @Test
    void parkMotorcycle() {
        Motorcycle motorcycle = new Motorcycle(1);
        assertEquals(List.of(new MotorcycleSpot(1, motorcycle)), parkingLot.park(motorcycle));
        assertEquals(List.of(), parkingLot.park(new Motorcycle(2)));
    }

    @Test
    void parkCar() {
        Car carOne = new Car(1);
        Car carTwo = new Car(2);
        Car carThree = new Car(3);
        Car carFour = new Car(4);
        assertEquals(List.of(new CompactCarSpot(1, carOne)), parkingLot.park(carOne));
        assertEquals(List.of(new RegularSpot(1, carTwo)), parkingLot.park(carTwo));
        assertEquals(List.of(new RegularSpot(2, carThree)), parkingLot.park(carThree));
        assertEquals(List.of(new RegularSpot(3, carFour)), parkingLot.park(carFour));
        assertEquals(List.of(), parkingLot.park(new Car(5)));
    }

    @Test
    void parkVan() {
        Van van = new Van(1);
        assertEquals(List.of(new RegularSpot(1, van), new RegularSpot(2, van), new RegularSpot(3, van)), parkingLot.park(van));
        assertEquals(List.of(), parkingLot.park(new Van(2)));
    }

    @Test
    void motorcycleLeavesParkingLot() {
        Motorcycle motorcycle = new Motorcycle(1);
        assertEquals(List.of(new MotorcycleSpot(1, motorcycle)), parkingLot.park(motorcycle));
        assertEquals(List.of(new MotorcycleSpot(1)), parkingLot.leave(motorcycle));
    }

    @Test
    void carLeavesParkingLot() {
        Car car = new Car(1);
        assertEquals(List.of(new CompactCarSpot(1, car)), parkingLot.park(car));
        assertEquals(List.of(new CompactCarSpot(1)), parkingLot.leave(car));
    }

    @Test
    void vanLeavesParkingLot() {
        Van van = new Van(1);
        assertEquals(List.of(new RegularSpot(1, van), new RegularSpot(2, van), new RegularSpot(3, van)), parkingLot.park(van));
        assertEquals(List.of(new RegularSpot(1), new RegularSpot(2), new RegularSpot(3)), parkingLot.leave(van));
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
