package racing.domain;

import java.util.Map;
import racing.dto.RacingResult;

public class RacingDTOMapper {
    public static RacingResult from(Racing racing) {
        Map<String, Integer> carsStatus = racing.getCarsStatus();
        return new RacingResult(carsStatus);
    }
}
