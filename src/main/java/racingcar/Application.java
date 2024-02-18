package racingcar;

import racingcar.controller.GameController;
import racingcar.view.InputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        final List<String> carNames = InputView.inputRacingCars();
        final String tryCount = InputView.inputTryCount();

        final GameController gameController = new GameController(carNames, tryCount);
        gameController.play();
    }
}
