package racingcar.domain.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final String DUPLICATE_ERROR = "중복된 이름은 입력할 수 없습니다.";
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateDuplicate(cars);
        this.cars = new ArrayList<>(cars);
    }

    private void validateDuplicate(List<Car> cars) {
        long checkedSize = cars.stream()
                .distinct().count();
        if (cars.size() != checkedSize) {
            throw new IllegalArgumentException(DUPLICATE_ERROR);
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void move(MoveValueStrategy moveValueStrategy) {
        for (Car car : cars) {
            car.move(moveValueStrategy);
        }
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        List<Car> winners = cars.stream()
                .filter(car -> car.isSamePosition(new Position(maxPosition)))
                .collect(Collectors.toList());
        return winners;
    }

    private int getMaxPosition() {
        int position = 0;
        for (Car car : cars) {
            position = car.findMaxPosition(new Position(position));
        }
        return position;
    }
}