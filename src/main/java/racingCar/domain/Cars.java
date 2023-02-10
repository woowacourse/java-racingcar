package racingCar.domain;

import racingCar.dto.CarDto;
import racingCar.util.NumberGenerator;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {

    private static final int MIN_CAR_SIZE = 2;

    List<Car> cars;

    public Cars(List<String> names) {
        validateDuplicate(names);
        validateSize(names);

        this.cars = names.stream()
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
        for (Car car : cars) {
            int pickedNumber = numberGenerator.generateNumber();
            car.move(pickedNumber);
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(this.cars);
    }


    public List<String> findWinners() {
        int maxPosition = findMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    // TODO: getter 사용 지양을 위한 리팩터링
    public int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public List<CarDto> toDtos() {
        return cars.stream()
                .map(Car::toDto)
                .collect(Collectors.toList());
    }
}
