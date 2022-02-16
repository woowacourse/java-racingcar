package racingcar.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import racingcar.util.RandomNumberGenerator;

public class Cars {

    private static final RandomNumberGenerator RANDOM_NUMBER_GENERATOR = new RandomNumberGenerator();
    private static final String DUPLICATE_CAR_NAME_ERROR_MESSAGE = "자동차의 이름이 중복되었습니다.";
    private static final String NO_SUCH_CAR_ERROR_MESSAGE = "자동차가 없습니다.";
    private static final int NONE_DUPLICATION = 0;

    private List<Car> cars;

    public Cars(String[] names) {
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
            results.add(raceAll());
            attempt.decrease();
        }
        return results;
    }

    private RoundResult raceAll() {
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
                .orElseThrow(() -> new NoSuchElementException(NO_SUCH_CAR_ERROR_MESSAGE));
        return cars.stream()
                .filter(car -> car.isSamePosition(maxPositionCar))
                .collect(Collectors.toList());
    }

    private void validateDuplicateCarName(Car car) {
        if (cars.stream().filter(each -> each.isSameName(car)).count() != NONE_DUPLICATION) {
            throw new RuntimeException(DUPLICATE_CAR_NAME_ERROR_MESSAGE);
        }
    }

    @Override
    public String toString() {
        return cars.toString();
    }
}
