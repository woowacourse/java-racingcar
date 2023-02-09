package racingcar;

import racingcar.view.OutputView;

public class Application {
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        try {
            RacingCarApplication racingCarApplication = new RacingCarApplication();
            racingCarApplication.playingGame();
            racingCarApplication.printFinalResult();
        } catch (Exception error) {
            outputView.printError(error);
        }

    }

}
