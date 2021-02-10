package javaracingcar;

import javaracingcar.controller.GameController;
import javaracingcar.view.OutputView;

public class RacingMain {
    public static void main(String[] args) {
        runApplication();
    }

    private static void runApplication() {
        boolean isDone = false;
        while (!isDone) {
            isDone = init();
        }
    }

    private static boolean init() {
        try {
            GameController.startGame();
            return true;
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
        }

        return false;
    }
}
