package dto;

import domain.Car;
import domain.Cars;
import java.util.ArrayList;
import java.util.List;

public class TurnResult {
    private final List<CarStatus> carStatuses;

    public TurnResult(List<CarStatus> carStatuses) {
        this.carStatuses = carStatuses;
    }

    public static TurnResult from(Cars cars) {
        return new TurnResult(cars.toDto());
    }

    public List<CarStatus> getCarStatuses() {
        return carStatuses;
    }
}
