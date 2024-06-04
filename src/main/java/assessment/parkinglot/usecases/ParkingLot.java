package assessment.parkinglot.usecases;

import assessment.parkinglot.domain.spot.Spot;
import assessment.parkinglot.domain.vehicle.Parkable;
import assessment.parkinglot.utils.TemporaryUtils;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ParkingLot {
    private final List<Spot> availableSpots = TemporaryUtils.initSpots();
    private final List<Spot> usedSpots = new ArrayList<>();

    public List<Spot> park(Parkable parkable) {
        return parkable.park(availableSpots, usedSpots);
    }

    public List<Spot> leave(Parkable parkable) {
       return parkable.leave(availableSpots, usedSpots);
    }

    public Integer remainingSpots() {
        return availableSpots.size();
    }

    public boolean check(Parkable parkable) {
        return parkable.check(availableSpots);
    }
}
