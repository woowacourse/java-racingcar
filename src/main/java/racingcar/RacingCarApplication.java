package racingcar;

import racingcar.domian.RacingCar;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarApplication {
    public static void main(String[] args) {
        String playerNames = InputView.inputCarName();
        String round = InputView.inputGameRound();
        RacingCar game = new RacingCar(playerNames, round);

        OutputView.printNotice();

        game.startGame();

        OutputView.printResult(game.getResult());
    }
}
