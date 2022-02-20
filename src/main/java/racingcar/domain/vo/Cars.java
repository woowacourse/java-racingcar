package racingcar.domain.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import util.RandomUtil;

public class Cars {

    private static final String NO_SUCH_CAR_ERROR_MESSAGE = "저장된 자동차가 없습니다.";
    private static final String HAS_NOTHING_CAR_NAME_ERROR_MESSAGE = "자동차의 이름을 1개 이상 입력해야합니다.";
    private static final String DUPLICATE_CAR_NAME_ERROR_MESSAGE = "자동차의 이름이 중복되었습니다.";
    private static final int RANDOM_MINIMUM = 0;
    private static final int RANDOM_MAXIMUM = 9;
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
            int randomNumber = RandomUtil.getRandomNumberBetweenMinimumAndMaximum(RANDOM_MINIMUM, RANDOM_MAXIMUM);
            car.move(randomNumber);
            result.add(car);
        }
        return result;
    }

    public List<Car> findWinners() {
        Car maxPositionCar = cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalStateException(NO_SUCH_CAR_ERROR_MESSAGE));
        return cars.stream()
                .filter(car -> car.isSamePosition(maxPositionCar))
                .collect(Collectors.toList());
    }

    private void validateSize(String[] inputs) {
        if (inputs.length == EMPTY_SIZE) {
            throw new IllegalArgumentException(HAS_NOTHING_CAR_NAME_ERROR_MESSAGE);
        }
    }

    private void validateDuplicateCarName(Car car) {
        if (cars.stream().anyMatch(each -> each.isSameName(car))) {
            throw new IllegalArgumentException(DUPLICATE_CAR_NAME_ERROR_MESSAGE);
        }
    }

    @Override
    public String toString() {
        return cars.toString();
    }
}
