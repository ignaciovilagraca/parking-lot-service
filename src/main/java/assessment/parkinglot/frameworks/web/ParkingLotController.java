package assessment.parkinglot.frameworks.web;

import assessment.parkinglot.adapters.SpotMapper;
import assessment.parkinglot.adapters.VehicleFactory;
import assessment.parkinglot.domain.spot.Spot;
import assessment.parkinglot.domain.vehicle.Vehicle;
import assessment.parkinglot.usecases.ParkingLot;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ParkingLotController {

    private final VehicleFactory vehicleFactory;
    private final ParkingLot parkingLot;
    private final SpotMapper spotMapper;

    public ParkingLotController(VehicleFactory vehicleFactory, ParkingLot parkingLot, SpotMapper spotMapper) {
        this.vehicleFactory = vehicleFactory;
        this.parkingLot = parkingLot;
        this.spotMapper = spotMapper;
    }

    @PostMapping("/park")
    public ResponseEntity<List<SpotDto>> park(@RequestBody VehicleDto vehicleDto) {
        Vehicle vehicle = vehicleFactory.create(vehicleDto);
        List<Spot> spots = parkingLot.park(vehicle);
        return ResponseEntity.ok(spotMapper.map(spots));
    }

    @PostMapping("/leave")
    public ResponseEntity<List<SpotDto>> leave(@RequestBody VehicleDto vehicleDto) {
        Vehicle vehicle = vehicleFactory.create(vehicleDto);
        List<Spot> spots = parkingLot.leave(vehicle);
        return ResponseEntity.ok(spotMapper.map(spots));
    }
}
