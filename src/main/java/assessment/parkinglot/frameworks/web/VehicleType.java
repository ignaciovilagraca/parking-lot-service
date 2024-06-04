package assessment.parkinglot.frameworks.web;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum VehicleType {
    @JsonProperty("motorcycle")
    MOTORCYCLE,
    @JsonProperty("car")
    CAR,
    @JsonProperty("van")
    VAN
}
