package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.service.CarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarController {

    private final InputView inputView;
    private final CarService carService;

    public CarController(final Scanner scanner) {
        inputView = new InputView(scanner);
        carService = new CarService();
    }

    public String[] scanCarNames() {
        try {
            final String carNames = inputView.scanCarNames().trim();
            final String[] names = carService.splitCarNames(carNames);
            carService.checkValidateName(names);
            return names;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return scanCarNames();
        }
    }

    public int scanRacingCnt() {
        try {
            final String racingCnt = inputView.scanRacingCnt();
            carService.checkValidateNumber(racingCnt);
            return Integer.parseInt(racingCnt);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return scanRacingCnt();
        }
    }

    public List<Car> saveCars(final String[] names) {
        return Arrays.stream(names)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> race(List<Car> cars) {
        return carService.race(cars);
    }

    public void printResultInitMessage() {
        OutputView.printResultInitMessage();
    }

    public void printResult(final Map<String, Integer> carNameAndPositions) {
        OutputView.printResult(carNameAndPositions);
    }

    public List<String> getWinners(final List<Car> cars) {
        return carService.getWinners(cars);
    }

    public void printWinners(final List<String> winners) {
        OutputView.printWinners(winners);
    }
}
