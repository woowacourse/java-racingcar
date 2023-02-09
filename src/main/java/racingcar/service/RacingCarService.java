package racingcar.service;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;
import static racingcar.exception.ExceptionMessage.EMPTY_CARS;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Position;
import racingcar.dto.RacingCarNamesRequest;
import racingcar.dto.RacingCarStatusResponse;
import racingcar.dto.RacingCarWinnerResponse;

public class RacingCarService {
    private final List<Car> cars =  new ArrayList<>();

    public void createCars(RacingCarNamesRequest request) {
        List<Car> cars = request.getNames().stream()
                .map(Car::new)
                .collect(toList());
        this.cars.addAll(cars);
    }

    public void moveCars(MoveStrategy moveStrategy) {
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

    public RacingCarWinnerResponse findWinners() {
        Position maxPosition = getMaxPosition();
        List<Car> winners = cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .collect(toList());
        return RacingCarWinnerResponse.of(winners);
    }

    private Position getMaxPosition() {
        return cars.stream()
                .map(Car::getMovedLength)
                .max(comparing(Position::getValue))
                .orElseThrow(() -> new IllegalStateException(EMPTY_CARS.getMessage()));
    }
}
