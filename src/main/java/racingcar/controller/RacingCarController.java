package racingcar.controller;

import racingcar.constant.Message;
import racingcar.domain.Cars;
import racingcar.domain.Times;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class RacingCarController {
    private final InputView inputView;

    public RacingCarController(Scanner scanner) {
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

    public List<String> giveCarNames() {
        OutputView.printCarNamesRequest();
        return inputView.scanCarNames();
    }

    private Times giveTimes() {
        OutputView.printTimesRequest();
        return new Times(inputView.scanTimes());
    }

    public void playUntilDone(Cars cars, Times times) {
        while (times.hasTurn()) {
            cars.decideMovableCar(Collections.EMPTY_LIST);
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
            hyphens.append(Message.HYPHEN);
        }
        return hyphens;
    }
}
