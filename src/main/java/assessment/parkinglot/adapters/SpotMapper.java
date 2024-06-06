package assessment.parkinglot.adapters;

import assessment.parkinglot.domain.spot.CompactCarSpot;
import assessment.parkinglot.domain.spot.MotorcycleSpot;
import assessment.parkinglot.domain.spot.RegularSpot;
import assessment.parkinglot.domain.spot.Spot;
import assessment.parkinglot.frameworks.database.spot.ParkingSpotEntity;
import assessment.parkinglot.frameworks.exceptions.InvalidSpotTypeException;
import org.springframework.stereotype.Component;

@Component
public class SpotMapper {

    private final VehicleMapper vehicleMapper;

    public SpotMapper(VehicleMapper vehicleMapper) {
        this.vehicleMapper = vehicleMapper;
    }

    public Spot map(ParkingSpotEntity entity) {
        Spot spot;
        switch (entity.getType()) {
            case MOTORCYCLE -> spot = new MotorcycleSpot(entity.getId(), vehicleMapper.map(entity.getVehicle()));
            case COMPACT -> spot = new CompactCarSpot(entity.getId(), vehicleMapper.map(entity.getVehicle()));
            case REGULAR -> spot = new RegularSpot(entity.getId(), vehicleMapper.map(entity.getVehicle()));
            default -> throw new InvalidSpotTypeException("The spot type is invalid");
        }
        return spot;
    }

    public ParkingSpotEntity map(Spot spot) {
        return spot.asEntity();
    }
}
