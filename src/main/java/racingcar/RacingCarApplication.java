package racingcar;

import racingcar.domain.GameManager;
import racingcar.domain.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarApplication {

    public static void main(String[] args) {
        GameManager gameManager = new GameManager(
                new InputView(),
                new OutputView(),
                new RandomNumberGenerator());

        gameManager.playGame();
    }
}
