package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private static final int ZERO = 0;

    public Winners() {
    }

    public List<String> judge(Cars cars) {
        return Collections.unmodifiableList(cars.getCars()
                .stream()
                .filter(car -> car.isMaxPosition(extractMaxPosition(cars)))
                .map(Car::getName)
                .collect(Collectors.toList()));
    }

    private int extractMaxPosition(Cars cars) {
        return cars.getCars()
                .stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(ZERO);
    }
}
