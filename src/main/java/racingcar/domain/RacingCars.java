package racingcar.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.controller.RacingCarDto;

public class RacingCars {

    private static final String CAR_NAME_DELIMITER = ",";
    private static final String NAME_BLANK = " ";
    private static final String NAME_NOT_BLANK = "";

    private final List<RacingCar> cars;
    private final RacingCarCommander commander = new RacingCarCommander();

    public RacingCars(String carStringNames) {
        this.cars = makeRacingCars(carStringNames.split(CAR_NAME_DELIMITER));
    }

    private List<RacingCar> makeRacingCars(String[] carNames) {
        return Arrays.stream(carNames)
            .map(this::removeNameBlank)
            .map(RacingCar::new)
            .collect(Collectors.toList());
    }

    private String removeNameBlank(String name) {
        return name.replaceAll(NAME_BLANK, NAME_NOT_BLANK);
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
        cars.forEach(this::moveCar);
    }

    private void moveCar(RacingCar car) {
        car.moveByCommand(commander.isMovable());
    }

    public List<String> searchWinnerNames() {
        RacingCar anyWinner = searchAnyWinner();
        return cars.stream()
            .filter(car -> car.samePosition(anyWinner))
            .map(RacingCar::getName)
            .collect(Collectors.toList());
    }

    private RacingCar searchAnyWinner() {
        RacingCar anyWinner = cars.get(0);
        for(RacingCar car : cars) {
            if(car.isGreaterPosition(anyWinner)) {
                anyWinner = car;
            }
        }
        return anyWinner;
    }
}
