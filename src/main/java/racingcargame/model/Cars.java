package racingcargame.model;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import racingcargame.dto.CarDto;

public class Cars {
    private static final String HAS_DUPLICATE_CAR_NAME_ERROR_MESSAGE = "[error] 입력한 자동차 이름 중 중복되는 이름이 있습니다.";

    private final List<Car> cars;

    public Cars(final List<String> carNames) {
        checkDuplicateCarNames(carNames);
        cars = carNames.stream().
                map(carName -> new Car(carName.trim(), 0)).
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

    List<CarDto> bringCarsInformation() {
        return cars.stream().map(Car::changeToDto).collect(Collectors.toList());
    }

    List<CarDto> findWinner() {
        Car winnerCar = findWinnerCar();
        return cars.stream()
                .filter(car -> car.hasSamePosition(winnerCar))
                .map(Car::changeToDto)
                .collect(Collectors.toList());
    }

    private Car findWinnerCar() {
        Collections.sort(cars);
        return cars.get(0);
    }
}
