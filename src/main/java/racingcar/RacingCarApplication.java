package racingcar;

import racingcar.domain.*;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

/**
 * 프로그램 실행 클래스
 *
 * @version 1.0.0
 * @author K.S.KIM
 * @author HyoChan
 * @since 2020/02/13
 */
public class RacingCarApplication {
    public static void main(String[] args) {
        try {
            Cars cars = makeCars();
            Round round = new Round(InputView.inputRound());
            OutputView.printFirstRoundResult(cars);
            runRound(cars, round);
            showWinnerNames(cars.getWinningRule());
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
        }
    }

    private static void runRound(Cars cars, Round round) {
        while (!round.isFinal()) {
            cars.moveAll();
            round.next();
            OutputView.printRoundResult(cars);
        }
    }

    private static Cars makeCars() {
        Cars cars = new Cars(CarNameSplitter.split(InputView.inputNames()));
        cars.setNumberGeneratorStrategy(new RandomNumberGeneratorStrategy());
        return cars;
    }

    private static void showWinnerNames(WinningRule winningRule) {
        List<Name> winnerNames = winningRule.decideWinners();
        OutputView.printWinnerNames(winnerNames);
    }
}
