package racingcar;

import racingcar.domian.RacingCar;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarApplication {
    public static void main(String[] args) {
        RacingCar game = new RacingCar();
        game.setUpPlayer(InputView.inputCarName());
        game.setUpRound(InputView.inputGameRound());

        OutputView.printNotice();

        game.startGame();

        OutputView.printResult(game.getResult());
    }
}
