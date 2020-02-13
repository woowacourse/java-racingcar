package racingcar;

import racingcar.domian.RacingCar;
import racingcar.view.OutputView;

public class RacingCarApplication {
    public static void main(String[] args) {
        RacingCar game = new RacingCar();
        game.setUpPlayer();
        game.setUpRound();
        OutputView.printNotice();
        game.startGame();
        OutputView.printResult(game.getResult());
    }
}
