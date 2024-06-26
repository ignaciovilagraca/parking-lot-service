package assessment.parkinglot.frameworks.database.spot;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpotEntity, UUID> {
    List<ParkingSpotEntity> findAllByVehicleIsNull();
    List<ParkingSpotEntity> findAllByVehicleIsNotNull();

}
