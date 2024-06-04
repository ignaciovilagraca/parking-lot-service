package assessment.parkinglot.domain.vehicle;

import assessment.parkinglot.domain.spot.Spot;
import java.util.ArrayList;
import java.util.List;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public abstract class Vehicle implements Parkable {
    private final Integer id;
    private final List<Spot> parkingSpots =  new ArrayList<>();

    public Vehicle(Integer id) {
        this.id = id;
    }

    @Override
    public List<Spot> park(List<Spot> availableSpots, List<Spot> usedSpots) {
        List<Spot> spotsToUse = calculateParkingSpots(availableSpots);
        if (!spotsToUse.isEmpty()) {
            spotsToUse.forEach(spot -> spot.occupy(this));
            parkingSpots.addAll(spotsToUse);
            usedSpots.addAll(spotsToUse);
            availableSpots.removeAll(spotsToUse);
        }
        return spotsToUse;
    }

    @Override
    public List<Spot> leave(List<Spot> availableSpots, List<Spot> usedSpots) {
        parkingSpots.forEach(Spot::liberate);
        availableSpots.addAll(parkingSpots);
        usedSpots.removeAll(parkingSpots);
        return parkingSpots;
    }

    @Override
    public boolean check(List<Spot> spots) {
        return !calculateParkingSpots(spots).isEmpty();
    }
}
