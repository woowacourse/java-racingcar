package racingcar.dto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Cars;

public class CarsResponse {

    private final List<CarResponse> cars;

    public CarsResponse(Cars cars) {
        this.cars = cars.getCars().stream()
            .map(CarResponse::new)
            .collect(Collectors.toList());
    }

    public List<CarResponse> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
