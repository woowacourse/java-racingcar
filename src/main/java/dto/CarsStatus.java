package dto;

import java.util.List;

public record CarsStatus(
        List<CarStatus> status
) {
}
