package racingcar.domain;

import racingcar.dto.RacingStatusDto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingStatus {
    public static final int MIN = 0;
    private static final int GO = 4;
    private static final String NAME_DELIMITER = ",";
    private final List<Car> cars;
    private final NumberPicker numberPicker;

    public RacingStatus(String carNames, NumberPicker numberPicker) {
        cars = Arrays.stream(carNames.split(NAME_DELIMITER))
                .map(Car::new)
                .collect(Collectors.toList());

        this.numberPicker = numberPicker;
    }

    public void moveCars() {
        for (Car car : cars) {
            move(car);
        }
    }

    private void move(Car car) {
        int number = numberPicker.pickNumber();
        if (number >= GO) {
            car.move();
        }
    }

    public List<RacingStatusDto> toDto() {
        return cars.stream()
                .map(Car::toDto)
                .collect(Collectors.toList());
    }

    public List<String> findWinner() {
        int max = findMax();
        //Todo : 이 부분 getter를 제거하고 싶은데 마땅한 방법이 떠오르지 않습니다. 좋은 해결책이 있을까요?
        return cars.stream()
                .filter(car -> car.getStatus() == max)
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    private int findMax() {
        int max = MIN;
        for (Car car : cars) {
            max = Math.max(car.getStatus(), max);
        }
        return max;
    }
}
