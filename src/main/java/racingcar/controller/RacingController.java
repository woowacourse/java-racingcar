package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Times;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingController {
    private static final String HYPHEN = "-";

    private final InputView inputView;

    public RacingController(Scanner scanner) {
        this.inputView = new InputView(scanner);
    }

    public void run() {
        List<String> carNames = giveCarNames();
        Times times = giveTimes();

        Cars cars = new Cars(carNames);

        OutputView.printResultMessage();
        playUntilDone(cars, times);
        OutputView.printWinner(cars.giveWinners());
    }

    private List<String> giveCarNames() {
        OutputView.printCarNamesRequest();
        return inputView.scanCarNames();
    }

    private Times giveTimes() {
        OutputView.printTimesRequest();
        return new Times(inputView.scanTimes());
    }

    private void playUntilDone(Cars cars, Times times) {
        while (times.hasTurn()) {
            cars.decideMovableCar();
            OutputView.printResult(cars.extractNames(), extractHyphens(cars));
            times.reduce();
        }
    }

    private List<StringBuilder> extractHyphens(Cars cars) {
        List<StringBuilder> hyphens = new ArrayList<>();

        for (Integer position : cars.extractPositions()) {
            hyphens.add(drawHyphens(position));
        }
        return hyphens;
    }

    private StringBuilder drawHyphens(Integer position) {
        StringBuilder hyphens = new StringBuilder();

        for (int i = 0; i < position; i++) {
            hyphens.append(HYPHEN);
        }
        return hyphens;
    }
}
