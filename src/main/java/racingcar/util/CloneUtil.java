package racingcar.util;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class CloneUtil {
    public static List<Car> cloneCarList(List<Car> carList) {
        return carList.stream().map(car -> {
            try {
                return car.clone();
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException();
            }
        }).collect(Collectors.toList());
    }
}
