package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.utils.RandomUtils;

public class Cars {

    private static final int NUMBER_OF_CARS_MIN = 2;
    private static final String NAME_SPLIT_DELIMITER = ",";

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        validateNumberOfCars(cars);
        validateDuplication(cars);
        this.cars = new ArrayList<>(cars);
    }

    private static void validateNumberOfCars(final List<Car> cars) {
        if (cars.size() < NUMBER_OF_CARS_MIN) {
            throw new IllegalArgumentException("자동차는 두 대 이상 입력해야 합니다.");
        }
    }

    private static void validateDuplication(final List<Car> cars) {
        final HashSet<Car> nonDuplicatedCars = new HashSet<>(cars);
        if (nonDuplicatedCars.size() != cars.size()) {
            throw new IllegalArgumentException("중복되는 이름을 입력할 수 없습니다.");
        }
    }

    public static Cars newInstance(final String input) {
        final String[] carNames = input.split(NAME_SPLIT_DELIMITER, -1);
        return new Cars(Arrays.stream(carNames)
            .map(Car::new)
            .collect(Collectors.toList()));
    }

    public void tryToMove() {
        for (Car car : cars) {
            final int currentRpm = RandomUtils.nextNumber();
            car.tryToMove(currentRpm);
        }
    }

    public int findPositionMax() {
        return cars.stream().map(Car::getPosition).reduce(Integer::max).orElse(-1);
    }

    public List<String> findCarNamesLocatedAt(int position) {
        return cars.stream().filter(car -> car.getPosition() == position).map(Car::getName)
            .collect(
                Collectors.toList());
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}
