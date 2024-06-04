package assessment.parkinglot.domain.vehicle;

import assessment.parkinglot.domain.spot.Spot;
import java.util.List;

public class Car extends Vehicle {

    public Car(Integer id) {
        super(id);
    }

    @Override
    public List<Spot> calculateParkingSpots(List<Spot> spots) {
        return spots.stream().filter(spot -> spot.isAvailable() && spot.canPark(this)).limit(1).toList();
    }
}
