package assessment.parkinglot.domain.spot;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@AllArgsConstructor
public abstract class ParkingSpot implements Spot {
    private final Integer id;
    private Boolean available;

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public void occupy() {
        this.available = false;
    }

    @Override
    public void liberate() {
        this.available = true;
    }
}
