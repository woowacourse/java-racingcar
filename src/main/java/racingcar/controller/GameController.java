package racingcar.controller;

import racingcar.util.InputValidator;
import racingcar.view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GameController {
    public void run() {
        gameInit();
    }

    private void gameInit() {
        InputView.inputCarNames();
        Scanner scanner = new Scanner(System.in);
        String carNames = scanner.nextLine();
        splitCars(carNames);

    }

    public void splitCars(String carNames) {
        List<String> carNameList = Arrays.asList(carNames.split(","));
        InputValidator.validateCarName(carNameList);
    }
}
