package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ExceptionHandler {
    private static final String NAME_SPLIT_DELIMITER = ",";

    public List<Car> setCars(String input) {
        String[] carNames = input.split(NAME_SPLIT_DELIMITER, -1);
        return Arrays.stream(carNames)
            .map(Car::new)
            .collect(Collectors.toList());
    }

    public int setTrial(String input) {
        return Integer.parseInt(input);
    }
}
