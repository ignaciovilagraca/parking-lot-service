package assessment.parkinglot.domain.vehicle;

import assessment.parkinglot.domain.spot.Spot;
import java.util.List;
import java.util.UUID;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public abstract class Vehicle implements Parkable {
    protected final UUID id;

    public Vehicle(UUID id) {
        this.id = id;
    }

    @Override
    public List<Spot> park(List<Spot> availableSpots, List<Spot> usedSpots) {
        List<Spot> spotsToUse = calculateParkingSpots(availableSpots);
        if (!spotsToUse.isEmpty()) {
            spotsToUse.forEach(spot -> spot.occupy(this));
        }
        return spotsToUse;
    }

    @Override
    public List<Spot> leave(List<Spot> usedSpots) {
        return usedSpots.stream()
                .filter(spot -> spot.containsVehicle(this.id))
                .map(Spot::liberate)
                .toList();
    }

    @Override
    public boolean check(List<Spot> spots) {
        return !calculateParkingSpots(spots).isEmpty();
    }
}
