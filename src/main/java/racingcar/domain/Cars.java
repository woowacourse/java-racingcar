package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.utils.Constant;

public class Cars {

    List<Car> cars;

    public Cars(List<Car> cars) {
        checkDuplicate(cars);
        this.cars = cars;

    }

    public List<Car> getCars() {
        return cars;
    }

    private void checkDuplicate(List<Car> cars) {
        Set<String> uniqueNames = new HashSet<>(cars.stream().map(Car::getName).collect(Collectors.toList()));
        if (uniqueNames.size() != cars.size()) {
            throw new IllegalArgumentException(Constant.DUPLICATE_NAME_ERROR);
        }
    }


}
