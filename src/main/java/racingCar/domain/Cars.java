package racingCar.domain;

import racingCar.dto.CarDto;
import racingCar.util.NumberPicker;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {

    private static final int MIN_CAR_SIZE = 2;
    private static final int INIT_CAR_POSITION = 0;
    private static final int MIN_NUMBER_RANGE = 0;
    private static final int MAX_NUMBER_RANGE = 9;

    private final List<Car> cars;

    public Cars(List<String> names) {
        validateDuplicate(names);
        validateSize(names);

        this.cars = names.stream()
                .map(carName -> new Car(carName, INIT_CAR_POSITION))
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

    public void move() {
        for (Car car : cars) {
            car.move(NumberPicker.pickNumberInRange(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE));
        }
    }

    public List<String> findWinners() {
        int maxPosition = findMaxPosition();
        return cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(INIT_CAR_POSITION);
    }

    public List<CarDto> toDtos() {
        return cars.stream()
                .map(Car::toDto)
                .collect(Collectors.toList());
    }
}
