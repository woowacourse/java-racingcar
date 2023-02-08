package domain;

import dto.RacingStatusDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingStatus {
    public static final int MIN = 0;
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

    public List<String> findWinner() {
        int max = findMax();

        List<String> winners = new ArrayList<>();
        for (Car car : racingStatus) {
            if (car.getStatus() == max) {
                winners.add(car.getCarName());
            }
        }

        return winners;
    }

    private int findMax() {
        int max = MIN;

        for (Car car : racingStatus) {
            max = Math.max(car.getStatus(), max);
        }
        return max;
    }
}
