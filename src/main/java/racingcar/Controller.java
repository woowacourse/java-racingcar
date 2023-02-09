package racingcar;

import racingcar.view.OutputView;

public class Controller {
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        try {
            RacingGame racingGame = new RacingGame();
            racingGame.playingGame();
            racingGame.viewResult();
        } catch (Exception error) {
            outputView.printError(error);
        }

    }

}
