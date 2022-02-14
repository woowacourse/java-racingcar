package racingcar.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.controller.RacingCarDto;

public class RacingCars {

    private static final String CAR_NAME_DELIMITER = ",";

    private final List<RacingCar> cars;

    public RacingCars(List<RacingCar> cars) {
        checkDuplicateName(cars);
        this.cars = cars;
    }

    private void checkDuplicateName(List<RacingCar> cars) {
        long distinctCount = cars.stream()
            .map(RacingCar::getName)
            .distinct()
            .count();
        if (cars.size() != distinctCount) {
            throw new IllegalArgumentException("자동차 이름은 중복되어 입력될 수 없다.");
        }
    }

    public static RacingCars from(String names) {
        List<RacingCar> cars = Arrays.stream(names.split(CAR_NAME_DELIMITER))
            .map(Name::createNotBlankName)
            .map(RacingCar::createRandomMoveCar)
            .collect(Collectors.toList());
        return new RacingCars(cars);
    }

    public List<String> getCarNames() {
        return cars.stream()
            .map(RacingCar::getName)
            .collect(Collectors.toList());
    }

    public List<RacingCarDto> getRacingCars() {
        return cars.stream()
            .map(RacingCarDto::from)
            .collect(Collectors.toList());
    }

    public void moveCars() {
        cars.forEach(RacingCar::move);
    }

    public List<String> calculateWinnerNames() {
        int winnerPosition = calculateWinnerPosition();
        return getWinnerNames(winnerPosition);
    }

    private int calculateWinnerPosition() {
        return Collections.max(cars.stream()
            .map(RacingCar::getPosition)
            .collect(Collectors.toList()));
    }

    private List<String> getWinnerNames(int winnerPosition) {
        return cars.stream()
            .filter(car -> car.comparePosition(winnerPosition))
            .map(RacingCar::getName)
            .collect(Collectors.toList());
    }
}
