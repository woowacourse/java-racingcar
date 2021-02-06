package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.model.Cars;
import racingcar.view.InputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cars carsInGame = InputView.getUserCarInput(scanner);
        int trialNumber = InputView.getUserTrialNumberInput(scanner);

        RacingGameController racingGame = new RacingGameController();
        racingGame.play(carsInGame,trialNumber);
    }
}
