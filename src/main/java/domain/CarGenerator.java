package domain;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarGenerator {
    private static final String COMMA = ",";
    private static final String NOT_INPUT_MESSAGE = "이름을 입력하지 않았습니다.";


    
    public static List<Car> create(String carsName) {
        String[] carNames = carsName.split(COMMA);
        validateLength(carNames);

        List<Car> cars = Arrays.stream(carNames).map(o -> new Car(o)).collect(Collectors.toList());
        return cars;
    }

    private static void validateLength(String[] carNames) {
        if (carNames.length == 0) {
            throw new IllegalArgumentException(NOT_INPUT_MESSAGE);
        }
    }
}
