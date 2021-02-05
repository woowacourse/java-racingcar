package javaracingcar;

import javaracingcar.controller.GameController;
import javaracingcar.controller.InputController;
import javaracingcar.view.InputView;
import javaracingcar.view.OutputView;

import java.util.List;

public class RacingMain {
    public static void main(String[] args) {
        try {
            start();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            start();
        }
    }

    private static void start() {
        List<String> carNames = InputController.getCarNames(InputView.receiveCarNamesFromUser());
        int trial = InputController.getTrial(InputView.receiveTrialFromUser());
        GameController.run(carNames,trial);
    }
}
