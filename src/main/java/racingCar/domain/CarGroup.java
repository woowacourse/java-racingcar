package racingCar.domain;

import racingCar.util.NumberGenerator;
import racingCar.util.RandomNumberGenerator;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CarGroup {

    private final NumberGenerator numberGenerator = new RandomNumberGenerator();
    public static final int NUMBER_RANGE_MIN = 0;
    public static  final int NUMBER_RANGE_MAX = 9;

    List<Car> carGroup;

    public CarGroup(List<String> carNames) {
        validateDuplicate(carNames);

        this.carGroup = carNames.stream()
                .map(carName -> new Car(carName))
                .collect(Collectors.toList());
    }

    private void validateDuplicate(List<String> carNames) {
        Set<String> distinctNames = new HashSet<>(carNames);
        if (carNames.size() != distinctNames.size()) {
            throw new IllegalArgumentException("자동차 이름에 중복이 있을 수 없습니다.");
        }
    }

    public void moveCars(int start, int end) {
        for (Car car : carGroup) {
            int pickedNumber = numberGenerator.pickOneNumberInRange(start, end);
            car.move(pickedNumber);
        }
    }

    public List<Car> getCarGroup() {
        return Collections.unmodifiableList(this.carGroup);
    }

    public int getHighestPosition() {
        return carGroup.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException())
                .getPosition();
    }

    public List<String> findWinners() {
        int highestPosition = this.getHighestPosition();
        return carGroup.stream()
                .filter(car -> car.getPosition() == highestPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
