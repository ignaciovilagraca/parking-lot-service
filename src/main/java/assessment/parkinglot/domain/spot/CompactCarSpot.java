package assessment.parkinglot.domain.spot;

import assessment.parkinglot.domain.vehicle.Car;
import assessment.parkinglot.domain.vehicle.Motorcycle;
import assessment.parkinglot.domain.vehicle.Van;
import assessment.parkinglot.domain.vehicle.Vehicle;

public class CompactCarSpot extends ParkingSpot {

    public CompactCarSpot(Integer id, Vehicle vehicle) {
        super(id, vehicle);
    }

    public CompactCarSpot(Integer id) {
        super(id);
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
        return false;
    }

}
