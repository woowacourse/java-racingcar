package racingCar.domain;

import racingCar.dto.CarDto;
import racingCar.util.NumberGenerator;
import racingCar.util.RandomNumberGenerator;

import java.util.*;
import java.util.stream.Collectors;

public class CarGroup {

    private final NumberGenerator numberGenerator = new RandomNumberGenerator();

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

    public void moveCars(NumberGenerator numberGenerator) {
        for (Car car : carGroup) {
            int pickedNumber = numberGenerator.generateNumber();
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

    public List<CarDto> toCarDtos() {
        return carGroup.stream()
                .map(car -> car.toCarDto())
                .collect(Collectors.toList());
    }
}
