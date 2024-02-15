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
        return new TurnResult(convertToDto(cars));
    }

    private static List<CarStatus> convertToDto(Cars cars) {
        List<CarStatus> carStatusesTmp = new ArrayList<>();
        for (Car car : cars.getCars()) {
            carStatusesTmp.add(CarStatus.of(car));
        }
        return carStatusesTmp;
    }

    public List<CarStatus> getCarStatuses() {
        return carStatuses;
    }
}
