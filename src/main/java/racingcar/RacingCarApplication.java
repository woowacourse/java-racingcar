package racingcar;

import racingcar.controller.RacingCarManager;
import racingcar.model.Car;
import racingcar.model.InputManager;
import racingcar.view.OutputView;

public class RacingCarApplication {
    public static void main(String[] args) {
        RacingCarManager racingStart = new RacingCarManager();
        InputManager inputManager = new InputManager();
        racingStart.playRacingGame(inputManager.getRacingCar());
        printCar(racingStart, inputManager);
    }

    private static void printCar(RacingCarManager racingCarManager, InputManager inputManager) {
        OutputView.printResultMent();

        int gameCount = inputManager.getGameCount();
        for (int i = 0; i < gameCount; i++) {
            racingCarManager.moveRacingCar();
            printCarPosition(racingCarManager);
        }

        printWinner(racingCarManager);
    }

    private static void printCarPosition(RacingCarManager racingCarManager) {
        for (Car car : racingCarManager.getCars()) {
            OutputView.printCarPosition(car);
        }

        OutputView.printEmptyLine();
    }

    private static void printWinner(RacingCarManager racingCarManager) {
        OutputView.printCarWinners(racingCarManager.getRacingWinners());
    }

}