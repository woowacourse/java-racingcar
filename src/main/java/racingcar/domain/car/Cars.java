package racingcar.domain.car;

import racingcar.domain.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {
    private static final int DEFAULT_POSITION = 0;
    private static final String DELIMITER = ",";

    public static List<Car> generateCarsByInput(String inputForCarNames) {
        List<Car> cars = new ArrayList<>();

        validateNames(inputForCarNames);
        validateDuplicatedNames(inputForCarNames);

        for (String name : getSplit(inputForCarNames)) {
            cars.add(new Car(name, DEFAULT_POSITION));
        }

        return cars;
    }

    private static String[] getSplit(String inputForCarNames) {
        return inputForCarNames.split(DELIMITER);
    }

    public static void validateNames(String input) throws IllegalArgumentException {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력값은 빈 문자열일 수 없습니다.");
        }
    }

    public static void validateDuplicatedNames(String input) throws IllegalArgumentException {
        String[] splitInput = getSplit(input);
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

    public static void play(List<Car> cars) {
        int number = RandomNumberGenerator.generateNumber();
        for (Car car : cars) {
            car.moveByNumber(number);
        }
    }
}
