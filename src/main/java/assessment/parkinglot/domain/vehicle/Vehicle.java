package assessment.parkinglot.domain.vehicle;

import assessment.parkinglot.domain.spot.Spot;
import java.util.List;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public abstract class Vehicle implements Parkable {
    private final Integer id;
    private List<Spot> parkingSpots;

    public Vehicle(Integer id) {
        this.id = id;
    }

    @Override
    public List<Spot> park(List<Spot> spots) {
        List<Spot> usedSpots = calculateParkingSpots(spots);
        if (!usedSpots.isEmpty()) {
            usedSpots.forEach(Spot::occupy);
            this.parkingSpots = usedSpots;
        }
        return usedSpots;
    }

    @Override
    public List<Spot> leave() {
        parkingSpots.forEach(Spot::liberate);
        return parkingSpots;
    }

    @Override
    public boolean check(List<Spot> spots) {
        return !calculateParkingSpots(spots).isEmpty();
    }
}
