package javaracingcar;

import javaracingcar.controller.GameController;
import javaracingcar.controller.InputController;
import javaracingcar.view.InputView;
import javaracingcar.view.OutputView;

import java.util.List;

public class RacingMain {
    public static void main(String[] args) {
        runApplication();
    }

    private static void runApplication() {
        boolean isDone = false;

        while (!isDone) {
            try {
                startGame();
                isDone = true;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private static void startGame() {
        List<String> carNames = InputController.getCarNames(InputView.receiveCarNamesFromUser());
        int trial = InputController.getTrial(InputView.receiveTrialFromUser());
        GameController.run(carNames,trial);
    }
}
