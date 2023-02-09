package racingcar.service;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;
import static racingcar.exception.ExceptionMessage.EMPTY_CARS;
import static racingcar.validator.Validator.*;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Position;
import racingcar.dto.RacingCarNamesRequest;
import racingcar.dto.RacingCarStatusResponse;
import racingcar.dto.RacingCarWinnerResponse;
import racingcar.repository.CarRepository;

public class RacingCarService {
    private final CarRepository carRepository;

    public RacingCarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void createCars(RacingCarNamesRequest request) {
        List<Car> cars = request.getNames().stream()
                .map(Car::new)
                .collect(toList());
        carRepository.saveAll(cars);
    }

    public void moveCars(MoveStrategy moveStrategy) {
        List<Car> cars = carRepository.findAll();
        if (cars.isEmpty()) {
            throw new IllegalStateException(EMPTY_CARS.getMessage());
        }
        for (Car car : cars) {
            move(moveStrategy, car);
        }
    }

    private void move(MoveStrategy moveStrategy, Car car) {
        if (moveStrategy.isMovable()) {
            car.move();
        }
    }

    public List<RacingCarStatusResponse> getCarStatuses() {
        List<Car> cars = carRepository.findAll();
        return cars.stream()
                .map(Car::getStatus)
                .collect(toList());
    }

    public RacingCarWinnerResponse findWinners() {
        List<Car> cars = carRepository.findAll();
        Position maxPosition = getMaxPosition(cars);
        List<Car> winners = cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .collect(toList());
        return RacingCarWinnerResponse.of(winners);
    }

    private Position getMaxPosition(List<Car> cars) {
        return cars.stream()
                .map(Car::getMovedLength)
                .max(comparing(Position::getValue))
                .orElseThrow(() -> new IllegalStateException(EMPTY_CARS.getMessage()));
    }
}
