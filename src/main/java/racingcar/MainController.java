package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.Game;
import racingcar.view.InputView;

public class MainController {

    public static void main(String[] args) {
        String[] carNames = InputView.getCarNames();
        int tryNo = InputView.getTryNo();
        Game game = new Game(carNames, tryNo);

        game.start();
    }
}
