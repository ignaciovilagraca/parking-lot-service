package assessment.parkinglot.domain.spot;

import assessment.parkinglot.domain.vehicle.Vehicle;
import assessment.parkinglot.frameworks.web.spot.SpotDto;
import java.util.UUID;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class ParkingSpot implements Spot {
    protected final UUID id;
    protected Vehicle vehicle;

    @Override
    public boolean isAvailable() {
        return vehicle == null;
    }

    @Override
    public void occupy(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public ParkingSpot liberate() {
        this.vehicle = null;
        return this;
    }

    @Override
    public SpotDto asDto() {
        return SpotDto.builder()
                .id(this.id)
                .available(vehicle == null)
                .build();
    }

    @Override
    public boolean containsVehicle(UUID id) {
        return this.vehicle != null && this.vehicle.getId().equals(id);
    }
}

