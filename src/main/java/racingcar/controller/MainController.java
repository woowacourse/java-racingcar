package racingcar.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarRepository;
import racingcar.utils.ErrorUtils;
import racingcar.view.ErrorMessages;
import racingcar.view.Main;

public class MainController {

    private static final Scanner scanner = new Scanner(System.in);

    public void run() {
        try {
            Main.printMainPage();
            String userInput = scanner.nextLine();
            splitNames(userInput);
        } catch (IllegalArgumentException e) {
            ErrorUtils.printError(e);
            run();
        }
    }

    public void splitNames(String names) {
        List<Car> cars = Arrays.stream(names.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
        validateNames(cars);
        CarRepository.addCars(cars);
    }

    private void validateNames(List<Car> cars) {
        validateMaxNameLength(cars);
        validateDuplicate(cars);
        validateNoName(cars);
    }

    private void validateMaxNameLength(List<Car> cars) {
        boolean exists = cars.stream()
                .anyMatch(car -> !checkMaxName(car));
        if (exists) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_NAME_LENGTH);
        }
    }

    private void validateDuplicate(List<Car> cars) {
        Set<String> carNames = new HashSet<>();
        boolean exists = cars.stream()
                .anyMatch(car -> !carNames.add(car.getName()));
        if (exists) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_DUPLICATE_NAMES);
        }
    }

    private void validateNoName(List<Car> cars) {
        boolean exists = cars.stream()
                .anyMatch(car -> car.getName().length() == 0);
        if (exists) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_NONAME);
        }
    }

    private boolean checkMaxName(Car car) {
        return Car.checkMaxName(car);
    }
}
