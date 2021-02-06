package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Times;
import racingcar.service.CarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.Scanner;

public class RacingCarController {
    private final InputView inputView;
    private final CarService carService;

    public RacingCarController(Scanner scanner) {
        this.inputView = new InputView(scanner);
        this.carService = new CarService();
    }

    public void run() {
        OutputView.printCarNamesRequest();
        List<String> carNames = inputView.scanCarNames();
        OutputView.printTimesRequest();
        Times times = getTimes();

        Cars cars = new Cars(carNames);

        OutputView.printNewLine();
        OutputView.printResultMessage();

        while (!times.isZero()) {
            carService.decideMovableCar(cars, null);
            OutputView.printResult(cars);
        }

        OutputView.printWinner(cars);
    }

    private Times getTimes() {
        int times = inputView.scanTimes();
        return new Times(times);
    }
}
