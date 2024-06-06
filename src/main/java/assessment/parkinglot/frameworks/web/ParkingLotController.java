package assessment.parkinglot.frameworks.web;

import assessment.parkinglot.adapters.VehicleMapper;
import assessment.parkinglot.domain.spot.Spot;
import assessment.parkinglot.domain.vehicle.Vehicle;
import assessment.parkinglot.frameworks.web.spot.SpotDto;
import assessment.parkinglot.frameworks.web.vehicle.VehicleDto;
import assessment.parkinglot.usecases.ParkingLot;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ParkingLotController {

    private final VehicleMapper vehicleMapper;
    private final ParkingLot parkingLot;

    public ParkingLotController(VehicleMapper vehicleMapper, ParkingLot parkingLot) {
        this.vehicleMapper = vehicleMapper;
        this.parkingLot = parkingLot;
    }

    @PostMapping("/park")
    public ResponseEntity<List<SpotDto>> park(@RequestBody VehicleDto vehicleDto) {
        Vehicle vehicle = vehicleMapper.map(vehicleDto);
        List<Spot> spots = parkingLot.park(vehicle);
        List<SpotDto> spotDtos = spots.parallelStream().map(Spot::asDto).toList();
        return ResponseEntity.ok(spotDtos);
    }

    @PostMapping("/leave")
    public ResponseEntity<List<SpotDto>> leave(@RequestBody VehicleDto vehicleDto) {
        Vehicle vehicle = vehicleMapper.map(vehicleDto);
        List<Spot> spots = parkingLot.leave(vehicle);
        List<SpotDto> spotDtos = spots.parallelStream().map(Spot::asDto).toList();
        return ResponseEntity.ok(spotDtos);
    }

    @GetMapping("/remaining_spots")
    public ResponseEntity<Integer> remainingSpots() {
        return ResponseEntity.ok(parkingLot.remainingSpots());
    }

    @PostMapping("/check")
    public ResponseEntity<Boolean> remainingSpots(@RequestBody VehicleDto vehicleDto) {
        Vehicle vehicle = vehicleMapper.map(vehicleDto);
        return ResponseEntity.ok(parkingLot.check(vehicle));
    }
}
