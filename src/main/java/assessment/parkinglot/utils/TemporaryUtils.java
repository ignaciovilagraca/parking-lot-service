package assessment.parkinglot.utils;

import assessment.parkinglot.domain.spot.CompactCarSpot;
import assessment.parkinglot.domain.spot.MotorcycleSpot;
import assessment.parkinglot.domain.spot.RegularSpot;
import assessment.parkinglot.domain.spot.Spot;
import java.util.ArrayList;
import java.util.List;

public class TemporaryUtils {
    public static List<Spot> initSpots() {
        //TODO I reduced the amount of spots to make testing edge cases easier
        //TODO Move this to a database
        return new ArrayList<>(List.of(new MotorcycleSpot(1),
                new CompactCarSpot(1),
                new RegularSpot(1), new RegularSpot(2), new RegularSpot(3)));
    }
}
