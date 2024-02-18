package dto;

import java.util.List;

public record RaceResult(
        List<CarsStatus> results
) {
}
