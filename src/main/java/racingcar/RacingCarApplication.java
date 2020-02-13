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
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        Cars cars = makeCars();
        Round round = new Round(InputView.inputRound());

        OutputView.printFirstRoundResult(cars);
        while (!round.isFinal()) {
            cars.moveAll(randomNumberGenerator);
            round.next();
            OutputView.printRoundResult(cars);
        }
        WinningRule winningRule = cars.getWinningRule();
        List<Name> winnerNames = winningRule.decideWinners();
        OutputView.printWinnerNames(winnerNames);
    }

    private static Cars makeCars() {
        return new Cars(CarNameSplitter.split(InputView.inputNames()));
    }
}
