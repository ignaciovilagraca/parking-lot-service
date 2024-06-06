package assessment.parkinglot.adapters;

import assessment.parkinglot.domain.spot.Spot;
import assessment.parkinglot.frameworks.database.spot.ParkingSpotRepository;
import assessment.parkinglot.frameworks.database.spot.ParkingSpotEntity;
import assessment.parkinglot.usecases.SpotProvider;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ParkingSpotProvider implements SpotProvider {

    private final ParkingSpotRepository parkingSpotRepository;
    private final SpotMapper spotMapper;

    public ParkingSpotProvider(ParkingSpotRepository parkingSpotRepository, SpotMapper spotMapper) {
        this.parkingSpotRepository = parkingSpotRepository;
        this.spotMapper = spotMapper;
    }

    @Override
    public List<Spot> getAvailableSpots() {
        return parkingSpotRepository.findAllByVehicleIsNull()
                .stream()
                .map(spotMapper::map)
                .toList();
    }

    @Override
    public List<Spot> getUsedSpots() {
        return parkingSpotRepository.findAllByVehicleIsNotNull()
                .stream()
                .map(spotMapper::map)
                .toList();
    }

    @Override
    public List<Spot> save(List<Spot> spots) {
        List<ParkingSpotEntity> entities = spots.stream().map(spotMapper::map).toList();
        return parkingSpotRepository.saveAll(entities).stream().map(spotMapper::map).toList();
    }
}
