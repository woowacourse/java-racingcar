package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Position;
import racingcar.dto.RacingCarNamesRequest;
import racingcar.dto.RacingCarStatusResponse;
import racingcar.dto.RacingCarWinnerResponse;

import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static racingcar.exception.ExceptionMessage.EMPTY_CARS;

public class RacingCarService {
    private Cars cars;

    public void createCars(RacingCarNamesRequest request) {
        this.cars = new Cars(request.getNames());
    }

    public void moveCars(MoveStrategy moveStrategy) {
        validateEmptyCars();
        for (Car car : cars.getCars()) {
            move(moveStrategy, car);
        }
    }

    private void validateEmptyCars() {
        if (cars == null) {
            throw new IllegalStateException(EMPTY_CARS.getMessage());
        }
    }

    private void move(MoveStrategy moveStrategy, Car car) {
        if (moveStrategy.isMovable()) {
            car.move();
        }
    }

    public List<RacingCarStatusResponse> getCarStatuses() {
        validateEmptyCars();
        return cars.getCars()
                .stream()
                .map(car -> new RacingCarStatusResponse(car.getName(), car.getMovedLength()))
                .collect(toList());
    }

    public RacingCarWinnerResponse findWinners() {
        Position maxPosition = getMaxPosition();
        List<Car> winners = cars.getCars()
                .stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .collect(toList());
        return RacingCarWinnerResponse.of(winners);
    }

    private Position getMaxPosition() {
        validateEmptyCars();
        return cars.getCars()
                .stream()
                .map(Car::getMovedLength)
                .max(comparing(Position::getValue))
                .orElseThrow(() -> new IllegalStateException(EMPTY_CARS.getMessage()));
    }
}
