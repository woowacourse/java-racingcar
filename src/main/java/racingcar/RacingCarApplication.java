package racingcar;

import racingcar.domian.RacingCar;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarApplication {
    public static void main(String[] args) {
        RacingCar game = new RacingCar();
        OutputView.printNotice();
        game.startGame();
        OutputView.printResult(game.getResult());
    }
}
