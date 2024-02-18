package dto;

import java.util.List;

public record RacingStatus(
        List<CarState> carStates
) {
}
