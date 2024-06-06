package assessment.parkinglot.usecases;

import assessment.parkinglot.domain.spot.Spot;
import assessment.parkinglot.domain.vehicle.Parkable;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ParkingLot {

    private final SpotProvider spotProvider;
    private final ParkableProvider parkableProvider;

    public ParkingLot(SpotProvider spotProvider, ParkableProvider parkableProvider) {
        this.spotProvider = spotProvider;
        this.parkableProvider = parkableProvider;
    }

    public List<Spot> park(Parkable parkable) {
        parkableProvider.create(parkable);
        List<Spot> spots = parkable.park(spotProvider.getAvailableSpots(), spotProvider.getUsedSpots());
        return spotProvider.save(spots);
    }

    public List<Spot> leave(Parkable parkable) {
        List<Spot> spots = parkable.leave(spotProvider.getUsedSpots());
        return spotProvider.save(spots);
    }

    public Integer remainingSpots() {
        return spotProvider.getAvailableSpots().size();
    }

    public Boolean check(Parkable parkable) {
        return parkable.check(spotProvider.getAvailableSpots());
    }
}
