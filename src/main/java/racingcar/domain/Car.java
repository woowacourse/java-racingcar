package racingcar.domain;

import static racingcar.constant.ExceptionMessage.INVALID_CAR_NAME;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.dto.CarPerformance;

public class Car {

    private final String name;
    private int movedDistance = 0;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw INVALID_CAR_NAME.getException();
        }
    }
    
    public void go() {
        if (isGoState()) {
            movedDistance++;
        }
    }

    private boolean isGoState() {
        return Randoms.pickNumberInRange(0, 9) > 3;
    }

    public CarPerformance getCurrentPerformance() {
        return new CarPerformance(name, movedDistance);
    }

    public String getName() {
        return name;
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
}
