package assessment.parkinglot.domain.spot;

import assessment.parkinglot.domain.vehicle.Vehicle;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@AllArgsConstructor
public abstract class ParkingSpot implements Spot {
    private final Integer id;
    private Vehicle vehicle;

    public ParkingSpot(Integer id) {
        this.id = id;
    }

    @Override
    public boolean isAvailable() {
        return vehicle == null;
    }

    @Override
    public void occupy(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void liberate() {
        this.vehicle = null;
    }

    @Override
    public Integer id() {
        return id;
    }
}
