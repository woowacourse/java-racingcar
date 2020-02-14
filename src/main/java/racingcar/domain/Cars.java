package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    public static final String DELIMITER = ",";
    public static final int MINIMUM_TEAM = 2;
    public static final int OPTION = -1;

    private List<Car> cars;

    public Cars(String inputNames) {
        String[] names = inputNames.split(DELIMITER, OPTION);

        cars = Arrays.stream(names)
                .map(name -> new Car(new Name(name.trim())))
                .collect(Collectors.toList());

        validateCars();
    }

    Cars(List<Car> cars) {
        this.cars = cars;
    }

    private void validateCars() {
        if (cars.size() < MINIMUM_TEAM) {
            throw new IllegalArgumentException("참가자는 " + MINIMUM_TEAM + "명 이상이어야합니다.");
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getWinners() {
        final Car winner = cars.stream()
                .max(Car::compareTo)
                .get();

        return cars.stream()
                .filter(car -> car.isWinner(winner))
                .map(Car::toString)
                .collect(Collectors.toList());
    }
}