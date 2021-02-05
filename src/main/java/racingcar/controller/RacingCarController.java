package racingcar.controller;

import racingcar.view.InputView;

import java.util.Scanner;

public class RacingCarController {
    private final InputView inputView;

    public RacingCarController(Scanner scanner) {
        this.inputView = new InputView(scanner);
    }

    public void run() {
        System.out.println(inputView.scanCarNames());
    }
}
