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
                .map(name -> new Car(name.trim()))
                .collect(Collectors.toList());

        validateCarNames();
    }

    protected Cars(List<Car> cars) {
        this.cars = cars;
    }

    private void validateCarNames() {
        if (cars.size() < MINIMUM_TEAM) {
            throw new IllegalArgumentException("참가자는 " + MINIMUM_TEAM + "명 이상이어야합니다.");
        }

        if (cars.stream()
                .anyMatch(Car::hasOverFiveCharacterName)) {
            throw new IllegalArgumentException("이름은 " + Car.MAXIMUM_NAME + "자 이하여야 합니다.");
        }

        if (cars.stream()
                .anyMatch(Car::isEmpty)) {
            throw new IllegalArgumentException("입력이 없습니다.");
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getWinners() {
        final int maxPosition = cars.stream()
                 .map(car -> car.getPosition())
                 .max(Integer::compareTo)
                 .get();

         return cars.stream()
                 .filter(car -> car.isMaxPosition(maxPosition))
                 .map(car -> car.getName())
                 .collect(Collectors.toList());
    }
}
