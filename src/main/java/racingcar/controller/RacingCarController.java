package racingcar.controller;

import racingcar.domain.ParticipatedCars;
import racingcar.domain.WinnerNames;
import racingcar.util.BoundedRandomNumberGenerator;
import racingcar.util.StringUtil;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private static final int MAX_BOUND = 9;
    private static final int MIN_BOUND = 0;

    public void playGame() {
        ParticipatedCars participatedCars = new ParticipatedCars(StringUtil.getCarNames(InputView.inputCarNames()));

        int trialCount = StringUtil.getTrialCount(InputView.inputTrials());

        executeRacingAndPrintRecord(trialCount, participatedCars);
        OutputView.printWinnerNames(WinnerNames.of(participatedCars));
    }

    private void executeRacingAndPrintRecord(int trialCount, ParticipatedCars participatedCars) {
        OutputView.printResultMessage();
        for (int i = 0; i < trialCount; i++) {
            participatedCars.tryToMoveBy(new BoundedRandomNumberGenerator(MAX_BOUND, MIN_BOUND));
            OutputView.printRacingRecords(participatedCars);
        }
    }
}
