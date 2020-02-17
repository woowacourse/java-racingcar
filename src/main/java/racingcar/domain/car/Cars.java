package racingcar.domain.car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Cars {
    private static final String DELIMITER = ",";

    private final List<Car> cars;

    public Cars(String names) {
        List<Car> cars = new ArrayList<>();

        validateNames(names);
        validateDuplicatedNames(names);

        for (String name : names.split(DELIMITER)) {
            cars.add(new Car(name));
        }

        this.cars = cars;
    }

    public Cars(String names, int location) {
        List<Car> cars = new ArrayList<>();

        validateNames(names);
        validateDuplicatedNames(names);

        for (String name : names.split(DELIMITER)) {
            cars.add(new Car(name, location++));
        }

        this.cars = cars;
    }

    public static void validateNames(String carNames) throws IllegalArgumentException {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("입력값은 빈 문자열일 수 없습니다.");
        }
    }

    public static void validateDuplicatedNames(String carNames) throws IllegalArgumentException {
        String[] splitInput = carNames.split(DELIMITER);
        if (isDuplicatedNames(splitInput)) {
            throw new IllegalArgumentException("이름들은 중복될 수 없습니다.");
        }
    }

    private static boolean isDuplicatedNames(String[] splitcarNames) {
        return Arrays.stream(splitcarNames)
                .map(s -> s.trim())
                .distinct()
                .count() != splitcarNames.length;
    }

    public void play() {
        for (Car car : cars) {
            car.play();
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
