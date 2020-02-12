package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    public static final String DELIMITER = ",";
    public static final int MINIMUM_TEAM = 2;

    private List<Car> cars;

    public Cars(String inputNames) {
        String[] names = inputNames.split(DELIMITER, -1);

        cars = Arrays.stream(names)
                .map(name -> new Car(name.trim()))
                .collect(Collectors.toList());

        validateCarNames();
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getWinners() {
        final int maximum = cars.stream()
                 .map(car -> car.getPosition())
                 .max(Integer::compareTo)
                 .get();

         return cars.stream()
                 .filter(car -> car.getPosition() == maximum)
                 .map(car -> car.getName())
                 .collect(Collectors.toList());
    }

    public void validateCarNames() {
        if (cars.size() < MINIMUM_TEAM) {
            throw new IllegalArgumentException("참가자는 " + MINIMUM_TEAM + "명 이상이어야합니다.");
        }

        if (cars.stream()
                .anyMatch(Car::hasOverFiveCharacterName)) {
            throw new IllegalArgumentException("이름은 " + Car.MAXIMUM_NAME + "자 이하여야 합니다.");
        }
    }
}
