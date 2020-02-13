package racingcargame.domain;

import racingcargame.view.InputView;
import racingcargame.view.OutputView;

public class RacingGameApplication {
    public static void main(String[] args) {
        RacingCars racingCars = inputRacingCars();

        TryLimitNumber tryLimitNumber = inputTryLimitNumber();

        doMoveCycle(racingCars, tryLimitNumber);

        Winners winners = new Winners(racingCars.extractWinners());
        OutputView.printWinners(winners);
    }

    private static RacingCars inputRacingCars() {
        try {
            String inputCarNames = InputView.inputCarNames();
            return RacingCars.createRacingCars(inputCarNames);
        } catch (RuntimeException e) {
            return inputRacingCars();
        }
    }

    private static TryLimitNumber inputTryLimitNumber() {
        try {
            int tryNumberInput = InputView.inputTryNumber();
            return new TryLimitNumber(tryNumberInput);
        } catch (RuntimeException e) {
            return inputTryLimitNumber();
        }

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
