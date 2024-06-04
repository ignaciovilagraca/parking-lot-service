package assessment.parkinglot.frameworks.web;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SpotDto {
    private final Integer id;
    private Boolean available;
}
