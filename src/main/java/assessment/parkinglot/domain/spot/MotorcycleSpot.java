package assessment.parkinglot.domain.spot;

import assessment.parkinglot.domain.vehicle.Car;
import assessment.parkinglot.domain.vehicle.Motorcycle;
import assessment.parkinglot.domain.vehicle.Van;
import assessment.parkinglot.domain.vehicle.Vehicle;
import assessment.parkinglot.frameworks.database.spot.ParkingSpotEntity;
import assessment.parkinglot.frameworks.database.spot.ParkingSpotType;
import java.util.UUID;

public class MotorcycleSpot extends ParkingSpot {

    public MotorcycleSpot(UUID id, Vehicle vehicle) {
        super(id, vehicle);
    }

    @Override
    public boolean canPark(Car car) {
        return false;
    }

    @Override
    public boolean canPark(Motorcycle motorcycle) {
        return true;
    }

    @Override
    public boolean canPark(Van van) {
        return false;
    }

    @Override
    public ParkingSpotEntity asEntity() {
        return ParkingSpotEntity.builder()
                .id(id)
                .type(ParkingSpotType.MOTORCYCLE)
                .vehicle(
                        vehicle != null ? vehicle.asEntity() : null
                )
                .build();
    }
}
