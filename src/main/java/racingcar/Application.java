package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.RacingCarGame;
import racingcar.utils.SplitUtil;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        runApplicationUntilValid();
        InputView.closeScanner();
    }

    private static void runApplicationUntilValid() {
        try {
            runApplication();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            runApplicationUntilValid();
        }
    }

    private static void runApplication() {
        String carNamesInput = InputView.getCarNamesInput();
        String lapInput = InputView.getLap();

        RacingCarGame racingCarGame = new RacingCarGame(SplitUtil.splitCarNames(carNamesInput),
            lapInput);
        racingCarGame.race();

        OutputView.showWinners(racingCarGame.getWinners());
    }

}
