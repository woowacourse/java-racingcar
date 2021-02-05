package racingcar.controller;

import racingcar.domain.Times;
import racingcar.view.InputView;

import java.util.List;
import java.util.Scanner;

public class RacingCarController {
    private final InputView inputView;

    public RacingCarController(Scanner scanner) {
        this.inputView = new InputView(scanner);
    }

    public void run() {
        List<String> carNames = inputView.scanCarNames();
        Times times = getTimes();
    }

    private Times getTimes() {
        int times = inputView.scanTimes();
        return new Times(times);
    }
}
