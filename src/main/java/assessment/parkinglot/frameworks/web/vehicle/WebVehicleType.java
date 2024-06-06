package assessment.parkinglot.frameworks.web.vehicle;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum WebVehicleType {
    @JsonProperty("motorcycle")
    MOTORCYCLE,
    @JsonProperty("car")
    CAR,
    @JsonProperty("van")
    VAN
}
