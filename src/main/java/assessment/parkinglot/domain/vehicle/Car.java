package assessment.parkinglot.domain.vehicle;

import assessment.parkinglot.domain.spot.Spot;
import assessment.parkinglot.frameworks.database.vehicle.VehicleEntity;
import assessment.parkinglot.frameworks.database.vehicle.VehicleType;
import java.util.List;
import java.util.UUID;

public class Car extends Vehicle {

    public Car(UUID id) {
        super(id);
    }

    @Override
    public List<Spot> calculateParkingSpots(List<Spot> spots) {
        return spots.stream().filter(spot -> spot.isAvailable() && spot.canPark(this)).limit(1).toList();
    }

    @Override
    public VehicleEntity asEntity() {
        return VehicleEntity.builder()
                .id(id)
                .type(VehicleType.CAR)
                .build();
    }
}
