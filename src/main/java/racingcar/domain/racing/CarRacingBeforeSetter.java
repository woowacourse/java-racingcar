package racingcar.domain.racing;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.CarRepository;
import racingcar.domain.input.ValidInputFromUserGetter;

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
        List<Car> cars = createCars(carNames);
        racingTryTime = validInputFromUserGetter.getRacingTryTime();
        carRepository.saveAll(cars);
    }

    private List<Car> createCars(List<String> carNames) {
        return carNames.stream()
            .map(Car::new)
            .collect(Collectors.toList());
    }

    public int getRacingTryTime() {
        return racingTryTime;
    }
}
