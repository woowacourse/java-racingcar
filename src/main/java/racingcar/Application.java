package racingcar;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.RacingCarGame;
import racingcar.utils.SplitUtil;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        String carNamesInput = InputView.getCarNamesInput();
        String lapInput = InputView.getLap();

        Cars cars = new Cars(SplitUtil.splitCarNames(carNamesInput));
        RacingCarGame racingCarGame = new RacingCarGame();
        int laps = racingCarGame.validateLaps(lapInput);
        racingCarGame.race(cars, laps);

        OutputView.showWinners(cars);
        InputView.closeScanner();
    }

}
