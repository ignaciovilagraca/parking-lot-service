package assessment.parkinglot.adapters;

import assessment.parkinglot.domain.vehicle.Parkable;
import assessment.parkinglot.frameworks.database.vehicle.VehicleRepository;
import assessment.parkinglot.usecases.ParkableProvider;
import org.springframework.stereotype.Component;

@Component
public class VehicleProvider implements ParkableProvider {

    private final VehicleRepository vehicleRepository;

    public VehicleProvider(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public void create(Parkable parkable) {
        vehicleRepository.save(parkable.asEntity());
    }
}
