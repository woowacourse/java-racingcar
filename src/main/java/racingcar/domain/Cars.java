package racingcar.domain;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class Cars {
    private static final String DELIMITER = ",";
    private static final int MINIMUM_CAR_NAME_QUANTITY = 2;
    public static final int EMPTY_LENGTH = 0;

    private MoveStrategy moveStrategy = new RandomMoveStrategy();
    private final List<Car> cars;

    public Cars(final String input) {
        checkInput(input);
        this.cars = makeCars(input);
    }

    protected Cars(final List<Car> cars) {
        this.cars = cars;
    }

    private static void checkInput(final String nameString) {
        checkNullOrBlank(nameString);
        checkHasOnlyDelimiter(nameString);
        checkDuplicateName(nameString);
        checkMinimumCarNameQuantity(nameString);
    }

    private static void checkNullOrBlank(String nameString) {
        if (nameString == null || nameString.isBlank()) {
            throw new IllegalArgumentException("자동차들의 값을 입력해주세요!");
        }
    }

    private static void checkHasOnlyDelimiter(final String nameString) {
        if (isEmpty(nameString.split(DELIMITER))) {
            throw new IllegalArgumentException("구분자 이외의 이름을 입력해주세요");
        }
    }

    private static void checkMinimumCarNameQuantity(final String nameString) {
        if (hasMinimumCarName(nameString)) {
            throw new IllegalArgumentException("최소 자동차 수는 " + MINIMUM_CAR_NAME_QUANTITY + " 개 이상이어야 합니다.");
        }
    }

    private static void checkDuplicateName(final String nameString) {
        if (hasDuplicateName(nameString)) {
            throw new IllegalArgumentException("이름은 중복될 수 없습니다.");
        }
    }

    private static boolean hasMinimumCarName(final String nameString) {
        return nameString.split(DELIMITER).length < MINIMUM_CAR_NAME_QUANTITY;
    }

    private static boolean hasDuplicateName(final String nameString) {
        final long origin = Arrays.stream(nameString.split(DELIMITER))
            .count();

        final long distinct = Arrays.stream(nameString.split(DELIMITER))
            .distinct()
            .count();

        return origin != distinct;
    }

    private static boolean isEmpty(final String[] array) {
        return array.length <= EMPTY_LENGTH;
    }

    private List<Car> makeCars(final String input) {
        final String[] carNames = input.split(DELIMITER);

        return Arrays.stream(carNames).map(CarName::new).map(Car::new).collect(toList());
    }

    public void attemptToMoveCars() {
        for (final Car car : cars) {
            car.attemptToMove(moveStrategy.isMove());
        }
    }

    public List<Car> findWinners() {
        final Car maxPositionCar = getMaxPositionCar();
        return cars.stream().filter(car -> car.isSamePositionWith(maxPositionCar))
            .collect(toList());
    }

    private Car getMaxPositionCar() {
        return cars.stream().max(Car::compareTo).orElseThrow(NoSuchElementException::new);
    }

    public List<Car> get() {
        return cars;
    }

    public void setMoveStrategy(final MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }
}
