package racingcar.controller;

import racingcar.view.InputView;

import java.util.Scanner;

public class GameController {
    public void run() {
        gameInit();
    }

    private void gameInit() {
        InputView.inputCarNames();
        Scanner scanner = new Scanner(System.in);
        String carNames = scanner.nextLine();


    }
}
