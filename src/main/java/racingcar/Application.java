package racingcar;

import java.util.Scanner;
import racingcar.controller.RacingGameController;
import racingcar.domain.Cars;
import racingcar.domain.TryNumber;
import racingcar.view.InputView;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cars cars = InputView.getCars(scanner);
        TryNumber tryNumber = InputView.getTryNumber(scanner);

        RacingGameController racingGame = new RacingGameController();
        racingGame.play(cars, tryNumber);
    }

}
