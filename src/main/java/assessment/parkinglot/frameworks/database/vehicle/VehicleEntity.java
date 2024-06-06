package assessment.parkinglot.frameworks.database.vehicle;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vehicle")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleEntity {
    @Id
    private UUID id;
    @Enumerated(EnumType.STRING)
    private VehicleType type;
}

