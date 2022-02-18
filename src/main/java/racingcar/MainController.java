package racingcar;

import racingcar.domain.Game;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class MainController {

    public static void main(String[] args) {
        String carNames = InputView.getCarNames();
        String tryNo = InputView.getTryNo();

        Game game = new Game(carNames, tryNo);

        while(!game.isEnd()) {
            game.race();
            ResultView.printPosition(game.getCars());
        }

        ResultView.printWinners(game.getWinners());

    }
}
