package racingcar;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private static final String DUPLICATED_NAME_ERROR = "[ERROR] 차 이름은 중복될 수 없습니다.";

    private final Set<Car> cars;

    public Cars(List<Car> carList) {
        validateDuplicatedCarName(carList);
        this.cars = new HashSet<>(carList);
    }

    public int getNumberOfCar() {
        return cars.size();
    }

    private static void validateDuplicatedCarName(List<Car> carList) {
        if (carList.size() != carList.stream().distinct().count()) {
            throw new IllegalArgumentException(DUPLICATED_NAME_ERROR);
        }
    }

    public Set<Car> getCars() {
        return Collections.unmodifiableSet(cars);
    }
}
