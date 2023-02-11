package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarPositionDto;

public class Cars {

    public static final int MIN = 0;
    private static final String NAME_DELIMITER = ",";
    private static final String NO_CAR_EXCEPTION = "차가 존재하지 않습니다";

    private final List<Car> cars;

    public Cars(List<String> carNames) {
        cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void moveCars(NumberPicker numberPicker) {
        for (Car car : cars) {
            move(car, numberPicker);
        }
    }

    private void move(Car car, NumberPicker numberPicker) {
        int power = numberPicker.pickNumber();
        car.move(power);
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
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException(NO_CAR_EXCEPTION));
    }
}
