package racingcar.controller;

import java.util.Scanner;
import racingcar.view.InputView;

public class CarController {

    private final InputView inputView;

    public CarController(Scanner scanner) {
        inputView = new InputView(scanner);
    }

    public String scanCarNames() {
        return inputView.scanCarNames();
    }
}
