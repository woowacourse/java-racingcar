package racingcar.service;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.dto.RacingCarNamesRequest;
import racingcar.dto.RacingCarStatusResponse;

public class RacingCarService {
    private final MoveStrategy moveStrategy;
    private final List<Car> cars =  new ArrayList<>();

    public RacingCarService(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public void createCars(RacingCarNamesRequest request) {
        List<Car> cars = request.getNames().stream()
                .map(Car::new)
                .collect(toList());
        this.cars.addAll(cars);
    }

    public void moveCars() {
        for (Car car : cars) {
            if (moveStrategy.isMovable()) {
                car.move();
            }
        }
    }

    public List<RacingCarStatusResponse> getCarStatuses() {
        return cars.stream()
                .map(Car::getStatus)
                .collect(toList());
    }
}
