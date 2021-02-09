package racingcar;

import racingcar.controller.RacingCarGame;
import racingcar.domain.Cars;
import racingcar.domain.Round;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Scanner;

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

        Cars cars = createCarsFromUser();
        Round round = createRoundFromUser();
        RacingCarGame racingCarGame = RacingCarGame.createNewGame(cars, round);
        racingCarGame.play();
    }

    private static Cars createCarsFromUser() {
        try {
            return Cars.of(inputView.getCarNames());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return createCarsFromUser();
        }
    }

    private static Round createRoundFromUser() {
        try {
            return Round.from(inputView.getRoundNumber());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return createRoundFromUser();
        }
    }
}
