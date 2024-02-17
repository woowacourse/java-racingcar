package racingcar.domain;

import java.util.List;
import racingcar.dto.CarPerformance;

public class Car {

    private static final int REQUIRED_OIL = 4;
    private static final String INVALID_CAR_NAME_LENGTH = "이름은 1자 이상 5자 이내로 입력해 주세요.";
    private static final String DUPLICATED_CAR_NAME = "중복된 자동차 이름이 존재합니다.";

    private final String name;
    private int movedDistance = 0;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
    }

    public static void validateUniqueCarNames(List<Car> cars) {
        int uniqueCarNamesCount = (int)cars.stream()
                .map(car -> car.name)
                .distinct()
                .count();

        if (uniqueCarNamesCount != cars.size()) {
            throw new IllegalArgumentException(DUPLICATED_CAR_NAME);
        }
    }

    public static int findMaxDistance(List<Car> cars) {
        return cars.stream()
                .mapToInt(car -> car.movedDistance)
                .max()
                .orElseThrow(IllegalStateException::new);
    }

    public static List<String> mapCarsToName(List<Car> cars) {
        return cars.stream()
                .map(car -> car.name)
                .toList();
    }

    private void validateNameLength(String name) {
        if (name.length() > 5 || name.isEmpty()) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH);
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
}
