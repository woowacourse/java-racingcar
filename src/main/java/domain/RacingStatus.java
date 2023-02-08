package domain;

import dto.RacingStatusDto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingStatus {
    private static final int GO = 4;
    private static final String NAME_DELIMITER = ",";
    private final List<Car> racingStatus;
    private final NumberPicker numberPicker;

    public RacingStatus(String carNames, NumberPicker numberPicker) {
        racingStatus = Arrays.stream(carNames.split(NAME_DELIMITER))
                .map(name -> new Car(name))
                .collect(Collectors.toList());

        this.numberPicker = numberPicker;
    }

    public void move() {
        for (Car car : racingStatus) {
            int number = numberPicker.pickNumber();

            if (number >= GO) {
                car.move();
            }
        }
    }

    public List<RacingStatusDto> toDto() {
        return racingStatus.stream()
                .map(Car::toDto)
                .collect(Collectors.toList());
    }
}
