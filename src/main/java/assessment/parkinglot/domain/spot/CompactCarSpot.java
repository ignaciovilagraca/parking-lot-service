package assessment.parkinglot.domain.spot;

import assessment.parkinglot.domain.vehicle.Car;
import assessment.parkinglot.domain.vehicle.Motorcycle;
import assessment.parkinglot.domain.vehicle.Van;
import assessment.parkinglot.domain.vehicle.Vehicle;
import assessment.parkinglot.frameworks.database.spot.ParkingSpotEntity;
import assessment.parkinglot.frameworks.database.spot.ParkingSpotType;
import java.util.UUID;

public class CompactCarSpot extends ParkingSpot {

    public CompactCarSpot(UUID id, Vehicle vehicle) {
        super(id, vehicle);
    }

    @Override
    public boolean canPark(Car car) {
        return true;
    }

    @Override
    public boolean canPark(Motorcycle motorcycle) {
        return false;
    }

    @Override
    public boolean canPark(Van van) {
        return false;
    }

    @Override
    public ParkingSpotEntity asEntity() {
        return ParkingSpotEntity.builder()
                .id(id)
                .type(ParkingSpotType.COMPACT)
                .vehicle(
                        vehicle != null ? vehicle.asEntity() : null
                )
                .build();
    }
}
