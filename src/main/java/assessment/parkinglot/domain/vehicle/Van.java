package assessment.parkinglot.domain.vehicle;

import assessment.parkinglot.domain.spot.Spot;
import java.util.List;

public class Van extends Vehicle {

    public Van(Integer id) {
        super(id);
    }

    @Override
    public List<Spot> calculateParkingSpots(List<Spot> spots) {
        List<Spot> candidates = spots.stream().filter(spot -> spot.isAvailable() && spot.canPark(this)).limit(3).toList();
        return candidates.size() >= 3 ? candidates : List.of();
    }
}
