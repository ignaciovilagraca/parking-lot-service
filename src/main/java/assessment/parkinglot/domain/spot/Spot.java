package assessment.parkinglot.domain.spot;

import assessment.parkinglot.domain.vehicle.Car;
import assessment.parkinglot.domain.vehicle.Motorcycle;
import assessment.parkinglot.domain.vehicle.Van;

public interface Spot {
    boolean canPark(Car car);
    boolean canPark(Motorcycle motorcycle);
    boolean canPark(Van van);

    boolean isAvailable();

    void occupy();

    void liberate();
}
