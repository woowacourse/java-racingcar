package racingcar.domain;

import racingcar.dto.CarsDto;
import racingcar.utils.RandomUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Cars.java
 * 자동차 객체들을 담는 일급 컬렉션
 *
 * @author Kimun Kim, github.com/tributetothemoon
 */
public class Cars {
    private static final int MIN_INCLUSIVE = 0;
    private static final int MAX_INCLUSIVE = 9;
    private static final int MIN_SIZE = 2;
    private static final String ERROR_MIN_SIZE = "최소 " + MIN_SIZE + "대 이상의 이름을 입력하세요.";
    private static final String ERROR_DUPLICATED_CAR_NAMES = "자동차 이름이 중복됩니다.";

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of (List<String> carNames) {
        isValidNumberOfCarsOrThrow(carNames);

        List<Car> cars = new ArrayList<>();
        carNames.stream()
                .map(Car::from)
                .filter(car -> isNotAlreadyExistOrThrow(cars, car))
                .forEach(cars::add);
        return new Cars(cars);
    }

    private static boolean isValidNumberOfCarsOrThrow(List<String> carNames) {
        if (carNames.size() < MIN_SIZE) {
            throw new IllegalArgumentException(ERROR_MIN_SIZE);
        }
        return true;
    }

    private static boolean isNotAlreadyExistOrThrow(List<Car> destination, Car car) {
        if (destination.contains(car)) {
            throw new IllegalArgumentException(ERROR_DUPLICATED_CAR_NAMES);
        }
        return true;
    }

    public void moveCars() {
        cars.stream()
                .filter(car -> DecisionMaker.makeDecisionByNumber(RandomUtils.nextInt(MIN_INCLUSIVE, MAX_INCLUSIVE)))
                .forEach(Car::move);
    }

    public int getTopPosition() {
        return Collections.max(cars).getPosition();
    }

    public List<Car> toList() {
        return this.cars;
    }

    public CarsDto toDto() {
        return CarsDto.of(this.cars);
    }
}
