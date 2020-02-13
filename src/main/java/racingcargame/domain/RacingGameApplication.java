package racingcargame.domain;

import racingcargame.view.InputView;
import racingcargame.view.OutputView;

public class RacingGameApplication {
    public static void main(String[] args) {
        String inputCarNames = InputView.inputCarNames();
        RacingCars racingCars = RacingCars.createRacingCars(inputCarNames);

        int tryNumberInput = InputView.inputTryNumber();
        TryLimitNumber tryLimitNumber = new TryLimitNumber(tryNumberInput);

        doMoveCycle(racingCars, tryLimitNumber);

        Winners winners = new Winners(racingCars.extractWinners());
        OutputView.printWinners(winners);
    }

    private static void doMoveCycle(RacingCars racingCars, TryLimitNumber tryLimitNumber) {
        OutputView.printHead();
        int tryNumber = 0;
        while (tryLimitNumber.isBiggerThan(tryNumber)) {
            racingCars.move();
            OutputView.printPosition(racingCars);
            tryNumber++;
        }
    }


}
