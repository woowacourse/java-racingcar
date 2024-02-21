package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racing.util.RandomMoveMaker;

public class Cars {

    private static final String DUPLICATE_CAR_NAME = "자동차 이름이 중복되었습니다.";

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validate(cars);
        this.cars = new ArrayList<>(cars);
    }

    private void validate(List<Car> cars) {
        validateDuplicate(cars);
    }

    private void validateDuplicate(List<Car> cars) {
        int count = (int) cars.stream().distinct().count();
        if (count != cars.size()) {
            throw new IllegalArgumentException(DUPLICATE_CAR_NAME);
        }
    }

    public void moveAll(RandomMoveMaker randomMoveMaker) {
        cars.stream()
                .filter(car -> randomMoveMaker.isMove())
                .forEach(Car::move);
    }

    public List<Car> findWinners() {
        Collections.sort(cars);
        return cars.stream().filter(car -> car.isSame(cars.get(0))).toList();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
