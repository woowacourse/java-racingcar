package racingCar.domain;

import racingCar.dto.CarDto;
import racingCar.util.NumberGenerator;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CarGroup {

    private static final int MIN_CAR_SIZE = 2;
    List<Car> carGroup;

    public CarGroup(List<String> carNames) {
        validateDuplicate(carNames);
        validateSize(carNames);

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

    private void validateSize(List<String> carNames) {
        if (carNames.size() < MIN_CAR_SIZE) {
            throw new IllegalArgumentException("자동차의 개수는 2개 이상으로 입력해주세요.");
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
