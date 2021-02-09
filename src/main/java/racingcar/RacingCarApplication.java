package racingcar;

import racingcar.controller.RacingCarGame;
import racingcar.domain.Cars;
import racingcar.domain.Round;
import racingcar.view.InputView;
import racingcar.view.OutputView;

/**
 * RacingCarApplication.java
 * 자동차 경주 게임
 *
 * @author Kimun Kim, github.com/tributetothemoon
 * @author TaeHyeok Lee , github.com/taelee42
 */
public class RacingCarApplication {
    public static InputView inputView = InputView.getInstance();
    public static OutputView outputView = OutputView.getInstance();

    public static void main(String[] arg) {

        Cars cars = createCarsFromUserInput();
        Round round = createRoundFromUserInput();
        RacingCarGame racingCarGame = RacingCarGame.createNewGame(cars, round);
        racingCarGame.play();
    }

    private static Cars createCarsFromUserInput() {
        try {
            return Cars.of(inputView.requestCarNames());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return createCarsFromUserInput();
        }
    }

    private static Round createRoundFromUserInput() {
        try {
            return Round.from(inputView.requestRoundNumber());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return createRoundFromUserInput();
        }
    }
}
