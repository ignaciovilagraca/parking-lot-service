package assessment.parkinglot.adapters;

import assessment.parkinglot.domain.vehicle.Car;
import assessment.parkinglot.domain.vehicle.Motorcycle;
import assessment.parkinglot.domain.vehicle.Van;
import assessment.parkinglot.domain.vehicle.Vehicle;
import assessment.parkinglot.frameworks.database.vehicle.VehicleEntity;
import assessment.parkinglot.frameworks.exceptions.InvalidVehicleTypeException;
import assessment.parkinglot.frameworks.web.vehicle.VehicleDto;
import org.springframework.stereotype.Component;

@Component
public class VehicleMapper {

    public Vehicle map(VehicleDto vehicleDto) {
        Vehicle vehicle;
        switch (vehicleDto.getType()) {
            case MOTORCYCLE -> vehicle = new Motorcycle(vehicleDto.getId());
            case CAR -> vehicle = new Car(vehicleDto.getId());
            case VAN -> vehicle = new Van(vehicleDto.getId());
            default -> throw new InvalidVehicleTypeException("The vehicle type is invalid");
        }
        return vehicle;
    }

    public Vehicle map(VehicleEntity vehicleEntity) {
        Vehicle vehicle = null;

        if (vehicleEntity == null) {
            return vehicle;
        }

        switch (vehicleEntity.getType()) {
            case MOTORCYCLE -> vehicle = new Motorcycle(vehicleEntity.getId());
            case CAR -> vehicle = new Car(vehicleEntity.getId());
            case VAN -> vehicle = new Van(vehicleEntity.getId());
            default -> throw new InvalidVehicleTypeException("The vehicle type is invalid");
        }
        return vehicle;
    }
}
