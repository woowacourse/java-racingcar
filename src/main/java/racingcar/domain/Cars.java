package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    Cars(String names) {
        List<Car> cars = new ArrayList<>();

        validateNames(names);
        validateDuplicatedNames(names);

        for (String name : names.split(",")) {
            cars.add(new Car(name));
        }

        this.cars = cars;
    }

    public static void validateNames(String input) throws IllegalArgumentException {
        if (input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }


    public static void validateDuplicatedNames(String input) throws IllegalArgumentException {
        String[] splitInput = input.split(",");
        if (isDuplicatedNames(splitInput)) {
            throw new IllegalArgumentException("이름들은 중복될 수 없습니다.");
        }
    }

    private static boolean isDuplicatedNames(String[] splitInput) {
        return Arrays.stream(splitInput)
                .map(s -> s.trim())
                .distinct()
                .count() != splitInput.length;
    }
}
