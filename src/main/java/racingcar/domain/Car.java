package racingcar.domain;

import static racingcar.constant.ExceptionMessage.INVALID_CAR_NAME_LENGTH;

import java.util.List;
import racingcar.dto.CarPerformance;

public class Car {

    private static final int REQUIRED_OIL = 4;
    private final String name;
    private int movedDistance = 0;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > 5 || name.isEmpty()) {
            throw INVALID_CAR_NAME_LENGTH.getException();
        }
    }
    
    public void goIfOilEnough(int oil) {
        if (oil >= REQUIRED_OIL) {
            movedDistance++;
        }
    }

    public CarPerformance getCurrentPerformance() {
        return new CarPerformance(name, movedDistance);
    }

    public boolean isSameDistance(int distance) {
        return distance == movedDistance;
    }

    public static int findMaxDistance(List<Car> cars) {
        return cars.stream()
                .mapToInt(car -> car.movedDistance)
                .max()
                .getAsInt();
    }

    public static List<String> mapCarsToName(List<Car> cars) {
        return cars.stream()
                .map(car -> car.name)
                .toList();
    }
}
