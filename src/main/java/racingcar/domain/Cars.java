package racingcar.domain;

import java.util.*;

import static racingcar.domain.CarName.ERROR_MESSAGE_OF_INVALID_INPUT;

public class Cars {
    private static final char COMMA = ',';
    private static final String COMMA_DELIMITER = ",";
    public static final String ERROR_MESSAGE_OF_DUPLICATED_NAME = "이름이 중복됩니다.";

    private final List<Car> cars = new ArrayList<>();

    public Cars(String inputNames) {
        validateBothEnds(inputNames);
        for (String name : inputNames.split(COMMA_DELIMITER)) {
            cars.add(new Car(validateDuplicate(name)));
        }
    }

    private void validateBothEnds(String inputNames) {
        if (inputNames.charAt(0) == COMMA || inputNames.charAt(inputNames.length() - 1) == COMMA) {
            throw new IllegalArgumentException(ERROR_MESSAGE_OF_INVALID_INPUT);
        }
    }

    private String validateDuplicate(String name) {
        if (cars.contains(new Car(name))) {
            throw new IllegalArgumentException(ERROR_MESSAGE_OF_DUPLICATED_NAME);
        }
        return name;
    }

    public void moveAllCars() {
        for (Car car : cars) {
            car.moveByNumber(RandomNumber.make());
        }
    }

    public List<Car> toList() {
        return cars;
    }

    public List<String> getWinnersNames() {
        final Winners winners = new Winners(cars);
        List<String> winnersNames = new ArrayList<>();
        for (Car winnerCar : winners.toList()) {
            winnersNames.add(winnerCar.getName());
        }
        return winnersNames;
    }
}
