package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarPositionDto;

public class CarContainer {

    public static final int MIN = 0;
    private static final int GO = 4;
    private static final String NAME_DELIMITER = ",";

    private final List<Car> cars;
    private final NumberPicker numberPicker;

    public CarContainer(String carNames, NumberPicker numberPicker) {
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

    public List<CarPositionDto> toDto() {
        return cars.stream()
                .map(Car::toDto)
                .collect(Collectors.toList());
    }

    public List<String> findWinner() {
        int max = findMaxPosition();
        return cars.stream()
                .filter(car -> car.matchPosition(max))
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    private int findMaxPosition() {
        int max = MIN;
        for (Car car : cars) {
            max = Math.max(car.getPosition(), max);
        }
        return max;
    }
}
