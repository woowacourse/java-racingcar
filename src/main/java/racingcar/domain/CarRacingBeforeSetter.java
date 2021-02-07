package racingcar.domain;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRacingBeforeSetter {
    private final ValidInputFromUserGetter validInputFromUserGetter;
    private final CarRepository carRepository;
    private int racingTryTime;

    public CarRacingBeforeSetter(Scanner scanner, CarRepository carRepository) {
        this.validInputFromUserGetter = new ValidInputFromUserGetter(scanner);
        this.carRepository = carRepository;
    }

    public void set() {
        List<String> carNames = validInputFromUserGetter.getCarNames();
        racingTryTime = validInputFromUserGetter.getRacingTryTime();
        List<Car> cars = createCars(carNames);
        carRepository.saveAll(cars);
    }

    private List<Car> createCars(List<String> carNames) {
        return carNames.stream().map(Car::new).collect(Collectors.toList());
    }

    public int getRacingTryTime() {
        return racingTryTime;
    }
}
