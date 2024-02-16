package dto;

import domain.Cars;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TurnStatus {
    private final List<CarStatus> carStatuses;

    public TurnStatus(List<CarStatus> carStatuses) {
        this.carStatuses = carStatuses;
    }

    public static TurnStatus from(Cars cars) {
        return new TurnStatus(convertToCarsStatus(cars));
    }

    private static List<CarStatus> convertToCarsStatus(Cars cars) {
        return cars.getCars().stream()
                .map(CarStatus::of)
                .collect(Collectors.toList());
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
        TurnStatus that = (TurnStatus) o;
        return Objects.equals(carStatuses, that.carStatuses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carStatuses);
    }
}
