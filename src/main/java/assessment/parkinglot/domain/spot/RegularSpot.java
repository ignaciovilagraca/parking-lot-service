package assessment.parkinglot.domain.spot;

import assessment.parkinglot.domain.vehicle.Car;
import assessment.parkinglot.domain.vehicle.Motorcycle;
import assessment.parkinglot.domain.vehicle.Van;

public class RegularSpot extends ParkingSpot {

    public RegularSpot(Integer id, Boolean available) {
        super(id, available);
    }

    @Override
    public boolean canPark(Car car) {
        return true;
    }

    @Override
    public boolean canPark(Motorcycle motorcycle) {
        return false;
    }

    @Override
    public boolean canPark(Van van) {
        return true;
    }

}
