package assessment.parkinglot.usecases;

import assessment.parkinglot.domain.vehicle.Parkable;

public interface ParkableProvider {
    void create(Parkable parkable);
}
