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

    public static void validateNames(String input) throws IllegalArgumentException {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력값은 빈 문자열일 수 없습니다.");
        }
    }


    public static void validateDuplicatedNames(String input) throws IllegalArgumentException {
        String[] splitInput = input.split(DELIMITER);
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

    public void play() {
        for (Car car : cars) {
            car.play();
        }
    }

    public String getResult() {
        StringBuilder results = new StringBuilder();
        for (Car car : cars) {
            results.append(car.getResult());
            results.append("\n");
        }
        return results.toString();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
