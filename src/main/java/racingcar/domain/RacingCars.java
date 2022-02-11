package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.controller.RacingCarDto;

public class RacingCars {

    private static final String CAR_NAME_DELIMITER = ",";
    private static final String NAME_BLANK = " ";
    private static final String NAME_NOT_BLANK = "";
    private static final int FIRST_ELEMENT = 0;

    private final List<RacingCar> cars;
    private final RacingCarCommander commander = new RacingCarCommander();

    public RacingCars(String carStringNames) {
        isEmpty(carStringNames);
        this.cars = makeRacingCars(carStringNames.split(CAR_NAME_DELIMITER));
    }

    private void isEmpty(String stringNames) {
        if(stringNames == null || stringNames.isEmpty()) {
            throw new IllegalArgumentException("자동차 입력 값이 존재해야한다.");
        }
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
            .filter(car -> car.isSamePosition(anyWinner))
            .map(RacingCar::getName)
            .collect(Collectors.toList());
    }

    private RacingCar searchAnyWinner() {
        checkCarsEmpty();
        RacingCar anyWinner = cars.get(FIRST_ELEMENT);
        for(RacingCar car : cars) {
            anyWinner = car.getGreaterPositionCar(anyWinner);
        }
        return anyWinner;
    }

    private void checkCarsEmpty() {
        if(cars.isEmpty()) {
            throw new RuntimeException("최소 1개의 자동차가 존재해야 한다.");
        }
    }

}
