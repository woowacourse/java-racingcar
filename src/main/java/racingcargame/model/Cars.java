package racingcargame.model;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final String HAS_DUPLICATE_CAR_NAME_ERROR_MESSAGE = "[error] 입력한 자동차 이름 중 중복되는 이름이 있습니다.";

    private final List<Car> cars;

    public Cars(final List<String> carNames) {
        checkDuplicateCarNames(carNames);
        cars = carNames.stream().
                map(carName -> new Car(carName, 0)).
                collect(Collectors.toList());
    }

    public Cars(final List<String> carNames, int carPositions) {
        checkDuplicateCarNames(carNames);
        cars = carNames.stream().
                map(carName -> new Car(carName, carPositions)).
                collect(Collectors.toList());
    }

    private void checkDuplicateCarNames(final List<String> carNames) {
        int distinctNameCount = (int) carNames.stream().distinct().count();
        if (carNames.size() != distinctNameCount) {
            throw new IllegalArgumentException(HAS_DUPLICATE_CAR_NAME_ERROR_MESSAGE);
        }
    }

    void moveCars() {
        cars.forEach(Car::moveCar);
    }

    HashMap<String, Integer> bringCarsPositionSeparatedByName() {
        HashMap<String, Integer> carsPosition = new HashMap<>();
        cars.forEach(car -> carsPosition.put(car.getName(), car.getPosition()));
        return carsPosition;
    }

    List<String> findWinner() {
        int winnerPosition = findWinnerPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == winnerPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int findWinnerPosition() {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getPosition)).get().
                getPosition();
    }
}
