package assessment.parkinglot.frameworks.web.spot;

import java.util.UUID;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SpotDto {
    private final UUID id;
    private Boolean available;
}
