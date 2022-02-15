package racingcar;

import java.util.List;

import racingcar.domain.RacingCars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        racingGame.playGame();
    }
}
