package assessment.parkinglot.frameworks.web.vehicle;

import java.util.UUID;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class VehicleDto {
    private UUID id;
    private WebVehicleType type;
}
