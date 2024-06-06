package assessment.parkinglot.domain.vehicle;

import assessment.parkinglot.domain.spot.Spot;
import assessment.parkinglot.frameworks.database.vehicle.VehicleEntity;
import assessment.parkinglot.frameworks.database.vehicle.VehicleType;
import java.util.List;
import java.util.UUID;

public class Van extends Vehicle {

    public Van(UUID id) {
        super(id);
    }

    @Override
    public List<Spot> calculateParkingSpots(List<Spot> spots) {
        List<Spot> candidates = spots.stream().filter(spot -> spot.isAvailable() && spot.canPark(this)).limit(3).toList();
        return candidates.size() >= 3 ? candidates : List.of();
    }

    @Override
    public VehicleEntity asEntity() {
        return VehicleEntity.builder()
                .id(id)
                .type(VehicleType.MOTORCYCLE)
                .build();
    }
}
