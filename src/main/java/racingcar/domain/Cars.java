package racingcar.domain;

import calculator.domain.Delimiter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
    public static final String DELIMITER = ",";
    public static final int MINIMUM_TEAM = 2;
    public static final int MAXIMUM_NAME = 5;
    private List<Car> cars;

    public Cars(String inputNames) {
        String[] names = inputNames.split(DELIMITER);
        validate(names);

        cars = Arrays.stream(names)
                .map(name -> new Car(name.trim()))
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        int maximum = 0;

        for (Car car : cars) {
            if (maximum < car.getPosition()) {
                winners.clear();
                maximum = car.getPosition();
                winners.add(car.getName());
            } else if (maximum == car.getPosition()) {
                winners.add(car.getName());
            }
        }

        return winners;
    }

    public void validate(String[] splittedNames) {
        if (splittedNames.length < MINIMUM_TEAM) {
            throw new IllegalArgumentException("참가자는 2명 이상이어야합니다.");
        }

        if (Arrays.stream(splittedNames)
                .anyMatch(name -> name.length() > MAXIMUM_NAME)) {
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }
    }
}
