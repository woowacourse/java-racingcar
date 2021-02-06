package racingcar;

import racingcar.controller.RacingCarGame;
import racingcar.domain.Cars;
import racingcar.domain.Round;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Scanner;

/**
 * Application.java
 * 자동차 경주 게임
 *
 * @author Kimun Kim, github.com/tributetothemoon
 * @author TaeHyeok Lee , github.com/taelee42
 */
public class RacingCarApplication {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        InputView.setScanner(scanner);

        Cars cars = createCarsFromUser();
        Round round = createRoundFromUser();
        RacingCarGame racingCarGame = RacingCarGame.createNewGame(cars, round);
        racingCarGame.play();
    }

    private static Cars createCarsFromUser() {
        try{
            return Cars.of(InputView.getCarNames());
        }catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return createCarsFromUser();
        }
    }

    private static Round createRoundFromUser() {
        try{
            return Round.from(InputView.getRoundNumber());
        }catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return createRoundFromUser();
        }
    }
}
