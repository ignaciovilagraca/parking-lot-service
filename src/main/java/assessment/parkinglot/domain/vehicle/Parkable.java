package assessment.parkinglot.domain.vehicle;

import assessment.parkinglot.domain.spot.Spot;
import java.util.List;

public interface Parkable {

    List<Spot> park(List<Spot> availableSpots, List<Spot> usedSpots);

    List<Spot> leave(List<Spot> availableSpots, List<Spot> usedSpots);

    boolean check(List<Spot> spots);

    List<Spot> calculateParkingSpots(List<Spot> spots);
}
