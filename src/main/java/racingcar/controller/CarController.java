package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.service.CarService;
import racingcar.view.InputView;

public class CarController {

    private final InputView inputView;
    private final CarService carService;

    public CarController(final Scanner scanner) {
        inputView = new InputView(scanner);
        carService = new CarService();
    }

    public String scanCarNames() {
        return inputView.scanCarNames();
    }

    public List<Car> saveCars(final String carNames) {
        final String[] names = carService.splitCarNames(carNames);
        return Arrays.stream(names)
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
