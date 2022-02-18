package racingcar.domain.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.enums.DomainErrorMessage;
import racingcar.domain.util.RandomNumberGenerator;

public class Cars {

    private static final RandomNumberGenerator RANDOM_NUMBER_GENERATOR = new RandomNumberGenerator();
    private static final int EMPTY_SIZE = 0;

    private List<Car> cars;

    public Cars(String[] names) {
        validateSize(names);
        cars = new ArrayList<>();
        for (String name : names) {
            Car car = new Car(new CarName(name));
            validateDuplicateCarName(car);
            cars.add(car);
        }
    }

    public List<RoundResult> repeatRaceBy(Attempt attempt) {
        List<RoundResult> results = new ArrayList<>();
        while (attempt.isLeft()) {
            results.add(raceAllCar());
            attempt.decrease();
        }
        return results;
    }

    private RoundResult raceAllCar() {
        RoundResult result = new RoundResult();
        for (Car car : cars) {
            car.move(RANDOM_NUMBER_GENERATOR.generate());
            result.add(car);
        }
        return result;
    }

    public List<Car> findWinners() {
        Car maxPositionCar = cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalStateException(DomainErrorMessage.NO_SUCH_CAR_ERROR_MESSAGE.get()));
        return cars.stream()
                .filter(car -> car.isSamePosition(maxPositionCar))
                .collect(Collectors.toList());
    }

    private void validateSize(String[] inputs) {
        if (inputs.length == EMPTY_SIZE) {
            throw new IllegalArgumentException(DomainErrorMessage.HAS_NOTHING_CAR_NAME_ERROR_MESSAGE.get());
        }
    }

    private void validateDuplicateCarName(Car car) {
        if (cars.stream().anyMatch(each -> each.isSameName(car))) {
            throw new IllegalArgumentException(DomainErrorMessage.DUPLICATE_CAR_NAME_ERROR_MESSAGE.get());
        }
    }

    @Override
    public String toString() {
        return cars.toString();
    }
}
