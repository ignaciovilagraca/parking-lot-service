package assessment.parkinglot.domain.spot;

import assessment.parkinglot.domain.vehicle.Car;
import assessment.parkinglot.domain.vehicle.Motorcycle;
import assessment.parkinglot.domain.vehicle.Van;
import assessment.parkinglot.domain.vehicle.Vehicle;
import assessment.parkinglot.frameworks.database.spot.ParkingSpotEntity;
import assessment.parkinglot.frameworks.web.spot.SpotDto;
import java.util.UUID;

public interface Spot {
    boolean canPark(Car car);
    boolean canPark(Motorcycle motorcycle);
    boolean canPark(Van van);

    boolean isAvailable();

    void occupy(Vehicle vehicle);

    Spot liberate();

    SpotDto asDto();

    ParkingSpotEntity asEntity();

    boolean containsVehicle(UUID id);
}
