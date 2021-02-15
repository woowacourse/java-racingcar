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

    public List<String> scanCarNames() {
        return inputView.scanCarNames();
    }

    public Times scanTimes() {
        return new Times(inputView.scanTimes());
    }
}
