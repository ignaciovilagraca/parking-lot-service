package assessment.parkinglot.frameworks.database.spot;

import assessment.parkinglot.frameworks.database.vehicle.VehicleEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "parking_spot")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParkingSpotEntity {
    @Id
    private UUID id;
    @Enumerated(EnumType.STRING)
    private ParkingSpotType type;
    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    VehicleEntity vehicle;
}

