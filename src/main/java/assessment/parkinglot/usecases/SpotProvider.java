package assessment.parkinglot.usecases;

import assessment.parkinglot.domain.spot.Spot;
import java.util.List;

public interface SpotProvider {
    List<Spot> getAvailableSpots();

    List<Spot> getUsedSpots();

    List<Spot> save(List<Spot> spots);
}
