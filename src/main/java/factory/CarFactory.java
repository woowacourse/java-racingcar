package factory;

import racingcar.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {
    private static final String CAR_NAME_DELIMITER = ",";

    private CarFactory() {
        throw new IllegalStateException("생성할 수 없는 유틸 클래스입니다.");
    }

    public static List<Car> from(String carNames) {
        return Arrays.stream(carNames.split(CAR_NAME_DELIMITER))
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
