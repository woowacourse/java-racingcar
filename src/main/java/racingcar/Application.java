package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.model.Cars;
import racingcar.view.InputView;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cars cars = InputView.getCars(scanner);
        int attemptNumber = InputView.getAttemptNumber(scanner);

        RacingGameController racingGame = new RacingGameController();
        racingGame.play(cars, attemptNumber);
    }

}
