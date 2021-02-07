package racingcar.domain;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRacingBeforeSetter {
    private final GetInputFromUser getInputFromUser;
    private final CarRepository carRepository;
    private int racingTryTime;

    public CarRacingBeforeSetter(Scanner scanner, CarRepository carRepository) {
        this.getInputFromUser = new GetInputFromUser(scanner);
        this.carRepository = carRepository;
    }

    public CarRacingBeforeSetter(Scanner scanner) {

    }

    public void set() {
        List<String> carNames = getInputFromUser.getInputCarNamesFromUser();
        int racingTryTime = getInputFromUser.getInputRacingTryTimeFromUser();
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
