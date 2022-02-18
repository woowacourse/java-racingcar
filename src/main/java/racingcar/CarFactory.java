package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CarFactory {
    private static final String DUPLICATED_NAME_ERROR = "[ERROR] 차 이름은 중복될 수 없습니다.";

    public static List<Car> of(String names) {
        String[] arrNames = names.split(",");
        return  Arrays.stream(arrNames)
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
