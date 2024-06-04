package assessment.parkinglot.domain;

import assessment.parkinglot.domain.spot.Spot;
import assessment.parkinglot.domain.vehicle.Parkable;
import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    List<Spot> spots;
    public ParkingLot(Spot... spots) {
        this.spots = new ArrayList<>(List.of(spots));
    }

    public List<Spot> park(Parkable parkable) {
        return parkable.park(spots);
    }

    public List<Spot> leave(Parkable parkable) {
       return parkable.leave();
    }

    public Long remainingSpots() {
        return spots.stream().filter(Spot::isAvailable).count();
    }

    public boolean check(Parkable parkable) {
        return parkable.check(spots);
    }
}
