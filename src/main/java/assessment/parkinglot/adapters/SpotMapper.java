package assessment.parkinglot.adapters;

import assessment.parkinglot.domain.spot.Spot;
import assessment.parkinglot.frameworks.web.SpotDto;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class SpotMapper {
    public List<SpotDto> map(List<Spot> spots) {
        return spots.stream().map(spot -> SpotDto.builder().id(spot.id()).available(spot.isAvailable()).build()).toList();
    }
}
