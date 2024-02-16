package dto;

import domain.Car;
import domain.Cars;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TurnResult that = (TurnResult) o;
        return Objects.equals(carStatuses, that.carStatuses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carStatuses);
    }
}
