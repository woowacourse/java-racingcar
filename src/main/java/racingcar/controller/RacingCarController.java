package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Times;
import racingcar.service.CarService;
import racingcar.service.WinnerService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class RacingCarController {
    private final InputView inputView;
    private final CarService carService;
    private final WinnerService winnerService;

    public RacingCarController(Scanner scanner) {
        this.inputView = new InputView(scanner);
        this.carService = new CarService();
        this.winnerService = new WinnerService();
    }

    public void run() {
        List<String> carNames = getCarNames();
        Times times = getTimes();
        Cars cars = new Cars(carNames);

        OutputView.printResultMessage();

        playUntilDone(cars, times);

        List<String> winnerNames = winnerService.getWinnerNames(cars);
        OutputView.printWinner(winnerNames);
    }

    public List<String> getCarNames() {
        OutputView.printCarNamesRequest();
        return inputView.scanCarNames();
    }

    private Times getTimes() {
        OutputView.printTimesRequest();
        return new Times(inputView.scanTimes());
    }

    public void playUntilDone(Cars cars, Times times) {
        while (!times.isZero()) {
            carService.decideMovableCar(cars, Collections.EMPTY_LIST);
            OutputView.printResult(cars);
            times.reduce();
        }
    }
}
